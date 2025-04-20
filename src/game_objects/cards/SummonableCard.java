package src.game_objects.cards;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.CardType;

public abstract class SummonableCard extends EntityCard
{
    SummonableCard(String name, CardType cardType)
    {
        super(name, cardType);
        CardData cardData = DataReader.getInstance().getCardData(name, cardType);
        this.starCost = cardData.starCost;
    }
    int starCost;

    public int getStarCost() {return this.starCost;}
}