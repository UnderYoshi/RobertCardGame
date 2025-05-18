package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;

public class StatusEffectCard extends AttachableCard
{
    public StatusEffectCard(String name)
    {
        super(name, CardType.STATUS_EFFECT);
        this.isPlayable = false;
    }
}
