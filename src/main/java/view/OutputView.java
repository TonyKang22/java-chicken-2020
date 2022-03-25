package view;

import domain.Menu;
import domain.Money;
import domain.OrderStatus;
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
    private static final String ORDER_LIST = "## 주문 내역\n";
    private static final String ORDER_QUANTITY_PRICE = "메뉴  |  수량  |  금액\n";
    private static final String SPACE = " ";
    private static final String START_PAYMENT = "번 테이블 결제 도와드리겠습니다.\n";
    private static final String PAYMENT_TYPE = "## 카드는 1번, 현금은 2번을 입력해주세요.";
    private static final String PAY_TOTAL_START = "## 결제하실 금액은 ";
    private static final String PAY_TOTAL_END = "원 입니다.\n";

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
            if (table.getOrderStatus() == OrderStatus.ORDERED) {
                System.out.printf(TOP_LINE_WITH_ORDER);
                return;
            }
            System.out.printf(TOP_LINE);
        });
        System.out.println();
    }

    public static void printAction() {
        StringBuilder sb = new StringBuilder();
        sb.append(REGISTER)
                .append(PAY)
                .append(EXIT)
                .append(TYPE_IN_ACTION);
        System.out.println(sb.toString());
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printOrders(Table table) {
        StringBuilder sb = new StringBuilder();
        sb.append(ORDER_LIST)
                .append(ORDER_QUANTITY_PRICE);
        printOrderedMenus(sb, table.getOrderedMenus());
        System.out.println(sb.toString());
    }

    private static void printOrderedMenus(StringBuilder sb, Map<Menu, Integer> orders) {
        orders.forEach((key, value) -> sb.append(key.getName())
                .append(SPACE)
                .append(value.toString())
                .append(SPACE)
                .append(key.getPrice()));
    }

    public static void printPay(Table table) {
        StringBuilder sb = new StringBuilder();
        sb.append(table.getId())
                .append(START_PAYMENT)
                .append(PAYMENT_TYPE);
        System.out.println(sb);
    }

    public static void printTotalPayAmount(Money money) {
        StringBuilder sb = new StringBuilder();
        sb.append(PAY_TOTAL_START)
                .append(money.getAmount())
                .append(PAY_TOTAL_END);
        System.out.println(sb);
    }
}
