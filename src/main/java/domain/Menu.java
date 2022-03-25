package domain;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final Money price;

    public Menu(final int number, final String name, final Category category, final Money price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Money getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
