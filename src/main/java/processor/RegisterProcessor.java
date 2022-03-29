package processor;

import domain.*;
import view.InputView;
import view.OutputView;

public class RegisterProcessor implements CommandProcessor {

    @Override
    public void run() throws IllegalStateException {
        OutputView.printTables(TableRepository.tables());

        Table table = selectTable(InputView.inputTableNumber());
        orderMenu(table);
    }

    private Table selectTable(int tableId) {
        return TableRepository.findByNumber(tableId);
    }

    private void orderMenu(Table table) {
        OutputView.printMenus(MenuRepository.menus());
        Menu menu = MenuRepository.findById(InputView.inputMenuId());

        table.addOrder(menu, InputView.inputMenuCount());
    }
}
