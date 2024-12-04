import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserU {
    public void parseAndPrintResults(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray searchResults = jsonObject
                .getAsJsonObject("query")
                .getAsJsonArray("search");

        for (int i = 0; i < searchResults.size(); i++) {
            JsonObject result = searchResults.get(i).getAsJsonObject();
            System.out.println((i + 1) + ". " + result.get("title").getAsString());
        }
    }

    public String getPageUrl(String jsonResponse, int index) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray searchResults = jsonObject
                .getAsJsonObject("query")
                .getAsJsonArray("search");

        JsonObject selectedResult = searchResults.get(index - 1).getAsJsonObject();
        int pageId = selectedResult.get("pageid").getAsInt();

        return "https://ru.wikipedia.org/w/index.php?curid=" + pageId;
    }
}
