package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int calculateTotal() {
        int total = 0;
        int aces = 0;

        for (Card card : hand) {
            String value = card.getValue();
            if (value.equals("2")) total += 2;
            else if (value.equals("3")) total += 3;
            else if (value.equals("4")) total += 4;
            else if (value.equals("5")) total += 5;
            else if (value.equals("6")) total += 6;
            else if (value.equals("7")) total += 7;
            else if (value.equals("8")) total += 8;
            else if (value.equals("9")) total += 9;
            else if (value.equals("10") || value.equals("Jack") || value.equals("Queen") || value.equals("King"))
                total += 10;
            else if (value.equals("Ace")) {
                total += 11;
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public void printHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
        System.out.println("Total: " + calculateTotal());
    }

    public void printHand(boolean hideFirstCard) {
        if (hideFirstCard) {
            System.out.println("[Hidden Card]");
            for (int i = 1; i < hand.size(); i++) {
                System.out.println(hand.get(i));
            }
        } else {
            printHand();
        }
    }
}

