package src.game_objects.game;
import src.game_objects.game.player.PlayerContext;

public class GameMatch {
    private final PlayerContext[] players = new PlayerContext[2];
    private PlayerContext currentPlayer;
    private int turnNumber;

    public GameMatch() {
        this.players[0] = new PlayerContext(null, null);
        this.players[1] = new PlayerContext(null, null);
        this.turnNumber = 1;
    }
    
    public void start() {
        for (PlayerContext player : players) {
            player.drawCard(7);
            player.getDeck().shuffle();
        }
    }

    public void nextTurn() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
        turnNumber++;
    }
}
