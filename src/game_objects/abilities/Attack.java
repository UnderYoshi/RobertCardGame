package src.game_objects.abilities;
import src.game_objects.abilities.attributes.AbilityType;

public class Attack extends Ability {
    Attack(String abilityName, String cardName)
    {
        super(abilityName, cardName, AbilityType.ATTACK);
    }
}
