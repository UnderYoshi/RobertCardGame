package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;
import src.game_objects.cards.attributes.Element;

public class FoodCard extends ConsumableCard
{
    public FoodCard(String name)
    {
        super(name, CardType.FOOD);
        this.isPlayable = true;
        this.element = Element.NEUTRAL;
    }
}
