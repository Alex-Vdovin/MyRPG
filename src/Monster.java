public abstract class Monster extends Unit {
    public abstract void painSound();

    public void hit(Hero hero) {
        if (this.health > 0) {
            hero.health -= this.strength;
            System.out.println(hero.health > 0 ? this.name + " наносит удар нашему герою!\nУ героя осталось " + hero.health + " здоровья" :
                    this.name + " наносит удар нашему герою!\nУ героя осталось " + 0 + " здоровья");
        }
    }

    public void checkHealth() {
        System.out.println(this.health >= 0 ? "У монстра осталось здоровья " + this.health : "У монстра осталось здоровья " + 0);
    }

}
