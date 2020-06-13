public class HandlerChangeMethod extends Handler {
    public HandlerChangeMethod(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.change();
    }
}
