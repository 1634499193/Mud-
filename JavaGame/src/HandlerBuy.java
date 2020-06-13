public class HandlerBuy extends Handler {

    public HandlerBuy(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.buy(word);
    }
}
