import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    ;

    public static void main(String[] args) {
        System.out.println("����� ���������� � ����!");
        nameWorld();
    }

    public static String chooseName() {
        System.out.println("������� ��� ������ ���������");
        String name = sc.nextLine();
        if (name.length() > 15) {
            System.out.println("��� ������� �������. ������� ������ ���.");
            return chooseName();
        } else if (name.length() == 0) {
            System.out.println("�� ������ �� �����. ������� ��� ���������");
            return chooseName();
        }
        return name;
    }

    public static Hero chooseClass() {
        System.out.println("����� ����� ��������?");
        System.out.println("1. ������");
        System.out.println("2. �������");
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> {
                return new Knight(chooseName());
            }
            case "2" -> {
                return new Wizard(chooseName());
            }
            default -> {
                System.out.println("������� ������ ��������");
                return chooseClass();
            }
        }
    }

    public static void nameWorld() {
        System.out.println("��� ������� ���� ���?");
        String name = sc.nextLine();
        if (name.length() > 15) {
            System.out.println("������� ������� ��������. ������� ������ �������� ����.");
            nameWorld();
        } else if (name.isEmpty()) {
            System.out.println("�� ������ �� �����. ������� �������� ����.");
            nameWorld();
        } else {
            new World(name, chooseClass(), new Trader());
        }
    }
}
