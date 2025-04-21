package src.game_objects.effects;
import src.game_objects.effects.concrete_effects.*;

public class EffectFactory {
    public static Effect build(String className) {
        Effect effect = null;
        switch (className) {
            case "DamageSingleEnemyEffect" -> {effect = new DamageSingleEnemyEffect();}
            case "SelfHealEffect" -> {effect = new SelfHealEffect();}
            default -> {throw new IllegalArgumentException("Such an effect does not exist or has not been implemented in EffectFactory");}
        }
        return effect;
    }
}
