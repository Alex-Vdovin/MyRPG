public interface Caryable {
    void use(Hero hero);

    String getName();

    void getDescription(Hero hero, Caryable buff);

    int getPrice();
}
