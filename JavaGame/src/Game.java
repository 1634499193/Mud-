import article.Gemstone;
import article.Gold;
import article.Spear;
import article.Sword;
import creature.*;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<>();
    private Person person = new Person("勇士", 100, 10, 10, "近战", 0);
    Gemstone gemstone = new Gemstone();

    public Game() {
        handlers.put("go", new HandlerGo(this));
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        handlers.put("attack", new HandlerAttack(this));
        handlers.put("buy", new HandlerBuy(this));
        handlers.put("change", new HandlerChangeMethod(this));
        createRooms();
    }

    public void createRooms() {
        Gold gold = new Gold(50);
        Room outside, lobby, pub, study, bedroom, basement, backroom;
        Guard guard = new Guard("守卫", 100, 10, "近战");
        Witch littleWitch = new Witch("初阶魔女", 30, 20, "远程");
        Witch oldWitch = new Witch("高阶魔女", 60, 50, "远程");
        Wizard littleWizard = new Wizard("初阶巫师", 40, 10, "远程");
        Wizard oldWizard = new Wizard("高阶巫师", 50, 30, "远程");
        Attendant attendant = new Attendant("侍从", 30, 5, "近战");
        Boss boss = new Boss("魔王", 300, 50, "近战");

        outside = new Room("城堡外", guard, gold);
        lobby = new Room("大堂", attendant, gold);
        pub = new Room("小酒吧", littleWizard, gold);
        study = new Room("书房", littleWitch, gold);
        bedroom = new Room("卧室", oldWitch, gold);
        basement = new Room("地下室", oldWizard, gold);
        backroom = new Room("密室", boss, gold, gemstone);

        outside.setExit("south", lobby);
        outside.setExit("east", study);
        outside.setExit("west", pub);
        lobby.setExit("north", outside);
        lobby.setExit("down", basement);
        pub.setExit("east", outside);
        study.setExit("south", bedroom);
        study.setExit("west", outside);
        bedroom.setExit("north", study);
        basement.setExit("up", lobby);
        bedroom.setExit("up", backroom);
        backroom.setExit("down", bedroom);

        currentRoom = outside;
    }

    public void printWelcome() {
        System.out.println("欢迎进入魔堡游戏！");
        System.out.println("使用你的武器战胜怪物，探索魔堡，寻找宝石。");
        System.out.println("======================================");
        System.out.println("游戏开始，如果需要帮助请输入\"help\"。");
        System.out.println();
        showPrompt();
    }

    public void showPrompt() {
        System.out.println("你在" + currentRoom);
        System.out.print("出口有：");
        System.out.print(currentRoom.getExitDesc());
        System.out.println();
        System.out.println("你的属性:");
        if (person.getAttackMethod().equals("近战")) {
            System.out.println("HP：" + person.getHP() + " 近战伤害值：" + person.getNearDamage() + " 金币：" + person.getWealth());
        } else {
            System.out.println("HP：" + person.getHP() + " 远程伤害值：" + person.getFarDamage() + " 金币：" + person.getWealth());
        }
        System.out.println();
        if (currentRoom.getCreature() != null) {
            System.out.println("怪物有：" + currentRoom.getCreature().getDescription() +
                    "(" + currentRoom.getCreature().getAttackMethod() + ")");
        }
        System.out.println();
    }

    public void showPrompt1() {
        System.out.println("你在" + currentRoom);
        System.out.print("出口有：");
        System.out.print(currentRoom.getExitDesc());
        System.out.println();
        System.out.println("你的属性:");
        if (person.getAttackMethod().equals("近战")) {
            System.out.println("HP：" + person.getHP() + " 近战伤害值：" + person.getNearDamage() + " 金币：" + person.getWealth());
        } else {
            System.out.println("HP：" + person.getHP() + " 远程伤害值：" + person.getFarDamage() + " 金币：" + person.getWealth());
        }
        System.out.println();
        System.out.println("-------------神秘商人出现-------------");
        System.out.println("商人：你需要我的帮助吗？但。。。前提是要有钱。");
        System.out.println("======================================");
        System.out.println("1.HP药水（回复50点生命值）\t10金币");
        System.out.println("2.强化剑（提高近战伤害值20）\t20金币");
        System.out.println("3.强化枪（提高远程伤害值20）\t20金币");
        System.out.println("输入\"buy 序号\"进行交易。");
        System.out.println("======================================");
    }

    public void change() {
        if (person.getAttackMethod().equals("近战")) {
            person.setAttackMethod("远程");
        } else if (person.getAttackMethod().equals("远程")) {
            person.setAttackMethod("近战");
        }
        System.out.println("切换成功！");
        System.out.println("现在的攻击方式是" + person.getAttackMethod());
        play();
    }

    public void buy(String word) {
        if (word.equals("1")) {
            if (person.getWealth() >= 10) {
                if (person.getHP() <= 50) {
                    person.setHP(person.getHP() + 50);
                    person.setWealth(person.getWealth() - 10);
                } else if (person.getHP() > 50 && person.getHP() <= 100) {
                    person.setHP(100);
                    person.setWealth(person.getWealth() - 10);
                }
            } else {
                System.out.println("你没有足够的钱。");
            }
        } else if (word.equals("2")) {
            if (person.getWealth() >= 20) {
                person.setNearDamage(person.getNearDamage() + 20);
                person.setWealth(person.getWealth() - 20);
            } else {
                System.out.println("你没有足够的钱。");
            }
        } else if (word.equals("3")) {
            if (person.getWealth() >= 20) {
                person.setFarDamage(person.getFarDamage() + 20);
                person.setWealth(person.getWealth() - 20);
            } else {
                System.out.println("你没有足够的钱。");
            }
        } else {
            System.out.println("请输入正确指令。");
        }
        showPrompt1();
        play();
    }

    public void attack() {
        if (person.getAttackMethod().equals(currentRoom.getCreature().getAttackMethod())) {
            if (person.getAttackMethod().equals("近战")) {
                if (currentRoom.getCreature().getHP() / person.getNearDamage() > person.getHP() / currentRoom.getCreature().getDamage()) {
                    System.out.println("你没有战胜" + currentRoom.getCreature().getDescription() + ",你可以强化你的装备，再来挑战他。");
                    showPrompt();
                } else {
                    System.out.println("你战胜了他！获得" + currentRoom.getGold().getNumber() + "金币。");
                    person.setWealth(person.getWealth() + currentRoom.getGold().getNumber());
                    person.setHP(person.getHP() - currentRoom.getCreature().getDamage());
                    currentRoom.setCreature(null);
                    showPrompt1();
                }
            } else {
                if (currentRoom.getCreature().getHP() / person.getFarDamage() > person.getHP() / currentRoom.getCreature().getDamage()) {
                    System.out.println("你没有战胜" + currentRoom.getCreature().getDescription() + ",你可以强化你的装备，再来挑战他。");
                    showPrompt();
                } else {
                    if (currentRoom.getCreature().getDescription().equals("Boss")) {
                        gemstone.show();
                        Handler handler = new Handler(this);
                        handler.isBye();
                    }
                    System.out.println("你战胜了他！获得" + currentRoom.getGold().getNumber() + "金币。");
                    person.setWealth(person.getWealth() + currentRoom.getGold().getNumber());
                    person.setHP(person.getHP() - currentRoom.getCreature().getDamage());
                    currentRoom.setCreature(null);
                    showPrompt1();
                }
            }
        } else {
            System.out.println("请切换你的武器。");
            showPrompt();
        }
        play();
    }

    public void goRoom(String direction) {
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        } else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if (words.length > 1)
                value = words[1];
            if (handler != null) {
                handler.doCmd(value);
                if (handler.isBye())
                    break;
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.play();
    }
}
