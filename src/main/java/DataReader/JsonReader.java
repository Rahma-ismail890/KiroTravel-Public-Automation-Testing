package DataReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReader {
    public static String testDataPath ="src/main/java/TestData/";
    public static Object[][] readJsonFile(String JsonFileName,String dataType)
    {
        Object[][] data = null;
        try {
            JSONParser parser=new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(testDataPath+JsonFileName+".json"));
           JSONArray jsonArray= (JSONArray) jsonObject.get(dataType);
           data=new Object[jsonArray.size()][1];
           for (int i=0;i< jsonArray.size();i++)
           {
               HashMap<String,String> map= JsonObjectToHashMap((JSONObject) jsonArray.get(i));
               data[i][0]=map;
           }
        } catch (IOException |ParseException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    private static HashMap<String,String> JsonObjectToHashMap(JSONObject jsonObject)
    {
        HashMap<String,String> Map = new HashMap<>();
        jsonObject.forEach((key,value) -> Map.put(key.toString(),value.toString()));
        return Map;
    }
}
