package article;

public class Sword extends Article {
    public Sword() {
    }

    public Sword(String description, int effect) {
        super(description, effect);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setEffect(int effect) {
        super.setEffect(effect);
    }

    @Override
    public int getEffect() {
        return super.getEffect();
    }
}
