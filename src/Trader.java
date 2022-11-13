import java.util.Scanner;

public class Trader {
    private Bag assortment;
    private static Scanner sc = new Scanner(System.in);

    public Trader() {
        assortment = new Bag();
        newAssortment();
    }

    public void sell(Hero hero) {
        System.out.println("\n��� � ���� ��� ����������?");
        System.out.println("\n��� ��� �����������!");
        printAssortment();
        System.out.println("���� ������ �� ������ ��������, ����� �� 0");
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
                    System.out.println("�� �������!");
                    hero.world.home(hero);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("� ���� ��� ������ ������");
            sell(hero);
        }
    }

    public void bargain(Hero hero, Buff buff) {
        if (checkItem(buff)) {
            if (hero.getMoney() - buff.getPrice() >= 0) {
                hero.setMoney(hero.getMoney() - buff.getPrice());
                System.out.println("� ���� �������� " + hero.getMoney() + " �������");
                System.out.println("� ������ � ���� ���� " + buff.getName() + "!!!");
                hero.bag.addSomething(buff);
            } else {
                System.out.println("� ������� �� ��������...");
            }
        } else {
            System.out.println("���, ���� ��� ��� ������ ������ ���� ����������...");
        }

    }

    public void anythingElse(Hero hero) {
        System.out.println("������ ���-�� ���?");
        System.out.println("1. ��");
        System.out.println("2. ���");
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    if (hero.money < 25) {
                        System.out.println("�� ��� �� �������!!!\n� ���� ��� �� �����!\n��� � ���������� � ��������� ����� � ������ ���� �� ������ �����!\n���� �� ����� ��������!");
                        hero.world.home(hero);
                    } else {
                        System.out.println("����� ����������!");
                        this.sell(hero);
                    }
                }
                case 2 -> {
                    System.out.println("�� �������!");
                    hero.world.home(hero);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("�������� ���������� �����");
            anythingElse(hero);
        }
    }

    public void printAssortment() {
        if (assortment.items.isEmpty()) {
            System.out.println("� ���� ��� ������� �� �������");
        } else {
            assortment.printItems();
            System.out.println("��� ��������?");
            System.out.println("1. �������");
            System.out.println("2. �����");
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
