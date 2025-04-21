package src.game_objects.effects.concrete_effects;
import java.util.HashMap;
import src.game_objects.cards.EntityCard;
import src.game_objects.effects.OneToOneEffect;

// Restores an amount of health
public class DamageSingleEnemyEffect extends OneToOneEffect {
    @Override
    public void execute(EntityCard source, EntityCard target, HashMap<String, Integer> args) {
        target.damage(args.get("damage"));
    }
}