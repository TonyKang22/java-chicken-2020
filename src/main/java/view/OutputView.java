package view;

import domain.Menu;
import domain.Money;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String TOP_LINE_WITH_ORDER = "┌ $ ┐";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String TABLE_LIST = "## 테이블 목록";
    private static final String REGISTER = "1 - 주문등록\n";
    private static final String PAY = "2 - 결제하기\n";
    private static final String EXIT = "3 - 시스템 종료\n";
    private static final String TYPE_IN_ACTION = "원하시는 기능을 입력해주세요.";
    private static final String THREE_SPACE = "   ";
    private static final String START_PAYMENT = "번 테이블 결제 시작하겠습니다.\n";
    private static final String PAYMENT_TYPE = "## 카드는 1번, 현금은 2번을 입력해주세요.";
    private static final String PAY_TOTAL_START = "## 결제하실 금액은 ";
    private static final String PAY_TOTAL_END = "원 입니다.\n";
    private static final String NEW_LINE = "\n";

    public static void printTables(final List<Table> tables) {
        System.out.println(TABLE_LIST);
        final int size = tables.size();
        printTop(tables);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTop(List<Table> tables) {
        tables.forEach(table -> {
            if (!table.isEmpty()) {
                System.out.print(TOP_LINE_WITH_ORDER);
                return;
            }
            System.out.print(TOP_LINE);
        });
        System.out.println();
    }

    public static void printAction() {
        String str = REGISTER +
                PAY +
                EXIT +
                TYPE_IN_ACTION;
        System.out.println(str);
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void printOrderedMenus(StringBuilder sb, Map<Menu, Integer> orders) {
        orders.forEach((key, value) -> sb.append(key.getName())
                .append(THREE_SPACE)
                .append(value.toString())
                .append(THREE_SPACE)
                .append(key.getPrice())
                .append(NEW_LINE));
    }

    public static void printPay(Table table) {
        String str = table.getId() +
                START_PAYMENT +
                PAYMENT_TYPE;
        System.out.println(str);
    }

    public static void printTotalPayAmount(Money money) {
        String str = PAY_TOTAL_START +
                money.getAmount() +
                PAY_TOTAL_END;
        System.out.println(str);
    }
}
