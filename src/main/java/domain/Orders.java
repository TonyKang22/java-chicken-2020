package domain;

import java.util.HashMap;
import java.util.Map;

public class Orders {

    private static final int ORDER_START = 0;
    private static final int LIMITED_CHICKEN_NUMBER = 99;

    private Map<Menu, Integer> orders = new HashMap<>();
    private int chickenCountSum;

    public Orders() {
        for (Menu menu : MenuRepository.menus()) {
            orders.put(menu, ORDER_START);
        }
        chickenCountSum = ORDER_START;
    }

    public void addOrder(Menu menu, int count) {
        validateChickenCount(updateChickenCount(menu, count));
        orders.compute(menu, (key, value) -> value + count);
    }

    private void validateChickenCount(int chickenCount) {
        if (chickenCount > LIMITED_CHICKEN_NUMBER) {
            throw new IllegalStateException("한 테이블 최대 주문량은 99 마리입니다.");
        }
    }

    private int updateChickenCount(Menu menu, int count) {
        return menu.getCategory() == Category.CHICKEN ? chickenCountSum += count : chickenCountSum;
    }

    public int getTotalChickenCount() {
        return chickenCountSum;
    }

    public Money calculateSum() {
        Money sum = new Money(ORDER_START);
        for (Menu menu : MenuRepository.menus()) {
            Integer menuCount = orders.get(menu);
            sum.calculateOrder(menu.getPrice(), menuCount);
        }
        return sum;
    }
}
