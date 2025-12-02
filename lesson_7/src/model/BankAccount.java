package model;

public class BankAccount {
    private int balance = 1000000; // Có 1 triệu

    // Hàm rút tiền KHÔNG AN TOÀN (chưa có synchronized)
    public void withdraw(int amount, String name) {
        System.out.println(name + " đang kiểm tra số dư...");

        // 1. Kiểm tra điều kiện (Check)
        if (balance >= amount) {
            // Giả lập độ trễ của mạng/database (mấu chốt gây lỗi ở đây)
            // Trong lúc ông chồng đang chờ, bà vợ chen vào kiểm tra và thấy tiền vẫn còn
            try { Thread.sleep(1000); } catch (InterruptedException e) {}

            // 2. Trừ tiền (Act)
            balance = balance - amount;
            System.out.println(name + " đã rút thành công " + amount);
        } else {
            System.out.println(name + " giao dịch thất bại (Không đủ tiền).");
        }
    }

    public int getBalance() {
        return balance;
    }
}
