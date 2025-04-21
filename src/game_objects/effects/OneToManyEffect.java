package src.game_objects.effects; 
import java.util.ArrayList;
import java.util.HashMap;
import src.game_objects.cards.EntityCard;

public abstract class OneToManyEffect extends Effect
{
    /** 
     * Execute the ability.  
     * @param source   the card that owns this ability  
     * @param target   whatever the ability is targeting (multiple) 
     * @param game     the game state/context 
     */
    public abstract void execute(EntityCard source, ArrayList<EntityCard> targets, HashMap<String, Integer> args);
    
}

