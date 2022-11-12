public class Goblin extends Monster {
    public Goblin(int level) {
        this.level = level;
        this.name = "������";
        this.health = 50 + (int) ( (level * 1.2));
        this.strength = 15 + (int) ( (level * 1.2));
        this.agility = 15 + (int) ((level * 1.2));
    }

    @Override
    public void painSound() {
        System.out.println("*����� ����������� ����������*");
    }

}
