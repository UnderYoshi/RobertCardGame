package src;

import src.game_objects.cards.Card;
import src.game_objects.deck.Deck;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (Card card : deck)
        {  
            System.out.println(card.toString() + " attributes:");
            System.out.println("    -" + card.getDescription() + "-");
            System.out.println("    -" + card.getCardType() + "-");
            System.out.println("    -" + card.getElement() + "-");
        }
    }
}
