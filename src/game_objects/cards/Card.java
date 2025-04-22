package src.game_objects.cards;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.*;

public abstract class Card
{
    public Card(String name, CardType cardType)
    {
        CardData cardData = DataReader.getInstance().getCardData(name, cardType);
        this.name = cardData.name;
        this.description = cardData.description;
        this.element = cardData.element;
        this.cardType = cardType;
        this.isPlayable = false;
    }
    // General attributes (all cards)
    protected String name;
    protected String description;
    protected Element element;
    CardType cardType;
    protected boolean isPlayable;

    public String getName() {return this.name;}
    public String getDescription() {return this.description;}
    public Element getElement() {return this.element;}
    public CardType getCardType() {return this.cardType;}
    public boolean isPlayable() {return this.isPlayable;}

    @Override
    public String toString()
    {
        return this.name;
    }
}
