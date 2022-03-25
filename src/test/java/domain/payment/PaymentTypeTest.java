package domain.payment;

import domain.domain.MenuRepository;
import domain.domain.Money;
import domain.domain.Table;
import domain.domain.payment.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    @DisplayName("현금으로 결제는 10% 할인")
    void discountForCash() {
        // given
        Table table = new Table(3);
        table.addOrder(MenuRepository.menus().get(1), 1);
        table.addOrder(MenuRepository.menus().get(7), 4);

        // when
        Money discountedSum = Payment.CASH.calculate(table.calculateSum());

        // then
        assertEquals(discountedSum, new Money(18_000));
    }

    @Test
    @DisplayName("카드 결제는 할인 없음")
    void noDiscountForCard() {
        // given
        Table table = new Table(2);
        table.addOrder(MenuRepository.menus().get(1), 1);
        table.addOrder(MenuRepository.menus().get(7), 4);

        // when
        Money discountedSum = Payment.CARD.calculate(table.calculateSum());

        // then
        assertEquals(discountedSum, new Money(20_000));
    }
}