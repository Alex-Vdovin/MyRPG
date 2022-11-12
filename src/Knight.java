public class Knight extends Hero {

    public Knight(String name) {
        this.name = name;
        this.level = 1;
        this.health = 250;
        this.strength = 15;
        this.agility = 8;
        this.experience = 0;
        this.money = 0;
        this.bag = new Bag();
        this.currentMaxHealth = this.health;
    }
    @Override
    public void hit(Monster monster) {
        if (this.agility * 10 > Math.random() * 100) {
            if (this.agility > Math.random() * 100) {
                monster.health -= this.strength * 2;
                System.out.println(this.name + " наносит сокрушительный удар!\nУрон " + (this.strength * 2));
                monster.checkHealth();
            } else {
                monster.health -= this.strength;
                monster.painSound();
                System.out.println(this.name + " наносит удар.\nУрон " + this.strength);
                monster.checkHealth();
            }

        } else {
            System.out.println("Промах!");
        }
    }

}
