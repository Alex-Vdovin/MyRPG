import java.util.Scanner;

public class Fight <T extends Hero> implements Runnable {
    private T hero;
    private Monster monster;


    public Fight(T hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public void run() {
        hero.fight(hero, monster);
        hero.dungeons++;
        levelUp(hero);
        System.out.println("Хотите продолжить исследование тёмного леса?");
        way(hero);

    }

    public void levelUp(Hero hero) {
        if (hero.experience >= hero.nextLevel) {
            hero.experience -= hero.nextLevel;
            hero.level++;
            hero.nextLevel = (int) (hero.nextLevel * 1.9);
            System.out.println("\nНовый уровень!\n" + hero.level + "!!!\n" + "Что будем качать?");
            System.out.println("\n1.Сила\n2.Здоровье\n3.Ловкость\n4.Мана");
            boolean found = true;
            String str = Main.sc.nextLine();
            while (found) {
                switch (str) {
                    case "1" -> {
                        hero.strength += 5;
                        System.out.println("Сила была " + (hero.strength - 5) + "\nА теперь " + hero.strength);
                        found = false;
                    }
                    case "2" -> {
                        hero.health += 25;
                        System.out.println("Здоровье было " + (hero.health - 25) + "\nА теперь " + hero.health);
                        found = false;
                    }
                    case "3" -> {
                        hero.agility += 5;
                        System.out.println("Ловкость была " + (hero.agility - 5) + "\nА теперь " + hero.agility);
                        found = false;
                    }
                    case "4" ->{
                        hero.mana += 10;
                        System.out.println("Маны было " + (hero.mana - 10) + "\nА теперь " + hero.mana);
                        found = false;
                    }
                    default -> {
                        System.out.println("Выберите верный вариант.");
                        System.out.println("1.Сила\n2.Здоровье\n3.Ловкость");
                    }
                }
            }
            levelUp(hero);
        }
    }
    public void way(T hero) {
        System.out.println("1. Да");
        System.out.println("2. Нет");
        Main.sc = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(Main.sc.nextLine());
            switch (choice) {
                case 1 -> hero.world.exploreDungeon();
                case 2 -> hero.world.home(hero);
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите правильный вариант ответа.");
            way(hero);
        }
    }

}
