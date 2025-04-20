package src.game_objects.cards;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.CardType;

public abstract class AttachableCard extends Card
{
    public AttachableCard(String name, CardType cardType)
    {
        super(name, cardType);
        CardData cardData = DataReader.getInstance().getCardData(name, cardType);
        this.turnTimer = cardData.turnTimer;
    }
    int turnTimer;
 
    public int getTurnTimer() {return this.turnTimer;}
}
