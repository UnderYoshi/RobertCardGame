package src.game_objects.effects; 
import java.util.HashMap;
import src.game_objects.cards.EntityCard;

public abstract class OneToOneEffect extends Effect
{
    /** 
     * Execute the ability.  
     * @param source   the card that owns this ability  
     * @param target   whatever the ability is targeting  
     * @param game     the game state/context 
     */
    public abstract void execute(EntityCard source, EntityCard target, HashMap<String, Integer> args);
}
