package src.game_objects.abilities.effects; 
import java.util.ArrayList;
import src.game_objects.cards.EntityCard;
import src.game_objects.game.GameContext;

public interface OneToManyEffectBehavior
{
    /** 
     * Execute the ability.  
     * @param source   the card that owns this ability  
     * @param target   whatever the ability is targeting (multiple) 
     * @param game     the game state/context 
     */
    void execute(EntityCard source, ArrayList<EntityCard> targets, GameContext game);
}

