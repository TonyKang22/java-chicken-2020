package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    @Test
    @DisplayName("테이블의 주문지 생성")
    void createOrderForTable() {
        // given
        Table table = new Table(1);

        // when

        // then
        assertNotNull(table.getOrders());
    }

    @Test
    @DisplayName("주문 하지 않았을 때 상태는 WAITING")
    void checkStatusWithoutOrdering() {
        // given
        Table table = new Table(2);

        // when

        // then
        assertEquals(table.getOrderStatus(), OrderStatus.WAITING);
    }

    @Test
    @DisplayName("주문시 테이블 상태 변경")
    void changeStatusWhenOrdered() {
        // given
        Table table = new Table(2);

        // when
        table.addOrder(MenuRepository.menus().get(0), 2);

        // then
        assertEquals(table.getOrderStatus(), OrderStatus.ORDERED);
    }

    @Test
    @DisplayName("테이블 총액 계산하기")
    void test() {
        // given
        Table table = new Table(1);

        // when
        table.addOrder(MenuRepository.menus().get(7), 4);
        table.addOrder(MenuRepository.menus().get(1),1);

        // then
        assertEquals(table.calculateSum(), new Money(20_000));
    }

}