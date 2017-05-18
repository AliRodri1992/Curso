package com.kadasoftware;

import java.util.Scanner;

/**
 * Created by Dark on 17/05/2017.
 */
public class Card {
    private Integer club;
    private Integer rank;
    private static final Integer ZERO= 0;
    private String []clubs= {"Diamante","Trebol","Corazon","Pica"};
    private String []ranks= {"As","2","3","4","5","6","7","8","9","10","J","Q","K"};
    Card(Integer club, Integer values){
        this.club= club;
        this.rank= values;
    }

    public Integer valueCard(String card){
        Integer valueCard= 0;
        if(card.indexOf("As") != -1){
            valueCard= 11;
        }else{
            if (card.indexOf("10") != -1){
                valueCard= 10;
            }else if (card.indexOf("J") != -1){
                valueCard= 10;
            }else if (card.indexOf("Q") != -1){
                valueCard= 10;
            }else if (card.indexOf("K") != -1){
                valueCard= 10;
            }else {
                valueCard= Integer.valueOf(card.substring(0,1));
            }
        }
        return valueCard;
    }

    @Override
    public String toString() {
        return ranks[rank] + " de " + clubs[club];
    }
}
