package src.game_objects.game;
import src.file_reader.DataReader;
import src.game_objects.cards.Card;
import src.game_objects.game.player.PlayerContext;

public class GameEventListener {
    private static GameEventListener instance;
    private static GameMatch currentAssignedGameMatch;
    private GameEventListener(GameMatch match) {
        currentAssignedGameMatch = match;
    }
    
    public static synchronized GameEventListener getInstance() {
        return instance;
    }

    public static synchronized GameMatch getAssignedMatch() {
        return currentAssignedGameMatch;
    }

    public static synchronized GameEventListener createNewInstance(GameMatch match) {
        instance = new GameEventListener(match);
        currentAssignedGameMatch = match;
        return instance;
    }
    

    
    public void signal(GameEvent event) {
        signal(event, null, null);
    }
    public void signal(GameEvent event, Card source) {
        signal(event, source, null);
    }
    public void signal(GameEvent event, PlayerContext player) {
        signal(event, null, player);
    }
    public void signal(GameEvent event, Card source, PlayerContext player) {
        currentAssignedGameMatch.signalAll(event, source, player);
    }
}
