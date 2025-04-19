package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;

public class ChampionCard extends EntityCard
{
    public ChampionCard(String name)
    {
        super(name, CardType.CHAMPION);
    }
}
