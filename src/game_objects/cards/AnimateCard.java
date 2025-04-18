package src.game_objects.cards;
import src.file_reader.CardData;
import src.file_reader.DataReader;

public class AnimateCard extends Card
{

    public AnimateCard(String name)
    {
        CardData cardData = DataReader.getInstance().getCardData(name);

        this.name = name;
        this.power = cardData.power;
        this.type = cardData.type;
        this.rarity = cardData.rarity;
        this.starCost = cardData.starCost;
        this.description = cardData.description;
        this.element = cardData.element;
        for (int i = 0; i < cardData.classes.size(); i++)
        {
            this.classes.add(cardData.classes.get(i));
        }

        // Animate card specific attributes
        this.isMagicUser = cardData.isMagicUser;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}