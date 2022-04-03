package domain;

import lombok.Getter;

@Getter
public class Table {

    private static final int ORDER_START = 0;
    private static final int LIMITED_CHICKEN_NUMBER = 99;

    private final int id;
    private Order order;

    public Table(final int id) {
        this.id = id;
        this.order = new Order();
    }

    public void addOrder(Menu menu, int count) {
        this.order.addOrder(menu, count);
    }

    public Money calculateSum() {
        Money sum = new Money(ORDER_START);
        for (Menu menu : MenuRepository.menus()) {
            int menuCount = order.getMenuCount(menu);
            sum.calculateOrder(menu.getPrice(), menuCount);
        }
        return sum;
    }

    public boolean validateSameTable(int id) {
        return this.id == id;
    }

    public boolean isEmpty() {
        return !order.hasOrders();
    }

    public void cleanTable() {
        this.order = new Order();
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
