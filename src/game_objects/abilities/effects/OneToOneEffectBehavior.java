package src.game_objects.abilities.effects;
import src.game_objects.cards.EntityCard;
import src.game_objects.game.GameContext;

public interface OneToOneEffectBehavior
{
    /** 
     * Execute the ability.  
     * @param source   the card that owns this ability  
     * @param target   whatever the ability is targeting  
     * @param game     the game state/context 
     */
    void execute(EntityCard source, EntityCard target, GameContext game);
}
