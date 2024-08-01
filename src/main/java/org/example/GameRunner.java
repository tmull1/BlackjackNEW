package org.example;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {

        String filepath = "CasinoJazz.wav";
        PlayMusic music = new PlayMusic();
        music.playMusic(filepath);

        Scanner sc = new Scanner(System.in);


        Deck deck = new Deck();
        deck.shuffle();


        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();


        playerHand.addCard(deck.dealNextCard());
        playerHand.addCard(deck.dealNextCard());
        dealerHand.addCard(deck.dealNextCard());
        dealerHand.addCard(deck.dealNextCard());

        boolean playerStands = false;
        boolean playerBusts = false;


        while (!playerStands && !playerBusts) {
            System.out.println("Player's hand:");
            playerHand.printHand();
            System.out.println("Dealer's hand:");
            dealerHand.printHand(true);

            System.out.println("Choose an action: 1) Hit 2) Stand");
            int action = sc.nextInt();

            if (action == 1) {
                playerHand.addCard(deck.dealNextCard());
                if (playerHand.calculateTotal() > 21) {
                    playerBusts = true;
                }
            } else if (action == 2) {
                playerStands = true;
            }
        }

        if (playerBusts) {
            System.out.println("Player busts! Dealer wins.");
        } else {
            while (dealerHand.calculateTotal() < 17) {
                dealerHand.addCard(deck.dealNextCard());
            }

            System.out.println("Dealer's hand:");
            dealerHand.printHand(false);

            int playerTotal = playerHand.calculateTotal();
            int dealerTotal = dealerHand.calculateTotal();

            if (dealerTotal > 21 || playerTotal > dealerTotal) {
                System.out.println("Player wins!");
            } else if (playerTotal < dealerTotal) {
                System.out.println("Dealer wins!");
            } else {
                System.out.println("It's a tie!");
            }
        }

        sc.close();
    }
}


