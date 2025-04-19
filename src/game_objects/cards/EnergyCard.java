package src.game_objects.cards;
import src.game_objects.cards.attributes.CardType;

public class EnergyCard extends Card
{
    public EnergyCard(String name) {
        super(name, CardType.ENERGY);
        this.isPlayable = true;
    }
}
