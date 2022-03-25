package domain;

import lombok.Getter;

@Getter
public class Order {

    private final Menu menu;
    private final int count;

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public int calculatePrice() {
        return menu.getPrice() * count;
    }
}
