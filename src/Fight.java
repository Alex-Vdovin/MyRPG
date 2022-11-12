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
        System.out.println("������ ���������� ������������ ������ ����?");
        way(hero);

    }

    public void levelUp(Hero hero) {
        if (hero.experience >= hero.nextLevel) {
            hero.experience -= hero.nextLevel;
            hero.level++;
            hero.nextLevel = (int) (hero.nextLevel * 1.9);
            System.out.println("\n����� �������!\n" + hero.level + "!!!\n" + "��� ����� ������?");
            System.out.println("\n1.����\n2.��������\n3.��������\n4.����");
            boolean found = true;
            String str = Main.sc.nextLine();
            while (found) {
                switch (str) {
                    case "1" -> {
                        hero.strength += 5;
                        System.out.println("���� ���� " + (hero.strength - 5) + "\n� ������ " + hero.strength);
                        found = false;
                    }
                    case "2" -> {
                        hero.health += 25;
                        System.out.println("�������� ���� " + (hero.health - 25) + "\n� ������ " + hero.health);
                        found = false;
                    }
                    case "3" -> {
                        hero.agility += 5;
                        System.out.println("�������� ���� " + (hero.agility - 5) + "\n� ������ " + hero.agility);
                        found = false;
                    }
                    case "4" ->{
                        hero.mana += 10;
                        System.out.println("���� ���� " + (hero.mana - 10) + "\n� ������ " + hero.mana);
                        found = false;
                    }
                    default -> {
                        System.out.println("�������� ������ �������.");
                        System.out.println("1.����\n2.��������\n3.��������");
                    }
                }
            }
            levelUp(hero);
        }
    }
    public void way(T hero) {
        System.out.println("1. ��");
        System.out.println("2. ���");
        Main.sc = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(Main.sc.nextLine());
            switch (choice) {
                case 1 -> hero.world.exploreDungeon();
                case 2 -> hero.world.home(hero);
            }
        } catch (NumberFormatException e) {
            System.out.println("������� ���������� ������� ������.");
            way(hero);
        }
    }

}
