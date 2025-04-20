package src.game_objects.game.game_field;
import java.util.ArrayList;
import src.game_objects.cards.SummonableCard;

public class Battlefield
{   
    int maxSize;

    ArrayList<SummonableCard> frontline = new ArrayList<>();
    ArrayList<SummonableCard> backline = new ArrayList<>();

    public int entityAmount() {return frontline.size() + backline.size();}
}
