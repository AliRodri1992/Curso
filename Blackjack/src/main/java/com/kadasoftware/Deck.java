package com.kadasoftware;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Dark on 17/05/2017.
 */
public class Deck {
    private Queue<Card> deck;
    private static final Integer ZERO= 0;
    private final Random randomGenerator= new Random();

    Deck(){
        deck= new LinkedList<Card>();
        for (int i= ZERO; i < 4; i++){
            for (int j= ZERO; j < 13; j++){
                deck.add(new Card(i, j));
            }
        }
    }

    public void shuffleDeck(){
        Integer lengthDeck= deck.size();
        Card []aDeck= new Card[lengthDeck];
        Queue<Integer> randomNumber= generateRandomNumber(lengthDeck);
        for (int i= ZERO; i < lengthDeck; i++){
            aDeck[i]= deck.poll();
        }

        for (int i= ZERO; i < lengthDeck; i++){
            Integer position= randomNumber.poll();
            deck.add(aDeck[position]);
        }
    }

    public Card takeCard(){
        if(!deck.isEmpty()){
            return deck.poll();
        }else{
            System.out.println("Baraja vacia");
            return null;
        }
    }
    private Queue<Integer> generateRandomNumber(Integer cantity){
        Queue<Integer> randomNumbers= new LinkedList<Integer>();
        Integer auxiliar;
        for (int i= ZERO; i< cantity; i++){
            if(randomNumbers.isEmpty()){
                auxiliar= randomGenerator.nextInt(cantity);
                randomNumbers.add(auxiliar);
            }else{
                auxiliar= randomGenerator.nextInt(cantity);
                if(!randomNumbers.contains(auxiliar)){
                    randomNumbers.add(auxiliar);
                }else{
                    i--;
                }
            }
        }
        return randomNumbers;
    }
}
