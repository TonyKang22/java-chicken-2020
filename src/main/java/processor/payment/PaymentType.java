package processor.payment;

import domain.Money;

import java.util.Arrays;

public enum PaymentType {

    CARD(1, 1),
    CASH(2, 0.95);

    private final int id;
    private final double discountRate;

    PaymentType(int id, double discountRate) {
        this.id = id;
        this.discountRate = discountRate;
    }

    public static PaymentType of(int idInput) {
        return Arrays.stream(values())
                .filter(value -> value.id == idInput)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("결제는 1번 - 카드, 2번 - 현금만 가능합니다."));
    }

    public Money calculate(Money total) {
        return new Money((int) (this.discountRate * total.getAmount()));
    }
}
