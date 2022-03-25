package domain.domain;

import domain.domain.Menu;
import domain.domain.Money;
import domain.domain.OrderStatus;
import domain.domain.Orders;

import java.util.Map;

public class Table {

    private Orders orders;
    private final int id;
    private OrderStatus orderStatus;

    public Table(final int id) {
        this.orders = new Orders();
        this.orderStatus = OrderStatus.WAITING;
        this.id = id;
    }

    public void addOrder(Menu menu, int count) {
        orderStatus = OrderStatus.ORDERED;
        orders.addOrder(menu, count);
    }

    public Money calculateSum() {
        return orders.calculateSum();
    }

    public Orders getOrders() {
        return this.orders;
    }

    public Map<Menu, Integer> getOrderedMenus() {
        return orders.getOrderedMenus();
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public boolean validateSameTable(int id) {
        return this.id == id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
