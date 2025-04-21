package src.game_objects.game.player;
import java.util.ArrayList;
import src.game_objects.cards.SummonableCard;

public class Battlefield
{   
    public int maxSize = 4;

    ArrayList<SummonableCard> frontline = new ArrayList<>();
    ArrayList<SummonableCard> backline = new ArrayList<>();

    public int entityAmount() {return frontline.size() + backline.size();}
    public void addToFrontline(SummonableCard card) {frontline.add(card);};
    public void addToBackline(SummonableCard card) {backline.add(card);};

    
}