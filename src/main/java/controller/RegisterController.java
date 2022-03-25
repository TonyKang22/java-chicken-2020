package domain.controller;

import domain.controller.CommandController;
import domain.domain.Menu;
import domain.domain.MenuRepository;
import domain.domain.Table;
import domain.domain.TableRepository;
import view.InputView;
import view.OutputView;

public class RegisterController implements CommandController {

    @Override
    public void run() throws IllegalAccessException {
        OutputView.printTables(TableRepository.tables());
        Table table = TableRepository.findByNumber(InputView.inputTableNumber());
        OutputView.printMenus(MenuRepository.menus());
        Menu menu = MenuRepository.findById(InputView.inputMenuId());
        table.addOrder(menu, InputView.inputMenuCount());
    }
}
