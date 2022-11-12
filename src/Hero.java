import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Hero extends Unit {

    protected int mana;
    protected int currentMaxMana;
    protected int experience;
    protected int money;
    protected boolean alive = true;
    protected int nextLevel = 100;
    protected int dungeons = 0;
    protected Bag bag;
    protected int currentMaxHealth;

    protected World world;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
    }

    public <T extends Hero> void fight(T hero, Monster monster){
        System.out.println("����� " + hero.name + " ����� ��������� � �������� " + monster.name);
        int step = 1;
        while (monster.health > 0 && hero.health > 0) {
            System.out.println("\n----��� " + step + "----");
            step++;
            hero.hit(monster);
            monster.hit(hero);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.checkWin(monster);
    }

    public abstract void hit(Monster monster);

    public void buy(Trader trader){
        trader.sell(this);
    }

    @Override
    public String toString() {
        return this.name + ":\n" +"�������: " + this.level +"\n������� ����: " + this.experience + "\n����: " + this.strength + "\n��������:  " + this.agility + "\n��������: " + this.health + "\n����: " + this.mana
                + "\n������: " + this.money + "\n����� �� ���������� ������: " + (this.nextLevel - this.experience) + "\n������ � ����� ���: " + this.dungeons;
    }
    public void checkWin(Monster monster){
        if (this.health <= 0) {
            this.alive = false;
            this.health = 0;
            System.out.println("\n�� �����)");
            World.giveUp(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("\n����� " + this.name + " ������� � ���� �������!");
            int money = 25 * monster.level * ((int) (Math.random() * 3) + 1);
            int experience = 100 * monster.level * ((int) (Math.random() * 3) + 1);
            this.money += money;
            this.experience += experience;
            System.out.println(this.name + " ��������� " + money + " ������\n" + this.name + " ��������� " + experience + " ����� �����\n����� ������: " + this.money + "\n����� �����: " + this.experience);
        }
    }
    public void checkBag() {
        if (bag.items.isEmpty()) {
            System.out.println("������ ����� � ������� ���...");
            World.printWays();
        } else {
            int i = 1;
            for (Caryable element : bag.items) {
                System.out.println(i + ". " + element.getName());
                i++;
            }
            System.out.println("������ ���-�� ������������? �������� ����� �����.\n��� 0 ��� ������ � ������� ����.");
            boolean choice = true;
            String buff = Main.sc.nextLine();
            while (choice) {
                try {
                    if (Integer.parseInt(buff) != 0) {
                        bag.items.get(Integer.parseInt(buff) - 1).getDescription(this, bag.items.get(Integer.parseInt(buff) - 1));
                        bag.items.remove(Integer.parseInt(buff) - 1);
                        choice = false;
                    } else {
                        world.home(this);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("������� ������ ��������");
                    buff = Main.sc.nextLine();
                }
            }
            world.home(this);
        }
    }
    public void getStats(){
        System.out.println(this);
        System.out.println("\n������� ��� ������ ��� ����������� � ������� ����");
        Main.sc.nextLine();
        World.printWays();
    }

}
