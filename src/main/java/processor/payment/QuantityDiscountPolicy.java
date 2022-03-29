package processor.payment;

import domain.Money;
import domain.Table;

public class QuantityDiscountPolicy implements DiscountPolicy {

    private static final int PER_CHICKEN = 10;
    private static final int DISCOUNT_MONEY = 10000;

    @Override
    public Money discount(Table table) {
        int chickenNumber = table.getOrder().countChickenOrder();
        return new Money((chickenNumber / PER_CHICKEN) * DISCOUNT_MONEY);
    }
}
