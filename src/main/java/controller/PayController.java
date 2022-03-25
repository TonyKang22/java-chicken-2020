package domain.controller;

import domain.domain.Table;
import domain.domain.TableRepository;
import domain.domain.payment.ChickenDiscountPolicy;
import domain.domain.payment.PaymentType;
import domain.domain.payment.Payment;
import view.InputView;
import view.OutputView;

public class PayController implements CommandController {

    @Override
    public void run() throws IllegalAccessException {
        OutputView.printTables(TableRepository.tables());
        Table table = TableRepository.findByNumber(InputView.inputTableNumberPay());
        OutputView.printOrders(table);
        OutputView.printPay(table);
        PaymentType paymentType = PaymentType.of(InputView.inputPaymentOption());
        Payment payment = new Payment(new ChickenDiscountPolicy(), paymentType, table);
        OutputView.printTotalPayAmount(payment.calculateActualTotal());
    }
}
