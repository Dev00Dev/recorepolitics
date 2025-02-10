import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentLoader {

    public static void loadContents(ContentManager contentManager, String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            JSONArray contentsArray = (JSONArray) obj;

            for (Object contentObj : contentsArray) {
                JSONObject contentJson = (JSONObject) contentObj;
                String contentId = (String) contentJson.get("content_id");
                Map<String, List<String>> relatedContents = new HashMap<>();

                relatedContents.put("similar", (List<String>) contentJson.get("similar"));
                relatedContents.put("different", (List<String>) contentJson.get("different"));
                relatedContents.put("less_frequent", (List<String>) contentJson.get("less_frequent"));

                contentManager.addContent(contentId, relatedContents);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
