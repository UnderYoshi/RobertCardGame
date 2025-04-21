package src.file_reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import src.dependencies.AbilityKeyPair;
import src.dependencies.CardKeyPair;
import src.file_reader.card_data.CardData;
import src.game_objects.cards.attributes.*;
import src.game_objects.effects.EffectFactory;

public class DataReader
{
    private static DataReader instance;

    private final String cardDataPath = "src/data/card_data/";

    private final String animateCardDataFile = "animate-card-data.json";
    private final String inanimateCardDataFile = "inanimate-card-data.json";
    private final String championCardDataFile = "champion-card-data.json";
    private final String spellCardDataFile = "spell-card-data.json";
    private final String foodCardDataFile = "food-card-data.json";
    private final String debuffCardDataFile = "debuff-card-data.json";
    private final String energyCardDataFile = "energy-card-data.json";

    private final String attackCardDataFile = "attack-card-data.json";
    private final String passiveAbilityCardDataFile = "passive-ability-card-data.json";
    private final String activeAbilityCardDataFile = "active-ability-card-data.json";

    private final HashMap<AbilityKeyPair, CardData> abilityCache = new HashMap<>();
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
            case ATTACK -> {filepath = filepath + attackCardDataFile;}
            case ACTIVE_ABILITY -> {filepath = filepath + activeAbilityCardDataFile;}
            case PASSIVE_ABILITY -> {filepath = filepath + passiveAbilityCardDataFile;}
        }

        Map<String, String> cardDataValues = readCardFields(name, filepath);

        // Throws errors for invalid cards, useful for debugging
        if (!cardDataValues.containsKey("name")) {throw new IllegalArgumentException("Card with name " + name + " of wanted type does not exist");}

        mapToCardVariables(cardData, cardDataValues);
        cacheCard(cardData);
        return cardData;
    }

    private Map<String,String> readCardFields(String targetName, String filePath)
    {
        Map<String,String> fields = new HashMap<>();
        String source = "";
        try {source = Files.readString(Path.of(filePath));}
        catch (IOException e){System.out.println("filepath error");}

        Pattern p = Pattern.compile("\\{([^}]*\"name\"\\s*:\\s*\""+ targetName +"\"[^}]*)\\}");
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

    private void mapToCardVariables(CardData cardData, Map<String, String> map)
    {
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            switch (entry.getKey())
            {
                case "element" -> {cardData.element = Element.valueOf(entry.getValue());}
                case "description" -> {cardData.description = entry.getValue();}
                case "rarity" -> {cardData.rarity = Rarity.valueOf(entry.getValue());}
                case "classes" ->
                {
                    String[] parts = entry.getValue().split("\\s*;;;\\s*");
                    cardData.classes = new ArrayList<>();
                    cardData.classes.addAll(Arrays.asList(parts));
                }
                case "turnTimer" -> {cardData.turnTimer = Integer.parseInt(entry.getValue());}
                case "castingSpeed" -> {cardData.castingSpeed = CastingSpeed.valueOf(entry.getValue());}
                case "energyCost" ->
                {
                    cardData.energyCost = new HashMap<>();
                    String[] parts1 = entry.getValue().split("\\s*;;;\\s*");
                    for (String string : parts1)
                    {
                        String[] parts2 = string.split("\\s*:\\s*");
                        cardData.energyCost.put(Element.valueOf(parts2[0]), Integer.valueOf(parts2[1]));
                    }
                }
                case "power" -> {cardData.maxPower = Integer.parseInt(entry.getValue());}
                case "starCost" -> {cardData.starCost = Integer.parseInt(entry.getValue());}
                case "abilities" ->
                {
                    String[] parts = entry.getValue().split("\\s*;;;\\s*");
                    cardData.abilities = new ArrayList<>();
                    cardData.abilities.addAll(Arrays.asList(parts));
                }
                case "effects" ->
                {
                    String[] parts = entry.getValue().split("\\s*;;;\\s*");
                    cardData.effects = new ArrayList<>();
                    for (String effectString : parts) {
                        cardData.effects.add(EffectFactory.build(effectString));
                    }
                }
                case "args" ->
                {
                    cardData.args = new HashMap<>();
                    String[] parts1 = entry.getValue().split("\\s*;;;\\s*");
                    for (String string : parts1) {
                        String[] parts2 = string.split("\\s*:\\s*");
                        cardData.args.put(parts2[0], Integer.valueOf(parts2[1]));
                    }
                }
            }
        }
    }

}