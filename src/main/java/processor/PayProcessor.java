package processor;

import domain.Table;
import domain.TableRepository;
import processor.payment.DiscountPolicy;
import processor.payment.PaymentManager;
import processor.payment.PaymentType;
import processor.payment.QuantityDiscountPolicy;
import view.InputView;
import view.OutputView;

public class PayProcessor implements CommandProcessor {

    private static final String TABLE_STATUS_ERROR = " 번 테이블의 주문 내역은 없습니다. 다시 확인 바랍니다.";

    @Override
    public void run() throws IllegalStateException {
        OutputView.printTables(TableRepository.tables());
        Table table = selectTable(InputView.inputTableNumberPay());

        OutputView.printPay(table);
        PaymentManager chosenType = checkForDiscount(new QuantityDiscountPolicy());
        OutputView.printTotalPayAmount(chosenType.calculateActualTotal(table));
        table.cleanTable();
    }

    private Table selectTable(int tableId) {
        Table selectedTable = TableRepository.findByNumber(tableId);
        if (selectedTable.isEmpty()) {
            throw new IllegalStateException(tableId + TABLE_STATUS_ERROR);
        }
        return TableRepository.findByNumber(tableId);
    }

    private PaymentManager choosePaymentType(DiscountPolicy policy) {
        PaymentType paymentType = PaymentType.of(InputView.inputPaymentOption());
        return new PaymentManager(paymentType, policy);
    }

    private PaymentManager checkForDiscount(DiscountPolicy discountPolicy) {
        return choosePaymentType(discountPolicy);
    }
}
