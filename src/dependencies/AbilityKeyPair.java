package src.dependencies;
import src.game_objects.cards.ability_cards.attributes.AbilityType;

public record AbilityKeyPair(String abilityName, String cardName, AbilityType abilityType) {}