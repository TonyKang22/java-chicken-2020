package domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private static final int ORDER_START = 0;
    private static final int LIMITED_CHICKEN_NUMBER = 99;

    private final Map<Menu, Integer> orders = new HashMap<>();

    public Order() {
        for (Menu menu : MenuRepository.menus()) {
            this.orders.put(menu, ORDER_START);
        }
    }

    public void addOrder(Menu menu, int count) {
        validateChickenCount(count, countChickenOrder());
        this.orders.compute(menu, (key, value) -> value + count);
    }

    public int countChickenOrder() {
        return (int) (Integer) orders.entrySet().stream()
                .filter(map -> map.getKey().getCategory() == Category.CHICKEN)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int getMenuCount(Menu menu) {
        return this.orders.get(menu);
    }

    public boolean hasOrders() {
        return orders.entrySet()
                .stream()
                .anyMatch(key -> key.getValue() != 0);
    }

    private void validateChickenCount(int newOrderCount, int existingOrderCount) {
        if (newOrderCount + existingOrderCount > LIMITED_CHICKEN_NUMBER) {
            throw new IllegalStateException("한 테이블 최대 주문량은 99 마리입니다.");
        }
    }
}
