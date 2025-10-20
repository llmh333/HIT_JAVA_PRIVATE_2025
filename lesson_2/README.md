# Buổi 2: Hướng dẫn cơ bản lập trình Java 🚀

---
## Câu lệnh điều kiện, vòng lặp
### 1. Câu lệnh điều kiện
#### 1.1. Câu lệnh If else
- Cú pháp:
```java
    if (n >= 10) System.out.println("N lớn hơn bằng 10");
    else System.out.println("N nhỏ hơn 10");
```
- Câu lệnh `if-else` có cấu trúc như sau: 
```java
    if (điều kiện) {
        (khối lệnh sẽ được thực hiện nếu điều kiện đúng)
    } else {
        (khối lệnh sẽ được thực hiện nếu điều kiện sai)
    }
```
#### 1.2. Switch-case
- Câu lệnh switch-case được sử dụng để thay thế cho nhiều câu lệnh if-else khi so sánh một biến với nhiều giá trị. Ví dụ
- Cú pháp:
```java
    switch(chose) {
        case 1:
            System.out.println("Lựa chọn 1");
            break;
        case 2:
            System.out.println("Lựa chọn 2");
            break;
        default:
            System.out.println("Lựa chọn khác");
            break;
    }
```
---
### 2. Vòng lặp 🔃
#### 2.1 Vòng lặp For
Dùng để lặp qua một đoạn mã số lần cố định. Ví dụ
```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

#### 2.2 Vòng lặp While
Lặp khi điều kiện còn đúng. Ví dụ
```java
int i = 0;
while (i < 5) {
    System.out.println("i = " + i);
    i++;
}
```

#### 2.3 Vòng lặp Do-while
Lặp ít nhất 1 lần, sau đó mới kiểm tra điều kiện
```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (n < 10);
```
---
# Hàm trong JAVA
Hàm (function) là một khối code chứa các câu lệnh và thường thực hiện những nhiệm vụ cụ thể
- Ví dụ hàm tính tổng:
```java
public int sum(int a, int b) {
    return a+b;
}
```
Vậy tại sao chúng ta nên sử dụng hàm, và sử dụng hàm khi nào?
- Việc sử dụng hàm giúp code rõ ràng, tường minh hơn, các chức năng đặc thù được xử lí riêng, dễ debug, có thể tái sử dụng không cần viết lại code logic nhiều lần.
- Nên sử dụng hàm cho các logic chuyên biệt, các logic có thể tái sử dụng nhiều lần.

---
# Hằng trong JAVA (static, final và static final)
Hằng là một biến không thay đổi giá trị sau khi được gán,

## 1. Final
- Một hằng thường được khai báo với từ khóa `final`
- VD:
```java
    final int n = 5;
```
- Khi khai báo biến với `final`, biến chỉ được gán giá trị 1 lần duy nhất sau khi khai báo
- Khi một class được khai báo với `final`, lớp đó không thể được kế thừa từ các lớp con khác
- Một hàm static không thể truy cập vào một biến không được khai báo static
## 2. Static
- Khi một biến hay một hàm được khai báo với từ khóa `static`, tức là nó thuộc về lớp chứ không thuộc về đối tượng

- Ví dụ:
```java
public class DongVat {
    static int count;
}

public class Main {
    public static void main(String[] args) {
        DongVat cho = new DongVat();
        System.out.println("Số lượng con vật đã tạo: " + cho.count);
        DongVat meo = new DongVat();
        System.out.println("Số lượng con vật đã tạo: " + meo.count);
    }
}
```
```text
# output
Số lượng con vật đã tạo: 1
Số lượng con vật đã tạo: 2
```

## 3. Static final
- Đây là kết hợp tính chất của cả static và final
- Khi khai báo biến với từ khóa `static final`, biến này được gán dữ liệu một lần duy nhất sau khi khai báo và biến này thuộc về lớp
- Sử dụng khi bạn cần khai báo các hằng không thay đổi giá trị và không cần tạo đối tượng mới khi truy cập vào hằng
- Thường được sử dụng cho các class mang tính tiện ích, dùng chung(Utils)
```java
public class MessagesUtils {
    public static final String login = "Đăng nhập thành công";
    public static final String register = "Đăng ký thành công";
}
```
---

Lớp String trong JAVA
- Lớp String trong Java là một cách mạnh mẽ để làm việc với chuỗi ký tự
- Lớp String trong java cung cấp rất nhiều các phương thức để thực hiện các thao tác với chuỗi như: compare(), concat(), equals(), split(), length(), replace(), compareTo(), intern(), substring(), ...

```java

