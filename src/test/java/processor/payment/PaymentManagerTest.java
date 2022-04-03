package processor.payment;

import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class PaymentManagerTest {

    @Mock private DiscountPolicy policy;

    @Test
    @DisplayName("수량에 따른 올바른 할인")
    void correctDiscountForQuantity() {
        // given
        Table table = new Table(1);
        PaymentManager payment = new PaymentManager(PaymentType.CARD, this.policy);

        Menu friedChicken = MenuRepository.findById(1);
        int chickenCount = 10;

        // when
        table.addOrder(friedChicken, 10);
        Money calculatedTotal = new Money(150_000);

        // then
        assertEquals(payment.calculateActualTotal(table), calculatedTotal);
    }

    @DisplayName("현금 사용 시 5% 할인 (10마리 미만)")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"CARD"})
    void discountIfCash(PaymentType paymentType) {

        // given
        Table table = new Table(1);
        PaymentManager payment = new PaymentManager(paymentType, this.policy);
        assertNotNull(payment);

        Menu seasonedChicken = MenuRepository.findById(1);
        int chickenCount = 5;


        // when
        table.addOrder(seasonedChicken, chickenCount);
        Money withCash = new Money(76_000);

        // then
        assertEquals(payment.calculateActualTotal(table), withCash);
    }

    @DisplayName("현금 사용 시 5% 할인 (10마리 미만)")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"CARD"})
    void discountIfCashMoreThanTenChickens(PaymentType paymentType) {

        // given
        Table table = new Table(1);
        PaymentManager payment = new PaymentManager(paymentType, this.policy);

        Menu seasonedChicken = MenuRepository.findById(1);
        int chickenCount = 5;

        given(policy.discount(table)).willReturn(new Money(76_000));

        // when
        table.addOrder(seasonedChicken, chickenCount);
        Money withCash = new Money(76_000);

        // then
        assertEquals(payment.calculateActualTotal(table), withCash);
    }
}