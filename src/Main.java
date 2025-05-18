package src;

import src.game_objects.cards.Card;
import src.game_objects.cards.SummonableCard;
import src.game_objects.deck.Deck;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (Card card : deck)
        {  
            System.out.println(card.toString() + " attributes:");
            System.out.println("    desctritption: -" + card.getDescription() + "-");
            System.out.println("    type: -" + card.getCardType() + "-");
            System.out.println("    elenenbt:: -" + card.getElement() + "-");
            if (card instanceof SummonableCard ec) {
                System.out.println("    rarity: -" + ec.getRarity() + "-");
                System.out.println("    starcost: -" + ec.getStarCost() + "-");
                System.out.println("    power: -" + ec.getPower() + "-");
                System.out.println("    class[0]: -" + ec.getClasses().get(0) + "-");
            }
        }
    }
}