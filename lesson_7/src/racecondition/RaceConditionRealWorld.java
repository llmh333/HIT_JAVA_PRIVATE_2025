package racecondition;

import model.BankAccount;

public class RaceConditionRealWorld {
    public static void main(String[] args) throws InterruptedException {
        BankAccount sharedAccount = new BankAccount();

        // Thread Chồng
        Thread husband = new Thread(() -> {
            sharedAccount.withdraw(1000000, "Ông Chồng");
        });

        // Thread Vợ
        Thread wife = new Thread(() -> {
            sharedAccount.withdraw(1000000, "Bà Vợ");
        });

        husband.start();
        wife.start();

        // Chờ 2 người rút xong để kiểm tra số dư cuối
        husband.join();
        wife.join();

        System.out.println("----------------------------------");
        System.out.println("Số dư cuối cùng: " + sharedAccount.getBalance());
        // KẾT QUẢ SẼ LÀ: -1 triệu (Lỗi nghiêm trọng)
    }
}
