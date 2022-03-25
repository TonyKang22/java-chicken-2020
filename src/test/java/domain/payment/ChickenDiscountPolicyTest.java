package domain.payment;

import domain.MenuRepository;
import domain.Money;
import domain.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChickenDiscountPolicyTest {

    @Test
    @DisplayName("20 마리 주문하면 20000원 할인")
    void dicountTwoForTwenty() {
        // given
        Table table = new Table(6);

        // when
        table.addOrder(MenuRepository.menus().get(3), 20);

        // then
        assertEquals(ChickenDiscountPolicy.getDiscountMoney(table.getOrders()), new Money(20_000));
    }

    @Test
    @DisplayName("10 마리 이하는 할인 없음")
    void noDiscountUnderTenChicken() {
        // given
        Table table = new Table(6);

        // when
        table.addOrder(MenuRepository.menus().get(3), 9);

        // then
        assertEquals(ChickenDiscountPolicy.getDiscountMoney(table.getOrders()), new Money(0));
    }

}