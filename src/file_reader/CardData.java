package src.file_reader;
import java.util.ArrayList;
import src.game_objects.cards.Card;
public class CardData
{
    public int power;
    public String name;
    public Card.Type type;
    public Card.Rarity rarity;
    public Card.Element element;
    public int starCost;
    public String description;
    public final ArrayList<String> classes = new ArrayList<>();

    // Animate card specific attributes
    public boolean isMagicUser = false;
    // Inanimate card specific attributes

    // Energy card specific attributes

    // Spell card specific attributes

    // Food card specific attributes
}