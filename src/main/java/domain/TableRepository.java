package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(4));
        tables.add(new Table(5));
        tables.add(new Table(6));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table findByNumber(int id) throws IllegalStateException {
        return tables().stream()
                .filter(table -> table.validateSameTable(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 테이블입니다."));
    }
}
