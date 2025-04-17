import java.util.*;

public class Deck extends ArrayList<Card> {

    public static enum Type {STANDARD52, STANDARD54, JOKERS4};
    public final Type type;

    public Deck(Type type) {
        this.type = type;

        switch(this.type) {
            case STANDARD52:
            for (PlayingCard.Suit suit: PlayingCard.Suit.values()) {
                for (PlayingCard.Rank rank: PlayingCard.Rank.values()) {
                    this.add(new PlayingCard(rank, suit));
                }
            }
            break;
            case STANDARD54:
            for (PlayingCard.Suit suit: PlayingCard.Suit.values()) {
                for (PlayingCard.Rank rank: PlayingCard.Rank.values()) {
                    this.add(new PlayingCard(rank, suit));
                }
            }
            this.add(new JokerCard(Card.Color.RED));
            this.add(new JokerCard(Card.Color.BLACK));
            break;
            case JOKERS4:
            this.add(new JokerCard(Card.Color.RED));
            this.add(new JokerCard(Card.Color.RED));
            this.add(new JokerCard(Card.Color.BLACK));
            this.add(new JokerCard(Card.Color.BLACK));
            break;
            default:
                this.add(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.SPADES));
                break;
          }
    }


    public void shuffle(int n, int m) {
        // Shuffles cards n through m (inclusive)
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Index n out of range");
        }
        if (m > (this.size() - 1) || n > (this.size() - 1)) {
            throw new IllegalArgumentException("Index m out of range");
        }
        if (n > m) {
            throw new IllegalArgumentException("m must be greater than n");
        }
        
        Random rand = new Random();

        ArrayList<Card> newCardOrder = new ArrayList<Card>();
        for (int i = m; i >= n; i--) {
            int nextCard = n + rand.nextInt(i - n + 1); //picks a card in range n, i
            newCardOrder.add(this.get(nextCard));
            this.remove(nextCard); //removes cards in range from original deck
        }
        this.addAll(n, newCardOrder);
    }

    public void shuffle() {
        // Shuffles all cards in deck
        Random rand = new Random();

        ArrayList<Card> newCardOrder = new ArrayList<Card>();
        for (int i = this.size() - 1; i >= 0; i--) {
            int nextCard = rand.nextInt(i + 1); //picks a card in range n, i
            newCardOrder.add(this.get(nextCard));
            this.remove(nextCard); //removes cards in range from original deck
        }
        this.addAll(0, newCardOrder);
    }

    public void print(int n, int m) {
        // Prints values of cards n through m (inclusive)
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Index n out of range");
        }
        if (m > (this.size() - 1) || n > (this.size() - 1)) {
            throw new IllegalArgumentException("Index m out of range");
        }
        if (n > m) {
            throw new IllegalArgumentException("m must be greater than n");
        }

        for (int i = n; i <= m; i++) {
            System.out.println(i + ": " + this.get(i).toString());
        }
    }

    public void print() {
        // Prints values of all cards
        for (int i = 0; i <= this.size() - 1; i++) {
            System.out.println(i + ": " + this.get(i).toString());
        }
    }

    public Card drawSingle() {
        Card card = this.get(0);
        this.remove(0);
        return card;
    }
    
    public ArrayList<Card> drawMultiple(int amount) {
        ArrayList<Card> cardsToDraw = new ArrayList<Card>();
        for (int i = 0; i < amount; i++) {
            cardsToDraw.add(this.get(0));
            this.remove(0);
        }
        return cardsToDraw;
    }

    public void putOnBottom(Card card) {
        this.add(card);
    }
    public void putOnBottom(ArrayList<Card> cards) {
        this.addAll(cards);
    }
}
