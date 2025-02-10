public class Main {
    public static void main(String[] args) {
        ContentManager contentManager = new ContentManager();
        ContentLoader.loadContents(contentManager, "data/political_contents.json");

    }
}
