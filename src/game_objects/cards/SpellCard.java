package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;

public class SpellCard extends ConsumableCard
{
    SpellCard(String name)
    {
        super(name, CardType.SPELL);
        this.isPlayable = true;
    }
}
