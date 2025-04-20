package src.file_reader.card_data;
import java.util.ArrayList;
import java.util.HashMap;
import src.game_objects.cards.attributes.*;

public class CardData
{
    public String name;
    public CardType cardType;
    public Element element;
    public String description;
    public Rarity rarity;
    public ArrayList<String> classes;
    public ArrayList<String> abilities;
    public int turnTimer;
    public CastingSpeed castingSpeed;
    public HashMap<Element, Integer> energyCost;
    public int maxPower;
    public int starCost;

    // Ability exclusive
}