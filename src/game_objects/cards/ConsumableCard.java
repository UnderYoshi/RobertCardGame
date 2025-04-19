package src.game_objects.cards;
import java.util.HashMap;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.*;

abstract class ConsumableCard extends AttachableCard implements HasRarity
{   
    ConsumableCard(String name, CardType cardType)
    {
        super(name, cardType);
        CardData cardData = DataReader.getInstance().getCardData(name, cardType);
        this.consumableType = cardData.consumableType;
        this.rarity = cardData.rarity;
        this.energyCost = cardData.energyCost;
        this.starCost = cardData.starCost;
    }
    ConsumableType consumableType;
    Rarity rarity;
    HashMap<Element, Integer> energyCost = new HashMap<>(); // TODO: MAKE FINAL AND ADD ELEMENTS SEPERATELY IN CONSTRUCTOR
    int starCost;

    public ConsumableType getConsumableType() {return this.consumableType;}
    public int getStarCost() {return this.starCost;}
    @Override
    public Rarity getRarity() {return this.rarity;}
    public HashMap<Element, Integer> getEnergyCost() {return this.energyCost;}
    
}
