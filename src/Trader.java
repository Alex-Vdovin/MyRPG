import java.util.Scanner;

public class Trader {
    private Bag assortment;
    private static Scanner sc = new Scanner(System.in);

    public Trader() {
        assortment = new Bag();
        newAssortment();
    }

    public void sell(Hero hero) {
        System.out.println("\nЧто я могу Вам предложить?");
        System.out.println("\nВот мой ассортимент!");
        printAssortment();
        System.out.println("Если ничего не хочешь покупать, нажми на 0");
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    this.bargain(hero, new Clarity());
                    anythingElse(hero);
                }
                case 2 -> {
                    this.bargain(hero, new Tango());
                    anythingElse(hero);
                }
                case 0 -> {
                    System.out.println("До скорого!");
                    hero.world.home(hero);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("У меня нет такого товара");
            sell(hero);
        }
    }

    public void bargain(Hero hero, Buff buff) {
        if (checkItem(buff)) {
            if (hero.getMoney() - buff.getPrice() >= 0) {
                hero.setMoney(hero.getMoney() - buff.getPrice());
                System.out.println("У тебя осталось " + hero.getMoney() + " золотых");
                System.out.println("И теперь у тебя есть " + buff.getName() + "!!!");
                hero.bag.addSomething(buff);
            } else {
                System.out.println("А деньжат то маловато...");
            }
        } else {
            System.out.println("Увы, пока что мне больше нечего тебе предложить...");
        }

    }

    public void anythingElse(Hero hero) {
        System.out.println("Хотите что-то ещё?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    if (hero.money < 25) {
                        System.out.println("Да что ты пристал!!!\nУ тебя нет ни гроша!\nИди в подземелье и заработай потом и кровью хотя бы горсть монет!\nВали из моего магазина!");
                        hero.world.home(hero);
                    } else {
                        System.out.println("Тогда продолжаем!");
                        this.sell(hero);
                    }
                }
                case 2 -> {
                    System.out.println("До скорого!");
                    hero.world.home(hero);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Сделайте правильный выбор");
            anythingElse(hero);
        }
    }

    public void printAssortment() {
        if (assortment.items.isEmpty()) {
            System.out.println("У меня нет товаров на продажу");
        } else {
            assortment.printItems();
            System.out.println("Что выбираем?");
            System.out.println("1. Кларити");
            System.out.println("2. Танго");
        }

    }

    public boolean checkItem(Buff buff) {
        for (Caryable item :
                this.assortment.items) {
            if (item.getName().equals(buff.getName())) {
                this.assortment.items.remove(item);
                return true;
            }
        }
        return false;
    }

    public void newAssortment() {
        assortment.items.clear();
        assortment.addSomething(new Tango());
        assortment.addSomething(new Tango());
        assortment.addSomething(new Tango());
        assortment.addSomething(new Clarity());
        assortment.addSomething(new Clarity());
        assortment.addSomething(new Clarity());
    }
}
