package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class RegisterController implements CommandController {

    @Override
    public void run() throws IllegalStateException {
        OutputView.printTables(TableRepository.tables());
        Table table = TableRepository.findByNumber(InputView.inputTableNumber());
        OutputView.printMenus(MenuRepository.menus());
        Menu menu = MenuRepository.findById(InputView.inputMenuId());
        table.addOrder(menu, InputView.inputMenuCount());
    }
}
