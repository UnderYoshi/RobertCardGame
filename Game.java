import java.util.*;

public class Game {

    // public static enum Type {ROGUELIKE1};
    // public final Type type;
    // public Game(Type type) {
    //     this.type = type;
    //     switch(this.type) {
    //         case ROGUELIKE1:
    //     }
    // }

    static final int MAX_ROOM_SIZE = 4;
    static final int DRAW_AFTER_CARDS_LEFT = 1;
    private Printer printer = new Printer(this);

    Scanner input = new Scanner(System.in);

    Deck deck;
    ArrayList<Card> room = new ArrayList<Card>();
    ArrayList<Card> discardPile = new ArrayList<Card>();
    Card weapon;
    ArrayList<Card> currentSlainEnemies = new ArrayList<Card>();
    long currentTurn = 0;
    long lastRunAwayTurn = -1;

    final int MAX_HEALTH = 20;
    int playerHealth = MAX_HEALTH;
    final int JOKER_DAMAGE = 19;

    HashMap<Card.Rank, Integer> valueMap = new HashMap<Card.Rank, Integer>();

    public void start() {
        // Initialize damageMap;
        int i = 1;
        for (Card.Rank rank: Card.Rank.values()) {
            if (i == 1) {
                valueMap.put(rank, 14);
            }
            else {
                valueMap.put(rank, i);
            }
            i++;
        }


        deck = new Deck(Deck.Type.STANDARD54);
        deck.shuffle();
        fillRoom();
        printer.printGame();
        while (true) {
            String selection = input.nextLine();
            doTurn(selection);

            if (room.size() <= DRAW_AFTER_CARDS_LEFT) {
                fillRoom();
            }

            if (playerDied()) {
                System.out.println("YOU LOSE !!!!!!!!!!!!!!!!!");
                break;
            }

            if (checkWinCondition()) {
                System.out.println("YOU WIN !!!!!!!!!!!!!!!!!");
                break;
            }

            printer.printGame();
        }
    }

    private void doTurn(String selection) {
        int selectedCardNumber = 0;
        if (selection.equals("run")) {
            runAway();
        } else {
            char c = selection.charAt(0);
            selectedCardNumber = c - '0';
        }

        if (1 <= selectedCardNumber && selectedCardNumber <= room.size()) {
            Card selectedCard = room.get(selectedCardNumber - 1);
            switch (selectedCard.getType()) {
                case PLAYING_CARD:
                switch (selectedCard.getSuit()) {
                    case HEARTS:
                        playerHealth = Math.min(playerHealth + valueMap.get(selectedCard.rank), MAX_HEALTH);
                    break;
                    case DIAMONDS:
                        discard(weapon);
                        discard(currentSlainEnemies);
                        weapon = selectedCard;
                        currentSlainEnemies.clear();
                    break;
                    default: // Spades and clubs
                        fight(selectedCard);
                    break;
                }
                break;
                case JOKER:
                    fight(selectedCard);
                break;
                case TAROT_CARD:

                break;
            }
            discard(selectedCard);
            room.remove(selectedCardNumber - 1);
        }
    }

    private void fight(Card enemyCard) {
        if (weapon != null && currentSlainEnemies.isEmpty()) {
            //only weapon
            currentSlainEnemies.add(0, enemyCard);
            playerHealth = playerHealth - Math.max(0, getDamage(enemyCard) - getDamage(weapon));
        } else if (weapon != null && getDamage(currentSlainEnemies.get(0)) > getDamage(enemyCard)) {
            //weapon + killed enemies
            currentSlainEnemies.add(0, enemyCard);
            playerHealth = playerHealth - Math.max(0, getDamage(enemyCard) - getDamage(weapon));
        } else {
            playerHealth = playerHealth - getDamage(enemyCard);
        }
    }

    private int getDamage(Card card) {
        int damage = 0;
        switch (card.getType()) {
            case PLAYING_CARD:
            damage = valueMap.get(card.rank);
            break;
            case JOKER:
            damage = JOKER_DAMAGE;
            break;
            case TAROT_CARD:
            damage = 0;
            break;
        }
        return damage;
    }

    private void fillRoom() {
        while (room.size() < MAX_ROOM_SIZE && deck.size() > 0) {
            room.add(deck.drawSingle());
        }
        currentTurn++;
    }
    
    private boolean canRunAway() {
        if (currentTurn > lastRunAwayTurn + 1) {
            return true;
        }
        return false;
    }
    public void runAway() {
        if(canRunAway()) {
            lastRunAwayTurn = currentTurn;
            deck.putOnBottom(room);
            room.clear();
            fillRoom();            
        }
        else {
            System.out.println("Can't run away");
        }
    }
    private void discard(Card card) {
        discardPile.add(0, card);
    }
    private void discard(ArrayList<Card> cards) {
        discardPile.addAll(0, cards);
    }
    private boolean checkWinCondition() {
        boolean win = true;
        for(Card card: deck) {
            if (isEnemy(card)) {
                win = false;
            }
        }
        for (Card card: room) {
            if (isEnemy(card)) {
                win = false;
            }
        }
        return win;
    }

    boolean isEnemy(Card card) {
        if (card.getSuit() == Card.Suit.CLUBS || card.getSuit() == Card.Suit.SPADES || card.getType() == Card.Type.JOKER) {
            return true;
        }
        return false;
    }

    private boolean playerDied() {
        if (playerHealth <= 0) {
            return true;
        }
        return false;
    }
}
