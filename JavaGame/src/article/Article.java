package article;

public class Article {
    private String description;
    private int effect;

    public Article(){}
    public Article(String description, int effect) {
        this.description = description;
        this.effect = effect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }
}
