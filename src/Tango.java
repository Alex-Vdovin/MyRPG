public class Tango extends Buff {
    @Override
    public void use(Hero hero) {
        hero.health += this.buff;
        if (hero.health > hero.currentMaxHealth) {
            hero.health = hero.currentMaxHealth;
        }
    }

    public Tango() {
        this.name = "�����";
        this.price = 25;
        this.buff = 100;
    }

    @Override
    public void getDescription(Hero hero, Caryable buff) {
        System.out.println("�������� ���� " + hero.health);
        buff.use(hero);
        System.out.println("��� �������� ����� " + hero.health);
    }

    @Override
    public String toString() {
        return "�����";
    }
}
