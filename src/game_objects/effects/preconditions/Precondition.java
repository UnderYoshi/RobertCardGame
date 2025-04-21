package src.game_objects.effects.preconditions;

abstract public class Precondition {
    Precondition(String name) {

    }
    abstract public boolean evaluate();
}
