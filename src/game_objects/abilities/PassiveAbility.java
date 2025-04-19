package src.game_objects.abilities;
import src.game_objects.abilities.attributes.AbilityType;

public class PassiveAbility extends Ability {
    PassiveAbility(String abilityName, String cardName)
    {
        super(abilityName, cardName, AbilityType.PASSIVE);
    }
}
