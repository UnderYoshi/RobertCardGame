package src.file_reader;
import java.util.*;
import src.dependencies.CardKeyPair;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.CardType;

public class DataReader
{
    private static DataReader instance;

    private final HashMap<CardKeyPair, CardData> cardCache = new HashMap<>();

    private DataReader()
    {}
    
    public static synchronized DataReader getInstance()
    {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    public CardData getCardData(String name, CardType type)
    {
        CardKeyPair key = new CardKeyPair(name, type);
        if (cardCache.containsKey(key))
        {
            return cardCache.get(key);
        }
        else
        {
            return readCardFile(name, type);
        }
    }

    private CardData readCardFile(String name, CardType type)
    {   
        CardData cardData = new CardData();
        switch (type)
        {
            case ENERGY -> {}
            case ANIMATE -> {}
            case INANIMATE -> {}
            case CHAMPION -> {}
            case SPELL -> {}
            case FOOD -> {}
            case DEBUFF -> {}
        }
        // get all needed general attributes and add to cardData
        cacheCard(cardData);
        return cardData;
    }

    private void cacheCard(CardData cardData)
    {
        cardCache.put(new CardKeyPair(cardData.name, cardData.cardType), cardData);
    }

     // Variables and methods for reading ability attributes

}