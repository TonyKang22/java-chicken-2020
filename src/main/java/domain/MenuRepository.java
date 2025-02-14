package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, new Money(16_000)));
        menus.add(new Menu(2, "양념치킨", Category.CHICKEN, new Money(16_000)));
        menus.add(new Menu(3, "반반치킨", Category.CHICKEN, new Money(16_000)));
        menus.add(new Menu(4, "통구이", Category.CHICKEN, new Money(16_000)));
        menus.add(new Menu(5, "간장치킨", Category.CHICKEN, new Money(17_000)));
        menus.add(new Menu(6, "순살치킨", Category.CHICKEN, new Money(17_000)));
        menus.add(new Menu(21, "콜라", Category.BEVERAGE, new Money(1_000)));
        menus.add(new Menu(22, "사이다", Category.BEVERAGE, new Money(1_000)));
    }

    public static Menu findById(int id) throws IllegalStateException {
        return menus.stream()
                .filter(value -> value.validateSameMenu(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("메뉴를 다시 확인하시고 주문해주세요."));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }
}
