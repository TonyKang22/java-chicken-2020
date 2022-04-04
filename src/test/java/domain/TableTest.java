package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private Table table;

    @BeforeEach
    void createTable() {
        table = new Table(1);
    }

    @Test
    @DisplayName("주문 시 테이블 상태")
    void checkStatusWhenOrdered() {
        // given
        Menu something = MenuRepository.findById(1);
        int count = 1;

        // when
        table.addOrder(something, count);

        // then
        assertFalse(table.isEmpty());
    }

    @DisplayName("테이블 총액 계산하기")
    @ParameterizedTest(name = "{displayName}")
    @CsvSource({"1, 1, 16000"})
    void test(ArgumentsAccessor argAccessor) {
        // given
        Menu chicken = MenuRepository.findById(argAccessor.getInteger(0));
        int count = argAccessor.getInteger(1);
        Money price = new Money(argAccessor.getInteger(2));

        // when
        table.addOrder(chicken, count);

        // then
        assertEquals(table.calculateSum(), price);
    }
}