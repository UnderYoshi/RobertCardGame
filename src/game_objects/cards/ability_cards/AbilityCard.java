package src.game_objects.cards.ability_cards;
import java.util.ArrayList;
import java.util.HashMap;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.AttachableCard;
import src.game_objects.cards.attributes.*;
import src.game_objects.effects.Effect;

public abstract class AbilityCard extends AttachableCard
{   
    AbilityCard(String abilityName, String cardName, CardType cardType)
    {
        super(abilityName+";;;"+cardName, cardType);
        CardData cardData = DataReader.getInstance().getCardData(abilityName+";;;"+cardName, cardType);
        this.castingSpeed = cardData.castingSpeed;
        this.energyCost = cardData.energyCost;
        this.isPlayable = false;

    }
    CastingSpeed castingSpeed;
    HashMap<Element, Integer> energyCost = new HashMap<>(); // TODO: MAKE FINAL AND ADD ELEMENTS SEPERATELY IN CONSTRUCTOR
    HashMap<String, Integer> args;
    ArrayList<Effect> effects;

    public ArrayList<Effect> getEffects() {return this.effects;}
    public HashMap<String, Integer> getArgs() {return this.args;}
    public CastingSpeed getCastingSpeed() {return this.castingSpeed;}
    public HashMap<Element, Integer> getEnergyCost() {return this.energyCost;}
    
}
