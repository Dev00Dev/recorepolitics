import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, Map<String, Boolean>> userData;

    public UserManager() {
        userData = new HashMap<>();
    }

    public boolean hasInteraction(String userId, String contentId) {
        return userData.getOrDefault(userId, new HashMap<>()).containsKey(contentId);
    }

    public boolean isPositiveInteraction(String userId, String contentId) {
        return userData.getOrDefault(userId, new HashMap<>()).getOrDefault(contentId, false);
    }

    public void addInteraction(String userId, String contentId, boolean isPositive) {
        userData.computeIfAbsent(userId, k -> new HashMap<>()).put(contentId, isPositive);
    }
}
