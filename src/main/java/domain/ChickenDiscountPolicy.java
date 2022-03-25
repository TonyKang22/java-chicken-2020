package domain;

public class ChickenDiscountPolicy {

    private static final int PER_CHICKEN = 10;
    private static final int DISCOUNT_MONEY = 10000;

    public static Money getDiscountMoney(Orders orders) {
        int chickenNumber = orders.getTotalChickenCount();
        return new Money((chickenNumber / PER_CHICKEN) * DISCOUNT_MONEY);
    }
}
