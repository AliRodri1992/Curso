package com.kadasoftware;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Dark on 17/05/2017.
 */
public class Card {
    private final Random randomGenerator = new Random();

    public Queue<String> takeCard(Queue<String> cards, Integer quantityTakeCards){
        if(quantityTakeCards < cards.size()){
            if(!cards.isEmpty()){
                for (int i=0; i < quantityTakeCards; i++){
                    System.out.println("Sacaste la carta: " + cards.poll());
                }
            }
            else{
                System.out.println("\nBaraja vacia");
            }
        }
        else{
            System.out.println("\nExcediste el limite de cartas a tomar");
        }
        return cards;
    }

    public Queue<String> shuffleCards(String []baraja){
        Queue<String> cards= new LinkedList<String>();
        Integer cantidadCartas= baraja.length;
        Queue<Integer> randomNumber= generateRandomNumber(cantidadCartas);
        for(int count=0; count < cantidadCartas; count++){
            cards.add(baraja[randomNumber.poll()]);
        }
        return cards;
    }
    private Queue<Integer> generateRandomNumber(Integer cantidad){
        Queue<Integer>randomNumbers= new LinkedList<Integer>();
        Integer auxiliar;
        for(int i=0; i < cantidad; i++){
            if(randomNumbers.isEmpty()){
                auxiliar= randomGenerator.nextInt(cantidad);
                randomNumbers.add(auxiliar);
            }
            else{
                auxiliar= randomGenerator.nextInt(cantidad);
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
