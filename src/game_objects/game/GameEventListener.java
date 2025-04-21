package src.game_objects.game;
import src.game_objects.cards.Card;
import src.game_objects.game.player.PlayerContext;

public interface GameEventListener {
    /**
     * Called by the dispatcher whenever any object fires a game event.
     *
     * @param event        the type of event (SPELL_CAST, CREATURE_DIED, etc.)
     * @param sourceCard   the card that triggered it (may be null if the source is not a card)
     * @param sourcePlayer the player who caused it (may be null for non‐player sources)
     */
    void onGameEvent(GameEvent event, Card sourceCard, PlayerContext sourcePlayer);
}
