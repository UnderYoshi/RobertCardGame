package src.game_objects.cards.ability_cards;
import java.util.HashMap;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.AttachableCard;
import src.game_objects.cards.ability_cards.attributes.TargetCardType;
import src.game_objects.cards.attributes.*;

public abstract class AbilityCard extends AttachableCard
{   
    AbilityCard(String abilityName, String cardName, CardType cardType)
    {
        super(abilityName+";;;"+cardName, cardType);
        CardData cardData = DataReader.getInstance().getCardData(abilityName+";;;"+cardName, cardType);
        this.name = abilityName;
        this.castingSpeed = cardData.castingSpeed;
        this.energyCost = cardData.energyCost;
        this.isPlayable = false;

    }
    CastingSpeed castingSpeed;
    HashMap<Element, Integer> energyCost = new HashMap<>(); // TODO: MAKE FINAL AND ADD ELEMENTS SEPERATELY IN CONSTRUCTOR
    HashMap<String, Integer> args;
    TargetCardType targetCardType;

    public TargetCardType getTargetCardType() {return targetCardType;}
    public HashMap<String, Integer> getArgs() {return this.args;}
    public CastingSpeed getCastingSpeed() {return this.castingSpeed;}
    public HashMap<Element, Integer> getEnergyCost() {return this.energyCost;}
    
}
