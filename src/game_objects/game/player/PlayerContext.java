package src.game_objects.game.player;
import java.util.ArrayList;
import src.game_objects.cards.Card;
import src.game_objects.cards.ChampionCard;
import src.game_objects.cards.EnergyCard;
import src.game_objects.deck.Deck;

public class PlayerContext {
    public PlayerContext(Deck deck, ChampionCard champion) {
        this.deck = deck;
        this.champion = champion;
    }

    Deck deck;
    ChampionCard champion;
    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> discardPile = new ArrayList<>();
    ArrayList<EnergyCard> energyField = new ArrayList<>();
    Battlefield battlefield = new Battlefield();

    int handSize = 10;

    public void drawCard() {
        if (hand.size() <= handSize) {
            hand.add(deck.drawSingle());
        } else {
            deck.drawSingle();
        }
    }

    public void drawCard(int amount) {
        if (hand.size() <= handSize) {
            hand.addAll(deck.drawMultiple(amount));
        } else {
            deck.drawMultiple(amount);
        }
    }

    public boolean canSummonCard() {return this.battlefield.entityAmount() < this.battlefield.maxSize;}



    public Deck getDeck() {return this.deck;}
    public ChampionCard getChampion() {return this.champion;}
    public ArrayList<Card> getHand() {return this.hand;}
    public ArrayList<Card> getDiscardPile() {return this.discardPile;}
    public ArrayList<EnergyCard> getEnergyField() {return this.energyField;}
    public Battlefield getBattlefield() {return this.battlefield;}
    public int getHandSize() {return this.handSize;}

}
