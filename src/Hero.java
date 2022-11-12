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
        System.out.println("Герой " + hero.name + " будет сражаться с монстром " + monster.name);
        int step = 1;
        while (monster.health > 0 && hero.health > 0) {
            System.out.println("\n----Ход " + step + "----");
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
        return this.name + ":\n" +"Уровень: " + this.level +"\nТекущий опыт: " + this.experience + "\nСила: " + this.strength + "\nЛовкость:  " + this.agility + "\nЗдоровье: " + this.health + "\nМана: " + this.mana
                + "\nДеньги: " + this.money + "\nОпыта до следующего уровня: " + (this.nextLevel - this.experience) + "\nЗаходы в тёмный лес: " + this.dungeons;
    }
    public void checkWin(Monster monster){
        if (this.health <= 0) {
            this.alive = false;
            this.health = 0;
            System.out.println("\nТы помер)");
            World.giveUp(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("\nГерой " + this.name + " победил в этой схватке!");
            int money = 25 * monster.level * ((int) (Math.random() * 3) + 1);
            int experience = 100 * monster.level * ((int) (Math.random() * 3) + 1);
            this.money += money;
            this.experience += experience;
            System.out.println(this.name + " заработал " + money + " золота\n" + this.name + " заработал " + experience + " очков опыта\nВсего золота: " + this.money + "\nВсего опыта: " + this.experience);
        }
    }
    public void checkBag() {
        if (bag.items.isEmpty()) {
            System.out.println("Однако пусто и грустно тут...");
            World.printWays();
        } else {
            int i = 1;
            for (Caryable element : bag.items) {
                System.out.println(i + ". " + element.getName());
                i++;
            }
            System.out.println("Хотите что-то использовать? Выберите номер зелья.\nИли 0 для выхода в главное меню.");
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
                    System.out.println("Введите верное значение");
                    buff = Main.sc.nextLine();
                }
            }
            world.home(this);
        }
    }
    public void getStats(){
        System.out.println(this);
        System.out.println("\nВведите что угодно для возвращения в главное меню");
        Main.sc.nextLine();
        World.printWays();
    }

}
