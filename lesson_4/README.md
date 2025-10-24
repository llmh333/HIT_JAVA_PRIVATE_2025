# Buổi 4: Đóng gói (encapsulation) và Kế thừa (Inheritance)

---
## Đóng gói (Encapsulation)

- Tính đóng gói là một trong 4 tính chất quan trọng trong lập trình hướng đối tượng.
- Tính đóng gói là một nguyên lý thiết kế giúp bảo vệ tính vẹn toàn của dữ liệu, dễ dàng bảo trì và mở rộng mã nguồn
- Cho phép ẩn đi chi tiết và bảo vệ các thành phần khỏi sự can thiệp từ bên ngoài.
- Trong Java, tính đóng gói thường được thể hiện qua các class, package và từ khóa phạm vi truy cập (access modifier) 

Ví dụ về bảo vệ tính vẹn toàn của dữ liệu:
```java
public class User {
    private String id;
    private String name;
    private double balance;
    
    public User() {}
    
    public User(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    
    public User(String name) {
        this.name = name;
        this.balance = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getMoney() {
        return this.balance;
    }

    public void deposit(double amount) {
        // Thêm số tiền vào số dư
        balance += amount;
    }
    
    // Phương thức rút tiền
    public void withDraw(double amount) {
        if (amount <= 0) { // Đảm bảo số tiền rút là hợp lệ
            System.out.println("Số iền rút không hợp lệ");
        } else if (balance >= amount) { // Đảm bảo số dư đủ để rút
            balance -= amount;
        } else {
            System.out.println("Số dư không đủ để thực hiện giao dịch");
        }
    }
}
```

- Trong đoạn mã trên, không thể thay đổi số dư của tài khoản bằng cách truy cập thằng vào biến `balance` và gán giá trị, phải thông qua hàm `deposit` và `withDraw`, dữ liệu sẽ được xử lí qua logic nghiệp vụ và đảm bảo tính đúng đắn của dữ liệu
- Khi cần bảo trì, thay đổi logic của các chức năng, chỉ cần sửa trong phương thức.

---
## Kế thừa (Inheritance)
- Đây cũng là một trong 4 tính chất quan trọng trong lập trình hướng đối tượng, giúp tái sử dụng mã nguồn. Thay vì viết lại mã cho từng lớp, ta định nghĩa một lớp nguồn và các lớp con sẽ kế thừa lại những thuộc tính và phương thức chung của lớp cha và lớp con có thể tự định nghĩa lại.
- Kế thừa cho phép lớp con có thể sử dụng lại các thuộc tính, phương thức từ lớp cha tùy thuộc vào phạm vi truy cập
- Lớp con có thể định nghĩa lại các phương thức của lớp cha (Overriding)
- Trong Java không hỗ trợ đa kế thừa.

Ví dụ về kế thừa:

```java
public class Animal {
    private double weight;

    public Animal() {}

    public Animal(double weight) {
        this.weight = weight;
    }

    public void sound() {
        System.out.println("some sound");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

public class Dog extends Animal {
    private String name;
    private String color;

    public Dog() {
        super();
    }

    public Dog(String name, String color, double weight) {
        super(weight);
        this.name = name;
        this.color = color;
    }

    @Override
    public void sound() {
        System.out.println("Gau Gau");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight='" + getWeight() + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

```

Từ khóa `super` trong kế thừa:
- Cho phép lớp con truy cập vào các phương thức, thuộc tính của lớp con mà không bị ghi đè.
- Lớp con gọi constructor của lớp cha.

---
## Quan hệ HAS-A
- Quan hệ HAS-A là quan hệ tham chiếu. Tức là một đối tượng sẽ tham chiếu tới đối tượng khác.
- Ví dụ:
```java
class Address {
    private String city;
    private String country;
}

class Employee {
    private String name;
    private String dob;
    private Address address;
}
```
- Khi này quan hệ giữa Employee và Address là HAS-A
- Áp dụng quan hệ này sẽ giúp tái sử dụng code, tăng tính linh hoạt nhưng liên kết không chặt chẽ.
- Sử dụng khi chỉ cần có một thực thể chung cho các thực thể khác tham chiếu tới, không quá phụ thuộc vào nhau.
---

## Nạp chồng (Overloading) và Ghi đè (Overriding)

Đây là 2 khái niệm điển hình khi nhắc tới tính chất kế thừa và đa hình

### Nạp chồng (Overloading)
- Nạp chồng là việc định nghĩa nhiều phương thức có cùng tên nhưng khác nhau về tham số truyền vào, kiểu dữ liệu trả về, thứ tự tham số truyền vào

```java
class Calculator {
    // Cộng hai số nguyên
    public int add(int a, int b) {
        System.out.println("Đang cộng 2 số nguyên...");
        return a + b;
    }

    // Cộng hai số thực
    public double add(double a, double b) {
        System.out.println("Đang cộng 2 số thực...");
        return a + b;
    }

    // Cộng ba số nguyên
    public int add(int a, int b, int c) {
        System.out.println("Đang cộng 3 số nguyên...");
        return a + b + c;
    }
}
```

## Ghi đè (Overriding)
- Xảy ra trong mối quan hệ IS-A (Kế thừa)
- Ghi đè là việc một lớp con thực hiện một cài đặt cụ thể cho một phương thức đã được định nghĩa ở lớp cha
- Phương thức ghi đè ở lớp con phải cùng tên, cùng tham số với phương thức ở lớp cha.
- Kiểu trả về phải giống hệt hoặc là một kiểu con của phương thức ở lớp cha.
- Phạm vi truy cập phải rộng hơn hoặc bằng phạm vi truy cập ở lớp cha.

```java
public class Animal {
    void sound() {
        System.out.println("some sound");
    }
}

public class Dog extends Animal {
    @Override
    protected void sound() {
        System.out.println("some sound");
    }
}
```
---

## Bài tập thực hành
### Bài tập: Thực hiện thiết kế các lớp sau:

![](https://plantuml.online/png/VP5BRi8m48RtFiKiWTONo08991OiAXRf1GPd4YmS1zcEggZbxYG6nh50tUJnUVm_R6NGUzYr5zCDHF0h02JegW1jG_oss581FZXjcmXKrzlWXenvD3YXgkkFXYOanyS7D1G2kK_myHtHJ-VEYwMu2g6YTOc6oe1r7Rrjtnx9-KCzOGvn5-F9SNl-_xfh-SwUFRz9dQnM6ksZS1X1UTR6p5l9VpM-q693xY7Wdrby0HldS63PkyySiouNs0xxQi4I-oglaDB6kIJAWsEeT8nI_gtvGiMiQhxmp9zJnYifqm5dD2dU0000)
