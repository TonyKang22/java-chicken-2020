package view;

import java.util.Scanner;

public class InputView {

    private static final String SELECT_TABLE = "## 주문할 테이블을 선택하세요.";
    private static final String SELECT_TABLE_PAY = "## 계산할 테이블을 선택하세요.";
    private static final String SELECT_MENU = "## 주문할 메뉴를 선택하세요.";
    private static final String MENU_COUNT = "## 메뉴 수량을 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println(SELECT_TABLE);
        return scanner.nextInt();
    }

    public static int inputTableNumberPay() {
        System.out.println(SELECT_TABLE_PAY);
        return scanner.nextInt();
    }

    public static int inputMenuId() {
        System.out.println(SELECT_MENU);
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println(MENU_COUNT);
        return scanner.nextInt();
    }

    public static int inputActionId() {
        return scanner.nextInt();
    }

    public static int inputPaymentOption() {
        return scanner.nextInt();
    }
}
