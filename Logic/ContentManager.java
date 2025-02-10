import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentManager {
    private Map<String, Map<String, List<String>>> contentData;

    public ContentManager() {
        contentData = new HashMap<>();
    }

    public List<String> getSimilarContents(String contentId) {
        return contentData.getOrDefault(contentId, new HashMap<>()).getOrDefault("similar", List.of());
    }

    public List<String> getDifferentContents(String contentId) {
        return contentData.getOrDefault(contentId, new HashMap<>()).getOrDefault("different", List.of());
    }

    public List<String> getLessFrequentContents(String contentId) {
        return contentData.getOrDefault(contentId, new HashMap<>()).getOrDefault("less_frequent", List.of());
    }

    public void addContent(String contentId, Map<String, List<String>> relatedContents) {
        contentData.put(contentId, relatedContents);
    }
}
