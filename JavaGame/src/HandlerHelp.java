public class HandlerHelp extends Handler {
    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        System.out.println("迷路了吗？那可以做的命令有：go bye help attack");
        System.out.println("如：go east,attack guard");
    }
}
