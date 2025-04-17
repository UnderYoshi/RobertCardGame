public abstract class Card
{
    public static enum Type{ANIMATE, INANIMATE, ENERGY, SPELL, FOOD};
    public static enum Rarity{COMMON, UNCOMMON, RARE, LEGENDARY};

    String name;
    Type type;
    Rarity rarity;
    int star_cost;


    public Type getType() {
        return type;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public String getName() {
        return name;
    }

    public boolean Valid() {
        return (name != null 
                && type != null 
                && rarity != null 
                && star_cost >= 1 
                && star_cost <= 4);
    }
    abstract public String toString();
}
