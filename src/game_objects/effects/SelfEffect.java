package src.game_objects.effects; 

import java.util.HashMap;
import src.game_objects.cards.EntityCard;

public abstract class SelfEffect extends Effect
{
    /** 
     * Execute the ability.  
     * @param source   the card that owns this ability  
     * @param game     the game state/context 
     */
    public abstract void execute(EntityCard source, HashMap<String, Integer> args);
}
    
