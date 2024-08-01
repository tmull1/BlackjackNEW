package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckActions {

    private List<Card> myCards;
    private int numCards;

    public Deck() {
        this.myCards = new ArrayList<>();
        this.numCards = 0;
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = Suits.getSuits();
        String[] values = Values.getValues();
        for (String suit : suits) {
            for (String value : values) {
                this.myCards.add(new Card(suit, value));
                this.numCards++;
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(myCards);
    }

    @Override
    public Card dealNextCard() {
        if (numCards == 0) {
            return null;
        }
        Card dealtCard = myCards.remove(numCards - 1);
        numCards--;
        return dealtCard;
    }

    @Override
    public void printDeck(int numToPrint) {
        for (int i = 0; i < numToPrint && i < numCards; i++) {
            System.out.println(myCards.get(i));
        }
    }
}

