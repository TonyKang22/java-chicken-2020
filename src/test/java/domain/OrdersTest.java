package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    MenuRepository menuRepository;

    @Test
    @DisplayName("테이블 주문지 생성")
    void createTableOrder() {
        // given
        Orders orders = new Orders();

        // when

        // then
        assertNotNull(orders);
    }

    @Test
    @DisplayName("주문 수량 확인")
     void orderCountCorrect() {
        // given
        Orders orders = new Orders();

        // when
        orders.addOrder(menuRepository.menus().get(0), 10);

        // then
        assertEquals(orders.getTotalChickenCount(), 10);
    }

    @Test
    @DisplayName("주문 수량 초과")
    void exceedNumberOfChicken() {
        // given
        Orders orders = new Orders();

        // when
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> orders.addOrder(menuRepository.menus().get(1), 100));

        // then
        assertEquals(exception.getMessage(), "한 테이블 최대 주문량은 99 마리입니다.");
    }

    @Test
    @DisplayName("주문 총액 계산")
    void calculateTotalAmount() {
        // given
        Orders orders = new Orders();

        // when
        orders.addOrder(menuRepository.menus().get(1), 1);
        orders.addOrder(menuRepository.menus().get(2), 1);
        Money sum = orders.calculateSum();

        // then
        assertEquals(sum, new Money(32_000));
    }
}