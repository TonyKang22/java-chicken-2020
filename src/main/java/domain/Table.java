package domain;

public class Table {

    private Orders orders;
    private final int number;
    private OrderStatus orderStatus;

    public Table(final int number) {
        this.orders = new Orders();
        this.orderStatus = OrderStatus.WAITING;
        this.number = number;
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

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
