package domain.domain.payment;

import domain.domain.Money;
import domain.domain.Table;

public class Payment {

    private final ChickenDiscountPolicy chickenDiscountPolicy;
    private final PaymentType paymentType;
    private final Table table;

    public Payment(ChickenDiscountPolicy policy, PaymentType payType, Table table) {
        this.chickenDiscountPolicy = policy;
        this.paymentType = payType;
        this.table = table;
    }

    public Money calculateActualTotal() {
        Money notCalculated = table.calculateSum();
        Money discounted = ChickenDiscountPolicy.getDiscountMoney(table.getOrders());
        return paymentType.calculate(notCalculated.subtractMoney(discounted));
    }
}
