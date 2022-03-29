package processor.payment;

import domain.Money;
import domain.Table;

public interface DiscountPolicy {

    Money discount(Table table);
}
