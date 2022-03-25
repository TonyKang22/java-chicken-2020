package domain;

public class Menu {
    private final int id;
    private final String name;
    private final Category category;
    private final Money price;

    public Menu(final int id, final String name, final Category category, final Money price) {
        this.id = id;
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

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public boolean validateSameMenu(int id) {
        return this.id == id;
    }

    @Override
    public String toString() {
        return category + " " + id + " - " + name + " : " + price + "원";
    }
}
