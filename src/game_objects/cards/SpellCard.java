package src.game_objects.cards;
import src.game_objects.cards.ability_cards.attributes.TargetCardType;
import src.game_objects.cards.attributes.CardType;

public class SpellCard extends ConsumableCard
{
    public SpellCard(String name)
    {
        super(name, CardType.SPELL);
        this.isPlayable = true;
    }

    TargetCardType targetCardType;

    public TargetCardType getTargetCardType() {return targetCardType;}
}