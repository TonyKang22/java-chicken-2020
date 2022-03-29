package domain;

import lombok.Getter;

@Getter
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

    public boolean validateSameMenu(int id) {
        return this.id == id;
    }

    @Override
    public String toString() {
        return category + " " + id + " - " + name + " : " + price + "원";
    }
}
