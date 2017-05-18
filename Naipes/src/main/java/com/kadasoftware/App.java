package com.kadasoftware;

import java.util.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Ejercicio 3");
        Card  deck= new Card();
        String []cards=  {"As corazon","2 corazon","3 corazon","4 corazon","5 corazon","6 corazon","7 corazon","8 corazon","9 corazon","10 corazon","J corazon","Q corazon","K corazon", "As diamante","2 diamante","3 diamante","4 diamante","5 diamante","6 diamante","7 diamante","8 diamante","9 diamante","10 diamante","J diamante","Q diamante","K diamante","As trébol","2 trébol","3 trébol","4 trébol","5 trébol","6 trébol","7 trébol","8 trébol","9 trébol","10 trébol","J trébol","Q trébol","K trébol","As pica","2 pica","3 pica","4 pica","5 pica","6 pica","7 pica","8 pica","9 pica","10 pica","J pica","Q pica","K pica"};
        Queue<String> shuffleDeck= deck.shuffleCards(cards);
        System.out.println("\n");
        System.out.println(shuffleDeck);
        shuffleDeck= deck.takeCard(shuffleDeck,35);
        shuffleDeck= deck.takeCard(shuffleDeck,15);
        shuffleDeck= deck.takeCard(shuffleDeck,1);
        shuffleDeck= deck.takeCard(shuffleDeck,15);
        shuffleDeck= deck.takeCard(shuffleDeck,15);
        System.out.println("Quedan: " + shuffleDeck);
    }
}
