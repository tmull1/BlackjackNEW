package org.example;

import java.io.File;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        String filepath = "path/to/your/CasinoJazz.wav";

        File musicFile = new File(filepath);
        if (musicFile.exists()) {
            PlayMusic music = new PlayMusic();
            music.playMusic(filepath);
        } else {
            System.out.println("Music file not found at: " + filepath);
        }

        Scanner sc = new Scanner(System.in);

        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player(1000);
        Player dealer = new Player(0);

        int defaultBet = 1000;
        player.loseBet(defaultBet);

        player.addCardToHand(deck.dealNextCard());
        player.addCardToHand(deck.dealNextCard());
        dealer.addCardToHand(deck.dealNextCard());
        dealer.addCardToHand(deck.dealNextCard());

        boolean playerStands = false;
        boolean playerBusts = false;

        while (!playerStands && !playerBusts) {
            System.out.println("Player's hand:");
            player.printHand();
            System.out.println("Dealer's hand:");
            dealer.printHand(true);

            if (player.wantsToHit()) {
                player.addCardToHand(deck.dealNextCard());
                if (player.getHandTotal() > 21) {
                    playerBusts = true;
                }
            } else {
                playerStands = true;
            }
        }

        if (playerBusts) {
            System.out.println("Player busts! Dealer wins.");
        } else {
            while (dealer.getHandTotal() < 17) {
                dealer.addCardToHand(deck.dealNextCard());
            }

            System.out.println("Dealer's hand:");
            dealer.printHand(false);

            int playerTotal = player.getHandTotal();
            int dealerTotal = dealer.getHandTotal();

            if (dealerTotal > 21 || playerTotal > dealerTotal) {
                System.out.println("Player wins!");
                player.winBet(defaultBet * 2);
            } else if (playerTotal < dealerTotal) {
                System.out.println("Dealer wins.");
            } else {
                System.out.println("It's a tie.");
                player.winBet(defaultBet);
            }
        }

        System.out.println("Player's balance: " + player.getBalance());
        sc.close();
    }
}





