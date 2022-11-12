public class Wizard extends Hero {

    public Wizard(String name) {
        this.name = name;
        this.level = 1;
        this.health = 150;
        this.currentMaxHealth = this.health;
        this.mana = 250;
        this.currentMaxMana = this.mana;
        this.strength = 3;
        this.agility = 8;
        this.experience = 0;
        this.money = 0;
        this.bag = new Bag();
    }


    @Override
    public void hit(Monster monster) {
        int manaDamage = mana / 10;
        if (this.agility * 10 > Math.random() * 100) {
            if (this.agility > Math.random() * 100) {
                monster.health -= this.strength * 2 + manaDamage;
                this.mana -= this.mana / 10;
                System.out.println(this.name + " наносит сокрушительный удар!\nУрон " + ((this.strength + manaDamage) * 2));
                monster.painSound();
                monster.checkHealth();
                checkMana(this);

            } else {
                monster.health -= this.strength + manaDamage;
                this.mana -= this.mana / 10;
                System.out.println(this.name + " наносит удар.\nУрон " + (this.strength + manaDamage));
                monster.checkHealth();
                checkMana(this);
            }

        } else {
            System.out.println("Промах!");
        }
    }

    public void checkMana(Wizard wizard) {
        if (wizard.mana <= 0) {
            System.out.println("Мана закончилась... Теперь только рукопашка...");
        }
    }
}
