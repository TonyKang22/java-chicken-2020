package processor.payment;

import domain.Money;
import domain.Table;

public class PaymentManager {

    private final DiscountPolicy policy;
    private final PaymentType paymentType;

    public PaymentManager(PaymentType paymentType, DiscountPolicy policy) {
        this.policy = policy;
        this.paymentType = paymentType;
    }

    public Money calculateActualTotal(Table table) {
        return paymentType.calculate(runDiscount(table));
    }

    private Money runDiscount(Table table) {
        Money beforeDiscount = table.calculateSum();
        Money afterDiscount = this.policy.discount(table);
        return beforeDiscount.subtractMoney(afterDiscount);
    }
}
