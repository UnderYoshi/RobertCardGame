package src.game_objects.cards;
import src.game_objects.cards.attributes.*;

public class AnimateCard extends SummonableCard
{
    public AnimateCard(String name)
    {
        super(name, CardType.ANIMATE);
        this.isMagicUser = (this.element != Element.NEUTRAL);
        this.isPlayable = true;
    }

    boolean isMagicUser;

    public boolean isMagicUser() {return this.isMagicUser;}
}