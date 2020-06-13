public class HandlerBye extends Handler {
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public boolean isBye() {
        System.out.println("感谢你的光临，再见。");
        return true;
    }
}
