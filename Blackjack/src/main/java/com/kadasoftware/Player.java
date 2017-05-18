package com.kadasoftware;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Dark on 17/05/2017.
 */
public class Player {
    private Queue<Card> hand;
    private Integer totalAmount;
    private Integer totalAmountHand;
    private Queue<Integer> valueHand;
    private static final Integer ZERO= 0;

    Player(Deck deck){
        String aCards;
        hand= new LinkedList<Card>();
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
        //totalAmountHand= calculateTotalAmount();
    }

    //Muestra la mano del jugador
    public void showHand(){
        System.out.println(hand);
    }

    public Integer waggerPlayer(Integer cash){
        Scanner sc= new Scanner(System.in);
        Integer waggerPlayer= sc.nextInt();
        while(waggerPlayer > cash){
            System.out.println("No puedes apostar mas del dinero que iniciaste");
            System.out.println("Apuesta Inicial: ");
            waggerPlayer= sc.nextInt();
        }
        return waggerPlayer;
    }

    //Calcula valor de la mano del jugador
    public Integer calculateTotalAmount(){
        String aHand;
        totalAmount= ZERO;
        Integer value= ZERO;
        Integer lengthHand= valueHand.size();
        for (int i= ZERO; i < lengthHand; i++){
            Card card= hand.poll();
            String aCard= card.toString();
            value= valueHand.poll();
            if (lengthHand != 2){
                if(aCard.indexOf("As") != -1){
                    System.out.println("Valor As: ");
                    Scanner as= new Scanner(System.in);
                    value= as.nextInt();
                }
            }
            hand.add(card);
            totalAmount+= value;
            valueHand.add(value);
        }
        return totalAmount;
    }

    //Jugador gana Blackjack si solo tiene 2 cartas y suman un total de 21
    public boolean hasBlackjack(){
        if(hand.size() == 2 && totalAmount == 21){
            System.out.println("Player - Blackjack");
            return true;
        }
        return false;
    }

    //Pide carta
    public void Hit(Deck deck){
        Card card= deck.takeCard();
        String aCard= card.toString();
        hand.add(card);
        valueHand.add(card.valueCard(aCard));
    }
}
