package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Menu {
    private final int id;
    private final String name;
    private final Category category;
    private final Money price;

    public boolean validateSameMenu(int id) {
        return this.id == id;
    }

    @Override
    public String toString() {
        return category + " " + id + " - " + name + " : " + price + "원";
    }
}
