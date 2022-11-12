public class World<T extends Hero> {
    private String name;
    private T hero;
    private Trader trader;

    public void exploreDungeon() {
        trader.newAssortment();
        new Thread(new Fight(hero, ((int) (Math.random() * 100) > 50 ? new Sceleton(hero.level) : new Goblin(hero.level)))).start();
    }

    public static void giveUp(Hero hero) {
        System.out.println("Прощай " + hero.getName() + "!!!");
        System.out.println("Надеюсь, тебе понравилось это приключение!!!");
        System.exit(0);
    }

    public World(String name, T hero, Trader trader) {
        this.name = name;
        hero.world = this;
        this.hero = hero;
        this.trader = trader;
        System.out.println("Мир " + this.name + " создан");
        System.out.println("Добро пожаловать!");
        home(hero);
    }

    public void home(T hero) {
        hero.setMoney(100);
        printWays();
        boolean rightChoice = true;
        while (rightChoice) {
            try {
                int choice = Integer.parseInt(Main.sc.nextLine());
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
            } catch (NumberFormatException e) {
                System.out.println("Введите верное значение");
            }
        }
    }


    public static void printWays() {
        System.out.println("\nКуда направимся?");
        System.out.println("1. К торговцу");
        System.out.println("2. В тёмный лес");
        System.out.println("3. На выход");
        System.out.println("4. Посмотреть сумку");
        System.out.println("5. Статистика героя");
    }
}
