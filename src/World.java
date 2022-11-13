import java.util.Scanner;

public class World<T extends Hero> {
    private String name;
    private T hero;
    private Trader trader;
    private static Scanner sc = new Scanner(System.in);

    public void exploreDungeon() throws InterruptedException {
        trader.newAssortment();
        new Thread(new Fight(hero, ((int) (Math.random() * 100) > 50 ? new Sceleton(hero.level) : new Goblin(hero.level)))).start();
        Thread.currentThread().join();
    }

    public static void giveUp(Hero hero) {
        System.out.println("������ " + hero.getName() + "!!!");
        System.out.println("�������, ���� ����������� ��� �����������!!!");
        System.exit(0);
    }

    public World(String name, T hero, Trader trader) {
        this.name = name;
        hero.world = this;
        this.hero = hero;
        this.trader = trader;
        System.out.println("��� " + this.name + " ������");
        System.out.println("����� ����������!");
        home(hero);
    }

    public void home(T hero) {
        printWays();
        boolean rightChoice = true;
        while (rightChoice) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        rightChoice = false;
                        hero.buy(trader);
                    }
                    case 2 -> {
                        rightChoice = false;
                        trader.newAssortment();
                        exploreDungeon();
                    }
                    case 3 -> {
                        giveUp(hero);
                    }
                    case 4 -> hero.checkBag();
                    case 5 -> hero.getStats();
                }
            } catch (NumberFormatException | InterruptedException e) {
                System.out.println("������� ������ ��������");
            }
        }
    }


    public static void printWays() {
        System.out.println("\n���� ����������?");
        System.out.println("1. � ��������");
        System.out.println("2. � ����� ���");
        System.out.println("3. �� �����");
        System.out.println("4. ���������� �����");
        System.out.println("5. ���������� �����");
    }
}
