package src.game_objects.effects.concrete_effects;
import java.util.HashMap;
import src.game_objects.cards.EntityCard;
import src.game_objects.effects.SelfEffect;

// Restores an amount of health
public class SelfHealEffect extends SelfEffect {
    @Override
    public void execute(EntityCard source, HashMap<String, Integer> args) {
        source.heal(args.get("healAmount"));
    }
    
}
