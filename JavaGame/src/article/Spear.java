package article;

public class Spear extends Article {
    public Spear() {
    }

    public Spear(String description, int effect) {
        super(description, effect);
    }

    @Override
    public void setEffect(int effect) {
        super.setEffect(effect);
    }

    @Override
    public int getEffect() {
        return super.getEffect();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
