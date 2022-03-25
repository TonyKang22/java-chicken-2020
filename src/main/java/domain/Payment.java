package domain;

public enum Payment {
    CARD(1),
    CASH(0.9);

    private final double discountRate;

    Payment(double discountRate) {
        this.discountRate = discountRate;
    }

    public Money calculate(Money total) {
        return new Money((int) (this.discountRate * total.getAmount()));
    }

}
