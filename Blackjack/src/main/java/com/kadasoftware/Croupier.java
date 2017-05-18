package com.kadasoftware;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dark on 17/05/2017.
 */
public class Croupier {
    private Queue<Card> hand;
    private Integer totalAmount;
    private Integer totalAmountHand;
    private Queue<Integer> valueHand;
    private static final Integer ZERO= 0;

    Croupier(Deck deck){
        String aCards;
        hand= new LinkedList<Card>();
        totalAmountHand= 0;
        valueHand= new LinkedList<Integer>();
        for (int i= ZERO; i < 2; i++){
            hand.add(deck.takeCard());
        }

        for (int i= ZERO; i < hand.size(); i++){
            Card aCard= hand.poll();
            aCards= aCard.toString();
            valueHand.add(aCard.valueCard(aCards));
            hand.add(aCard);
        }
        totalAmountHand= calculateTotalAmount();
    }

    //Pide carta
    public void Hit(Deck deck){
        Card card= deck.takeCard();
        String aCard= card.toString();
        hand.add(card);
        valueHand.add(card.valueCard(aCard));
    }

    //Calcula valor de la mano del jugador
    public Integer calculateTotalAmount(){
        String aHand;
        totalAmount= ZERO;
        Integer value= ZERO;
        Integer lengthHand= valueHand.size();
        for (int i= ZERO; i < lengthHand; i++){
            value= valueHand.poll();
            totalAmount+= value;
            valueHand.add(value);
        }

        for (int i= ZERO; i < lengthHand; i++){
            Card card= hand.poll();
            String aCard= card.toString();
            value= valueHand.poll();
            if (aCard.indexOf("As") != -1){
                if (totalAmount >21){
                    totalAmount= totalAmount-11;
                    value= 1;
                    totalAmount+= value;
                }
            }
            hand.add(card);
            valueHand.add(value);
        }

        return totalAmount;
    }

    //Muestra la Primera Carta del Croupier
    public void showFirstCard(){
        System.out.println(hand.peek());
    }

    //Muestra la mano del croupier
    public void showHand(){
        System.out.println(hand);
    }

    //El crupier está sujeto a pedir carta siempre que su puntuación sume 16 o menos
    public boolean wantsToHit(){
        if(totalAmountHand < 17){
            return true;
        }
        return false;
    }

    //el croupíer esta obligado a plantarse si su puntuacion suma 17 o más
    public boolean wantToStand(){
        if(totalAmount > 17){
            return true;
        }
        return false;
    }

    //Croupier gana Blackjack si solo tiene 2 cartas y suman un total de 21
    public boolean hasBlackjack(){
        if(hand.size() == 2 && totalAmountHand == 21){
            System.out.println("Croupier - Blackjack");
            return true;
        }
        return false;
    }

    //verifica si el croupier se excedio
    public boolean busted(){
        if (totalAmountHand > 21){
            System.out.println("Croupier pierde");
            return true;
        }
        return false;
    }

    //turno del croupier
    public Integer takeTurn(Deck deck){
        while (wantsToHit()){
            System.out.println("Croupier solicita");
            Hit(deck);
            totalAmountHand= calculateTotalAmount();
            if (busted()){
                break;
            }
        }
        if (totalAmountHand <= 21){
            System.out.println("Croupier se retira");
        }
        return totalAmountHand;
    }
}
