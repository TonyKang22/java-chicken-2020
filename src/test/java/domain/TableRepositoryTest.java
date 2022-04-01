package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableRepositoryTest {

    @Test
    @DisplayName("테이블 갯수 6개")
    void isTableCountSix() {
        // given
        List<Table> tables = new ArrayList<>();

        // when
        tables = TableRepository.tables();

        // then
        assertEquals(6, tables.size());
    }

    @Test
    @DisplayName("테이블은 더 이상 추가할 수 없다")
    void cantAddMoreTable() {
        // given
        List<Table> tables = TableRepository.tables();

        // when

        // then
        assertThrows(UnsupportedOperationException.class, () -> tables.add(new Table(7)));
    }

}