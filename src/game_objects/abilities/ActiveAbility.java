package src.game_objects.abilities;
import src.game_objects.abilities.attributes.AbilityType;

public class ActiveAbility extends Ability {
    ActiveAbility(String abilityName, String cardName)
    {
        super(abilityName, cardName, AbilityType.ACTIVE);
    }
}
