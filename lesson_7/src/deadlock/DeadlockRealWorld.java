package deadlock;

import model.Account;

public class DeadlockRealWorld {
    public static void main(String[] args) {
        Account accA = new Account("Tài khoản A", 5000);
        Account accB = new Account("Tài khoản B", 5000);

        // Thread 1: A chuyển cho B
        Thread t1 = new Thread(() -> {
            accA.transferTo(accB, 1000);
        });

        // Thread 2: B chuyển ngược lại cho A
        Thread t2 = new Thread(() -> {
            accB.transferTo(accA, 1000);
        });

        t1.start();
        t2.start();

        // KẾT QUẢ: Chương trình sẽ chạy 2 dòng đầu rồi TREO MÁY VĨNH VIỄN.
        // Đèn đỏ trên IDE vẫn sáng nhưng không có gì in ra thêm.
    }
}
