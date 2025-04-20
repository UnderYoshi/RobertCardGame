package src.game_objects.cards.ability_cards;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.CardType;

public class ActiveAbilityCard extends AbilityCard
{

    public ActiveAbilityCard(String abilityName, String cardName)
    {
        super(abilityName, cardName, CardType.ACTIVE_ABILITY);
        CardData cardData = DataReader.getInstance().getCardData(abilityName+";;;"+cardName, CardType.ACTIVE_ABILITY);
    }
    
}
