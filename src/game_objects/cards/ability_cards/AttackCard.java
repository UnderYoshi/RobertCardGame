package src.game_objects.cards.ability_cards;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.CardType;
import src.game_objects.cards.attributes.Element;

public class AttackCard extends AbilityCard
{

    public AttackCard(String abilityName, String cardName)
    {
        super(abilityName, cardName, CardType.ATTACK);
        CardData cardData = DataReader.getInstance().getCardData(abilityName+";;;"+cardName, CardType.ATTACK);

        this.element = Element.NEUTRAL;
    }
    
}
