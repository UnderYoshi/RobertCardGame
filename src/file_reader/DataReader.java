package src.file_reader;
import java.util.*;

public class DataReader
{
    private static DataReader instance;

    private final HashMap<String, CardData> cardCache = new HashMap<>();

    private DataReader()
    {}
    
    public static synchronized DataReader getInstance()
    {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    public CardData getCardData(String name)
    {
        if (cardCache.containsKey(name))
        {
            return cardCache.get(name);
        }
        else
        {
            return readCard(name);
        }
    }

    private CardData readCard(String name)
    {
        CardData cardData = new CardData();
        // get all needed general attributes and add to cardData
        cacheCard(cardData);
        return cardData;
    }

    private void cacheCard(CardData cardData)
    {
        cardCache.put(cardData.name, cardData);
    }

     // Variables and methods for reading ability attributes

}