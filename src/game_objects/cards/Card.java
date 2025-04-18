package src.game_objects.cards;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Card
{
    // General attributes (all cards)
    public static enum Type{ANIMATE, INANIMATE, ENERGY, SPELL, FOOD};
    public static enum Rarity{COMMON, UNCOMMON, RARE, LEGENDARY};
    public static enum Element{NEUTRAL, FIRE, FOREST, RAIN, DREAM, STAR, CREATION};
    int power;
    String name;
    Type type;
    Rarity rarity;
    String description;
    final ArrayList<String> classes = new ArrayList<>();
    Element element;

    // Animate and Inanimate specific attributes
    int starCost;
    // Animate card specific attributes
    boolean isMagicUser;
    // Inanimate card specific attributes

    // Energy card specific attributes

    // Spell and food specific attributes
    public static enum SpellType{INSTANT, CHANNEL};
    public final HashMap<Element, Integer> energyCost = new HashMap<>();
    int turnDuration;
    SpellType spellType;

    // Spell card specific attributes

    // Food card specific attributes

    public Type getType() {return this.type;}
    public Rarity getRarity() {return this.rarity;}
    public String getName() {return this.name;}
    public int getPower() {return this.power;}
    public int getCost() {return this.starCost;}
    public String getDescription() {return this.description;}
    public ArrayList<String> getClasses() {return this.classes;}
    public boolean getMagicUserBool() {return this.isMagicUser;}

    @Override
    abstract public String toString();
}
