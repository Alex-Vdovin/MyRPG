public abstract class Monster extends Unit {
    public abstract void painSound();

    public void hit(Hero hero) {
        if (this.health > 0) {
            hero.health -= this.strength;
            System.out.println(hero.health > 0 ? this.name + " ������� ���� ������ �����!\n� ����� �������� " + hero.health + " ��������" :
                    this.name + " ������� ���� ������ �����!\n� ����� �������� " + 0 + " ��������");
        }
    }

    public void checkHealth() {
        System.out.println(this.health >= 0 ? "� ������� �������� �������� " + this.health : "� ������� �������� �������� " + 0);
    }

}
