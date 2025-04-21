package src.game_objects.cards;
import java.util.ArrayList;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.CardType;
import src.game_objects.effects.Effect;
import src.game_objects.effects.HasEffects;

public abstract class AttachableCard extends Card implements HasEffects
{
    public AttachableCard(String name, CardType cardType)
    {
        super(name, cardType);
        CardData cardData = DataReader.getInstance().getCardData(name, cardType);
        this.turnTimer = cardData.turnTimer;
        this.effects = new ArrayList<>();
        this.effects.addAll(cardData.effects);
    }
    int turnTimer;
    ArrayList<Effect> effects;
    
    @Override
    public ArrayList<Effect> getEffects() {return this.effects;}
    public int getTurnTimer() {return this.turnTimer;}
}
