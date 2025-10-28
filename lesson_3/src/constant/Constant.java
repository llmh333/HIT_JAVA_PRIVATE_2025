package constant;

public class Constant {
    public static class Account{
        public static boolean isAccountLocked = false;
        public static Double isAccountDepositLimit = 10000000.0;
        public static Double isAccountDrawLimit = 1000.0;
    }

    public static class Bank{
        public static boolean isBankMaintain = false;
    }

    public static class ErrorMessage{
        public static String INVALID_AMOUNT = "Invalid amount";
        public static String ACCOUNT_LOCKED = "Account locked";
        public static String OVER_LIMIT_AMOUNT = "Over limit amount";
        public static String BANK_MAINTAIN = "Bank maintain";
    }

    public static class SuccessMessage{
        public static String TRANSFER_SUCCESS = "Transfer successful";
        public static String DEPOSIT_SUCCESS = "Deposit successful";
        public static String DRAW_SUCCESS = "Draw successful";
    }
}