// Khai báo và nối chuỗi
String firstName = "John";
String lastName = "Doe";
String fullName = firstName + " " + lastName;
String fullNameConcat = firstName.concat(" ").concat(lastName);

// So sánh chuỗi
String str1 = "Hello";
String str2 = "World";
String str3 = "Hello";
boolean areEqual1 = str1.equals(str2); // Kết quả: false
boolean areEqual2 = str1.equals(str3); // Kết quả: true
boolean areEqualIgnoreCase = str1.equalsIgnoreCase("HELLO");
// Kết quả: true
// Lấy độ dài chuỗi
String text = "Hello, world!";
int length = text.length(); // Kết quả: 13

// Trích xuất và tìm kiếm chuỗi con
String sentence = "Java programming is fun and powerful.";
String subString = sentence.substring(5, 15);
// Kết quả: "programming"

int indexOfFun = sentence.indexOf("fun"); // Kết quả: 20

// Thay thế và chuyển đổi chuỗi
String originalText = "I like apples and apples are tasty.";
String replacedText = originalText.replace("apples", "bananas");
String uppercaseText = originalText.toUpperCase();
String lowercaseText = originalText.toLowerCase();

// Kiểm tra chuỗi có chứa một ký tự/chuỗi con hay không
String message = "Hello, Java programming.";
boolean startsWithHello = message.startsWith("Hello");
// Kết quả: true

boolean endsWithProgramming = message.endsWith("programming.");
// Kết quả: false

boolean containsJava = message.contains("Java");
// Kết quả: true

```

--- 
Mảng trong JAVA
- Thông thường, mảng (array) là một tập hợp các phần tử có cùng kiểu được lưu trữ gần nhau trong bộ nhớ
- Mảng trong java là một đối tượng chứa các phần tử có kiểu dữ liệu giống nhau. Mảng là một cấu trúc dữ liệu nơi lưu trữ các phần tử giống nhau. Với mảng trong java chúng ta chỉ có thể lưu trữ một tập các phần tử có số lượng phần tử cố định (gọi là mảng tĩnh)
- Mảng trong java lưu các phần tử theo chỉ số, chỉ số của phần tử đầu tiên là 0
- Chúng ta cũng có thể dùng mảng để lưu trữ một danh sách các đối tượng
```java
    // Khai báo mảng kiểu int có 5 phần tử
    int[] numbers = new int[5];

    // Khai báo và khởi tạo mảng ngay từ đầu
    int[] primes = {2, 3, 5, 7, 11};
    
    // Truy cập phần tử trong mảng
    int firstNumber = numbers[0]; // Lấy phần tử đầu tiên của mảng numbers

    // Thay đổi giá trị của phần tử
    primes[2] = 13; // Giá trị 5 được thay đổi thành 13

    // Duyệt mảng bằng vòng lặp for
    for (int i = 0; i < primes.length; i++) {
        System.out.println(primes[i]);  
    }

    // Duyệt mảng bằng vòng lặp for-each
    for (int prime : primes) {
        System.out.println(prime);
    }
```

```java
public class DongVat {
    private String name;
    private String weight;
    
    public DongVat() {}
    
    public DongVat(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        DongVat[] animals = new DongVat[2];
        DongVat cho = new DongVat("Cho", "12 Kg");
        DongVat meo = new DongVat("Meo", "1 Kg");
        
        animals[0] = cho;
        animals[1] = meo;
    }
}
```
---
# Bài tập thực hành
Bài tập: Tạo một mảng có kích thước là 100, giá trị của phần từ bằng với chỉ số của phần tử đó (a[i] = i). Thực hiện viết hàm:
- Tính tổng, tích các phần tử trong mảng
- In ra các phần tử là số nguyên tố
