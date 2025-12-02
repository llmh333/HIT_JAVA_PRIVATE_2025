package model;

public class Account {
    private String name;
    private int balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }

    // Logic chuyển tiền dễ gây Deadlock
    public void transferTo(Account targetAccount, int amount) {
        // 1. Khóa tài khoản của chính mình (người gửi)
        synchronized (this) {
            System.out.println(this.name + " đang giữ khóa của chính mình (" + this.name + ")...");

            // Giả lập độ trễ mạng để đảm bảo Deadlock xảy ra cho học viên thấy
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            System.out.println(this.name + " đang chờ lấy khóa của " + targetAccount.getName() + " để chuyển tiền...");

            // 2. Cố gắng khóa tài khoản người nhận
            synchronized (targetAccount) {
                System.out.println("Đang chuyển tiền...");
                this.balance -= amount;
                targetAccount.balance += amount;
                System.out.println("Chuyển thành công!");
            }
        }
    }
}
