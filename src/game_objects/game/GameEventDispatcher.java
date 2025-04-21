package src.game_objects.game;
import java.util.ArrayList;
import java.util.List;
import src.game_objects.cards.Card;
import src.game_objects.game.player.PlayerContext;

public class GameEventDispatcher {
    private final List<GameEventListener> listeners = new ArrayList<>();

    public void register(GameEventListener listener) {
        listeners.add(listener);
    }
    public void unregister(GameEventListener listener) {
        listeners.remove(listener);
    }

    public void fire(GameEvent event, Card card, PlayerContext player) {
        // copy the list to avoid ConcurrentModification if listeners add/remove
        for (GameEventListener l : new ArrayList<>(listeners)) {
            l.onGameEvent(event, card, player);
        }
    }
}
