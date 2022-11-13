import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    ;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру!");
        nameWorld();
    }

    public static String chooseName() {
        System.out.println("Введите имя Вашего персонажа");
        String name = sc.nextLine();
        if (name.length() > 15) {
            System.out.println("Имя слишком длинное. Введите другое имя.");
            return chooseName();
        } else if (name.length() == 0) {
            System.out.println("Вы ничего не ввели. Введите имя персонажа");
            return chooseName();
        }
        return name;
    }

    public static Hero chooseClass() {
        System.out.println("Какой класс выберите?");
        System.out.println("1. Рыцарь");
        System.out.println("2. Чародей");
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> {
                return new Knight(chooseName());
            }
            case "2" -> {
                return new Wizard(chooseName());
            }
            default -> {
                System.out.println("Введите верное значение");
                return chooseClass();
            }
        }
    }

    public static void nameWorld() {
        System.out.println("Как назовёте свой мир?");
        String name = sc.nextLine();
        if (name.length() > 15) {
            System.out.println("Слишком длинное название. Введите другое название мира.");
            nameWorld();
        } else if (name.isEmpty()) {
            System.out.println("Вы ничего не ввели. Введите название мира.");
            nameWorld();
        } else {
            new World(name, chooseClass(), new Trader());
        }
    }
}
