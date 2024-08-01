package org.example;

import java.util.Scanner;

public class Player {
    private Hand hand;
    private int balance;
    private Scanner scanner;

    public Player(int initialBalance) {
        this.hand = new Hand();
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public int getHandTotal() {
        return hand.calculateTotal();
    }

    public void printHand() {
        hand.printHand();
    }

    public void printHand(boolean hideFirstCard) {
        hand.printHand(hideFirstCard);
    }

    public boolean wantsToHit() {
        System.out.println("Choose an action: 1) Hit 2) Stand");
        int action = scanner.nextInt();
        return action == 1;
    }

    public void winBet(int amount) {
        balance += amount;
    }

    public void loseBet(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void resetHand() {
        this.hand = new Hand();
    }
}



