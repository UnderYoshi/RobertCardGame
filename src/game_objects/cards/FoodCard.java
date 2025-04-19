package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;

public class FoodCard extends ConsumableCard
{
    public FoodCard(String name)
    {
        super(name, CardType.FOOD);
        this.isPlayable = true;
    }
}
