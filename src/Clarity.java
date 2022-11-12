public class Clarity extends Buff {
    @Override
    public void use(Hero hero) {
        hero.mana += this.buff;
        if (hero.mana > hero.currentMaxMana) {
            hero.mana = hero.currentMaxMana;
        }
    }

    public Clarity() {
        this.name = "�������";
        this.price = 25;
        this.buff = 50;
    }

    @Override
    public void getDescription(Hero hero, Caryable buff) {
        System.out.println("���� ���� " + hero.mana);
        buff.use(hero);
        System.out.println("� ���� ������ " + hero.mana);
    }

    @Override
    public String toString() {
        return "�������";
    }
}
