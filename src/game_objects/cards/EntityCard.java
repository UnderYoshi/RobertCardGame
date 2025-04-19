package src.game_objects.cards;
import java.util.ArrayList;
import src.file_reader.DataReader;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.*;

abstract class EntityCard extends Card implements HasRarity
{
    public EntityCard(String name, CardType cardType)
    {
        super(name, cardType);
        CardData cardData = DataReader.getInstance().getCardData(name, cardType);
        this.rarity = cardData.rarity;
        this.maxPower = cardData.maxPower;
        this.power = this.maxPower;
        this.maxActionPoints = 1;
        this.actionPoints = this.maxActionPoints;
        this.classes = cardData.classes;
    }

    ArrayList<String> classes = new ArrayList<>(); // TODO: MAKE THIS FINAL AND MAKE CONSTRUCTOR ADD ALL ELEMENTS
    Rarity rarity;
    int maxPower;
    int actionPoints;
    int maxActionPoints;
    int power;

    public ArrayList<String> getClasses() {return this.classes;}
    @Override
    public Rarity getRarity() {return this.rarity;}
    public int getActionPoints() {return this.actionPoints;}
    public int getMaxActionPoints() {return this.maxActionPoints;}
    public int getMaxPower() {return this.maxPower;}
    public int getPower() {return this.power;}

    void heal (int health)
    {
        this.power = Math.min(this.power + health, maxPower);
    }

    void damage (int damage)
    {
        this.power = this.power - damage;
    }
}