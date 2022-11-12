public class Sceleton extends Monster {
    public Sceleton(int level) {
        this.level = level;
        this.name = "Скелет";
        this.health = 50 + (int) ((level * 1.2));
        this.strength = 10 + (int) ((level * 1.2));
        this.agility = 10 + (int) ((level * 1.2));
    }

    @Override
    public void painSound() {
        System.out.println("*Звуки стука костей*");
    }
}
