package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;

public class DebuffCard extends AttachableCard
{
    public DebuffCard(String name)
    {
        super(name, CardType.DEBUFF);
        this.isPlayable = false;
    }
}
