public class AnimateCard extends Card {

    public AnimateCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.type = Card.Type.PLAYING_CARD;
    }

    public String toString() {
        String string = rank.toString() + " of " + suit.toString();
        return string;
    }
}