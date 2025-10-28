package service;

import constant.Constant;
import domain.User;

public class BankService {
    public void transfer(User from, User to, Double amount) {
        if (Constant.Bank.isBankMaintain){
            System.out.println(Constant.ErrorMessage.BANK_MAINTAIN);
            return;
        }

        from.withdraw(amount);
        to.deposit(amount);

        System.out.println(Constant.SuccessMessage.TRANSFER_SUCCESS);
    }
}
