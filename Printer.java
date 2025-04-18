import java.util.HashMap;

import src.Game;
import src.game_objects.cards.Card;
import src.game_objects.cards.Card.Suit;

public class Printer {
    Game game;

    String[] cardOutline = {"╔═════╗", "║", "║", "║", "║", "╚═════╝"};
    String[] jokerString = {" /å\\ ", "ºô ôº", "«¬^⌐»"};
    HashMap<Card.Suit, String[]> suitMap = new HashMap<Card.Suit, String[]>();
    HashMap<Card.Rank, String> rankMap = new HashMap<Card.Rank, String>();

    public Printer(Game game) {
        this.game = game;

        String[] clubs = {"  O  ", " O^O ", "  ±  "};S
        suitMap.put(Card.Suit.CLUBS, clubs);
        String[] spades = {" /^\\ ", "/_ _\\", " ≤±≥ "};
        suitMap.put(Card.Suit.SPADES, spades);
        String[] hearts = {"/^v^\\", "\\   /", " \\v/ "};
        suitMap.put(Card.Suit.HEARTS, hearts);
        String[] diamonds = {" /\\  ", " \\/  ", "     "};
        suitMap.put(Card.Suit.DIAMONDS, diamonds);

        int currentrank = 1;
        for(Card.Rank rank: Card.Rank.values()) {
            switch(currentrank){
                case 1:
                    rankMap.put(rank, "A    ");
                    break;
                case 10:
                    rankMap.put(rank, "10   ");
                    break;
                case 11:
                    rankMap.put(rank, "J    ");
                    break;
                case 12:
                    rankMap.put(rank, "Q    ");
                    break;
                case 13:
                    rankMap.put(rank, "K    ");
                    break;
                default:
                    rankMap.put(rank, currentrank + "    ");
                    break;
            }
            currentrank++;
        }
    }



    void printGame() {
        System.out.printf("Health: %d ", game.playerHealth);
        for (int i = 1; i <= game.MAX_HEALTH; i++) {
            if (game.playerHealth >= i) {
                System.out.print("█");
            } else {
                System.out.print(".");
            }
        }
        System.out.println();
        System.out.printf("Turn %d\n", game.currentTurn);
        for (int i = 0; i < 6; i++) {
            for (Card card: game.room) {
                printCard(card, i);
                System.out.print(" ");
            }
            System.out.print(" \n");
        }
        // Prints weapon
        if (game.weapon != null) {
            System.out.println("Weapon:");
            if (game.currentSlainEnemies.isEmpty()) {
                for (int i = 0; i < 6; i++) {
                    printCard(game.weapon, i);
                    System.out.print(" \n");
                }
            } else {
                Card topEnemy = game.currentSlainEnemies.get(0);
                for (int i = 0; i < 7; i++) {
                    switch (i) {
                        case 0:
                            printCard(game.weapon, i);
                            System.out.print("   ");
                        break;
                        case 6:
                            System.out.print("   ");
                            printCard(topEnemy, i - 1);
                        break;
                        default:
                            printCard(game.weapon, i, 0, 2);
                            printCard(topEnemy, i - 1);
                        break;
                    }
                    System.out.print(" \n");
                }
            }
        }        
    }

    void printCard(Card card, int row, int startIndex, int endIndex) {
        // Prints the first 1-7 characters (substring) of one row of a card
        // endIndex is inclusive, unlike the regular subString() function
        if (startIndex < 0 || endIndex > 6 || startIndex > endIndex) {
            throw new IllegalArgumentException("Index out of range, start, endindex must be between 0 - 6");
        }
        if (row < 0 || row > 5) {
            throw new IllegalArgumentException("Index out of range, row must be between 0 - 5");
        }
        
        switch (card.getType()) {
            case PLAYING_CARD:
                switch (row) {
                    case 0:
                        System.out.print(cardOutline[row].substring(startIndex, endIndex + 1));
                    break;
                    case 1:
                        String line1 = cardOutline[row] + rankMap.get(card.rank) + cardOutline[row];
                        System.out.print(line1.substring(startIndex, endIndex + 1));
                    break;
                    case 5:
                       System.out.print(cardOutline[row].substring(startIndex, endIndex + 1));
                    break;
                    default:
                        String line2 = cardOutline[row] + suitMap.get(card.suit)[row - 2] + cardOutline[row];
                        System.out.print(line2.substring(startIndex, endIndex + 1));
                    break;
                }
            break;
            case JOKER:
            switch (row) {
                case 0:
                    System.out.print(cardOutline[row].substring(startIndex, endIndex + 1));
                break;
                case 1:
                    String line1 = cardOutline[row] + "JOKER" + cardOutline[row];
                    System.out.print(line1.substring(startIndex, endIndex + 1));
                break;
                case 5:
                   System.out.print(cardOutline[row].substring(startIndex, endIndex + 1));
                break;
                default:
                    String line2 = cardOutline[row] + jokerString[row - 2] + cardOutline[row];
                    System.out.print(line2.substring(startIndex, endIndex + 1));
                break;
            }
            break;
            case TAROT_CARD:

            break;
        }
    }

    void printCard(Card card, int row) {
        printCard(card, row, 0, 6);
    }

}