package src.file_reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import src.dependencies.CardKeyPair;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.CardType;

public class DataReader
{
    private static DataReader instance;

    private String cardDataPath = "src/data/card_data/";
    private String animateCardDataFile = "animate-card-data.json";
    private String inanimateCardDataFile = "inanimate-card-data.json";
    private String championCardDataFile = "champion-card-data.json";
    private String spellCardDataFile = "spell-card-data.json";
    private String foodCardDataFile = "food-card-data.json";
    private String debuffCardDataFile = "debuff-card-data.json";
    private String energyCardDataFile = "energy-card-data.json";
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
    
    private void cacheCard(CardData cardData)
    {
        cardCache.put(new CardKeyPair(cardData.name, cardData.cardType), cardData);
    }

    private CardData readCardFile(String name, CardType type)
    {   
        CardData cardData = new CardData();
        cardData.name = name;
        cardData.cardType = type;
        String filepath = cardDataPath;
        switch (type)
        {
            case ENERGY -> {filepath = filepath + energyCardDataFile;}
            case ANIMATE -> {filepath = filepath + animateCardDataFile;}
            case INANIMATE -> {filepath = filepath + inanimateCardDataFile;}
            case CHAMPION -> {filepath = filepath + championCardDataFile;}
            case SPELL -> {filepath = filepath + spellCardDataFile;}
            case FOOD -> {filepath = filepath + foodCardDataFile;}
            case DEBUFF -> {filepath = filepath + debuffCardDataFile;}
        }

        Map<String, String> cardDataValues = readCardFields(name, filepath);

        // Throws errors for invalid cards, useful for debugging
        if (!cardDataValues.containsKey("name")) {throw new IllegalArgumentException("Card with name " + name + " of wanted type does not exist");}

        cacheCard(cardData);
        return mapToVariables(cardDataValues, cardData);
    }

    private Map<String,String> readCardFields(String targetName, String filePath)
    {
        Map<String,String> fields = new HashMap<>();
        String source = "";
        try {source = Files.readString(Path.of(filePath));}
        catch (IOException e){System.out.println("filepath error");}

        Pattern p = Pattern.compile("\\{([^}]*\"name\"\\s*:\\s*\""+targetName+"\"[^}]*)\\}");
        Matcher m = p.matcher(source);
        if (!m.find()) return null;
        String body = m.group(1);
        
        // pull out simple key:value pairs
        Pattern kv = Pattern.compile("\"([^\"]+)\"\\s*:\\s*(\"[^\"]*\"|\\d+)");
        Matcher m2 = kv.matcher(body);
        while (m2.find()) {
            fields.put(m2.group(1), m2.group(2).replace("\"",""));
        }
        return fields;
    }

    private CardData mapToVariables(Map<String, String> map, CardData cardData)
    {
        return cardData;
    }

}