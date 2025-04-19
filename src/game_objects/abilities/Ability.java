package src.game_objects.abilities;
import src.game_objects.abilities.attributes.AbilityType;

public abstract class Ability {
    Ability(String abilityName, String cardName, AbilityType abilityType)
    {
        this.name = abilityName;
        this.abilityType = abilityType;
    }
    String name;
    AbilityType abilityType;

    public String getName() {return this.name;}
    public AbilityType getAbilityType() {return this.abilityType;}
}
