package com.kadasoftware;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Boolean busted= false;
    private static Integer cash;
    private static Integer option= 0;
    private static Integer waggerPlayer;
    public static void main( String[] args ) {
        System.out.println("Bienvenido, juguemos Blackjack!!!");
        System.out.println("Dinero Inicial: ");
        Scanner money= new Scanner(System.in);
        cash= money.nextInt();
        System.out.println("\nInicias con: $" + cash);

        while (cash > 0){
            Deck deck= new Deck();
            deck.shuffleDeck();
            Player player= new Player(deck);
            Croupier croupier= new Croupier(deck);

            System.out.println("Tu apuesta: ");
            waggerPlayer= player.waggerPlayer(cash);
            System.out.println("\nDinero: " + (cash-waggerPlayer));
            System.out.println("Dinero Apostado: " + waggerPlayer);
            System.out.println("\nTu mano: ");
            player.showHand();
            player.calculateTotalAmount();

            System.out.println("\nCroupier mostrara la primera carta de su mano");
            croupier.showFirstCard();
            while (option != 1 && busted != true) {
                System.out.println("\nMenu: ");
                System.out.println("1). Pedir");
                System.out.println("2). Plantarse");

                System.out.println("Elige: ");
                Scanner sc = new Scanner(System.in);
                Integer option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("1");
                        player.Hit(deck);
                        System.out.println("Mano Actual");
                        player.showHand();
                        if (player.calculateTotalAmount() > 21) {
                            System.out.println("Excediste");
                            losePlayer();
                            busted= true;
                        }

                        break;
                    case 2:
                        if (player.hasBlackjack() && croupier.hasBlackjack()) {
                            drawPlayer();
                        } else if (croupier.hasBlackjack()) {
                            System.out.println("Mano del Croupier");
                            croupier.showHand();
                            losePlayer();
                        } else if (player.hasBlackjack()) {
                            System.out.println("Ganaste x2 Dinero");
                            cash = cash + waggerPlayer;
                            winPlayer();
                        } else {
                            Integer croupierHand = croupier.takeTurn(deck);
                            System.out.println(croupierHand);
                            System.out.println("\nMano del Croupier:");
                            croupier.showHand();
                            if (croupierHand > 21) {
                                winPlayer();
                            } else {
                                Integer valueHandPlayer = 21 - player.calculateTotalAmount();
                                Integer valueHandCroupier = 21 - croupier.calculateTotalAmount();
                                if (valueHandPlayer == valueHandCroupier) {
                                    drawPlayer();
                                }
                                if (valueHandPlayer < valueHandCroupier) {
                                    winPlayer();
                                }
                                if (valueHandCroupier < valueHandPlayer) {
                                    losePlayer();
                                }
                            }
                        }
                        busted= true;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
            busted= false;
        }
        /**/
    }
    public static void losePlayer(){
        System.out.println("\nTu pierdes !!! :'(");
        cash-= waggerPlayer;
        System.out.println("Dinero: " + cash);
    }
    public  static void winPlayer(){
        System.out.println("\nTu ganas");
        cash+= waggerPlayer;
        System.out.println("Dinero: " + cash);
    }
    public static void drawPlayer(){
        System.out.println("Es un empate");
        System.out.println("Obtendras tu dinero devvuelta");
        System.out.println("Dinero: " + cash);
    }
}
