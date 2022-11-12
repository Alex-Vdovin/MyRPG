import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Bag{
    protected List<Caryable> items;

    public Bag() {
        items = new ArrayList<>(20);
    }

    public void addSomething(Caryable caryable) {
        items.add(caryable);
    }

    public void printItems() {
        items.stream().map(item -> item.getName() + " - " + item.getPrice() + " золотых ").collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().forEach(System.out::println);

    }
}
