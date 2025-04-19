package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;

public class InanimateCard extends SummonableCard
{
    public InanimateCard(String name)
    {
        super(name, CardType.INANIMATE);
        this.isPlayable = true;
    }
}
