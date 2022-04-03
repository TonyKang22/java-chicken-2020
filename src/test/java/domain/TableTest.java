package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    @Test
    @DisplayName("테이블의 주문지 생성")
    void createOrderForTable() {
        // given
        Table table = new Table(1);

        // when

        // then
        assertNotNull(table.getOrder());
    }

    @Test
    @DisplayName("주문 시 테이블 상태")
    void checkStatusWhenOrdered() {
        // given
        Table table = new Table(2);

        // when
        table.addOrder(MenuRepository.menus().get(0), 2);

        // then
        assertFalse(table.isEmpty());
    }

    @DisplayName("테이블 총액 계산하기")
    @ParameterizedTest(name = "{displayName}")
    @CsvSource({"1, 1, 1, 16000"})
    void test(ArgumentsAccessor argAccessor) {
        // given
        Table table = new Table(argAccessor.getInteger(0));

        // when
        table.addOrder(MenuRepository.menus().get(argAccessor.getInteger(1)),argAccessor.getInteger(2));

        // then
        assertEquals(table.calculateSum(), new Money(argAccessor.getInteger(3)));
    }

    @Test
    @DisplayName("주문 총액 계산")
    void calculateTotalAmount() {
        // given
        Table table = new Table(1);

        // when
        table.addOrder(MenuRepository.menus().get(1), 1);
        table.addOrder(MenuRepository.menus().get(2), 1);
        Money sum = table.calculateSum();

        // then
        assertEquals(sum, new Money(32_000));
    }
}