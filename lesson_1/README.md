# 🎉 Buổi 1: Làm quen với JAVA & Github

Chào mừng các bạn đến với khóa học Java! Trong buổi đầu tiên này, chúng ta sẽ cùng nhau làm quen và xây dựng nền tảng vững chắc cho những buổi học tiếp theo. Dưới đây là các nội dung chính của buổi học:

---

## 👋 Giới Thiệu & Làm Quen Mọi Người

- Giới thiệu Leader, Supporter và các bạn HIT 16
- Tạo khôn khí thân thiện và khuyến khích sự tương tác
- Hoạt động nhỏ để mọi người biết nhau hơn
- Mọi người sẽ được gặp gỡ, trò chuyện với các anh chị cựu của lớp Java, hãy suy nghĩ và đặt các câu hỏi cho anh chị để được giải đáp thắc mắc nhá!

---

## 📁 Giới thiệu Github và hướng dẫn sử dụng Github cơ bản để nộp BTVN

### Github là gì ?

GitHub là một nền tảng lưu trữ và quản lý mã nguồn dựa trên Git, cho phép nhiều người cùng làm việc trên cùng một dự án.
Nó giúp lưu trữ, chia sẻ, theo dõi lịch sử thay đổi mã nguồn và hợp tác nhóm trong lập trình một cách hiệu quả.

### Một số chức năng chính của Github
- Lưu trữ mã nguồn
- Theo dõi thay đổi của mã nguồn
- Làm việc nhóm qua các nhánh và pull request
- Quản lí issue, bug và tài liệu dự án
- 
### Sử dụng Github cơ bản để nộp BTVN
- Tạo tài khoản Github
- Tạo repository cho dự án Java
- Cách commit và push code lên Github (Các bạn có thể về tìm hiểu thêm Conventional commit để commit một cách chuẩn hơn)
- Các câu lệnh cơ bản để push 1 source code lên Github:

```bash
git add .
git commit -m "Initial commit"
git push -u origin main
```

---

## 🖥️ Cấu Trúc Chương Trình Java

Hiểu rõ cấu trúc cơ bản của một chương trình Java là bước đầu quan trọng để viết mã hiệu quả.
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```
- **Class**: Định nghĩa một lớp trong Java
- **Method**: Phương thức `main` là điểm bắt đầu của chương trình

---

## 📥📤 Nhập, Xuất & Kiểu Dữ Liệu
### 1. Nhập dữ liệu
Sử dụng lớp `Scanner` để nhận dữ liệu từ người dùng  
Vậy trước hết ta cần tìm hiểu lớp Scanner là gì? Tại sao lại không dùng trực tiếp System.in?
- `Scanner` là một lớp trong Java, nằm trong java.util
- Được dùng đẻ đọc dữ liệu đầu vào (input) từ các nguồn khác nhau, phổ biến nhất là từ bàn phím (System.in)
- `System.in` chỉ đọc vào dữ liệu thô, đọc byte chứ khng đọc kiểu dữ liệu trực tiếp. Dữ liệu được đọc từ System.in sẽ được quy ra bảng mã ASCII
#### Lợi ích khi sử dụng Scanner
- Nhập dữ liệu từ bàn phím một cách nhanh chóng
- Tự động validate kiểu dữ liệu nhập vào (Ở System.in bạn phải tự validate kiểu dữ liệu nhập vào)
- Có thể đọc dữ liệu từ bàn phím, file, chuỗi, API (System.in chỉ đọc từ bàn phím)
```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên của bạn: ");
        String name = scanner.nextLine();
        System.out.println("Chào " + name + "!");
    }
}
```

### 2. Xuất dữ liệu
Sử dụng `System.out.println` để hiển thị thông tin ra màn hình

### 3. Kiểu dữ liệu
- Số nguyên: `int`, `long`
- Số thực: `float`, `double`
- Ký tự: `char`
- Logic: `boolean`
- Chuỗi: `String`
```java
int age = 19;
double salary = 75000.50;
char initial = 'A';
boolean isStudent = true;
String fullName = "Nguyễn Văn A";
```

### Bài tập thực hành

Sử dụng lớp `Scanner` để nhập vào họ tên, tuổi, năm sinh, GPA của mình và xuất ra màn hình những thông tin đó.

---

## 📝 Biến & Quy Tắc Đặt Tên Biến, Class
### 1. Biến

```java
int age = 25;
double salary = 75000.50;
char initial = 'A';
boolean isStudent = true;
String fullName = "Nguyễn Văn A";
```
Biến là nơi lưu trữ dữ liệu trong chương trình, ở ví dụ trên thì biến sẽ là `age` có kiểu dữ liệu là `int`, tương tự với các biến ở dưới

### 2. Quy tắc đặt tên biến, method, class

- **Biến**: sử dụng `camelCase` (ví dụ: fullName, totalAmount)
  - Chữ cái đầu tiên của từ đầu tiên viết thường
  - Chữ cái đầu tiên của các từ tiếp theo viết hoa
- **Class**: sử dụng `PascalCase` (ví dụ: Student, EmployeeService)
  - Viết hoa các chữ cái đầu tiên của các từ
- Không dùng ký tự đặc biệt hoặc bắt đầu bằng số khi đặt tên biến và class.
- Nên sử dụng tiếng anh, rõ ràng, tránh gây nhầm lẫn khi đặt tên cho biến, method, class

---

## ➕➖ Phép Toán & Toán Tử
Java hỗ trợ nhiều toán tử để thực hiện các phép toán cơ bản và nâng cao.

### 1. Các toán tử cơ bản
- **Cộng**: `+`
- **Trừ**: `-`
- **Nhân**: `*`
- **Chia**: `/`
- **Chia lấy dư**: `%`

```java
int a = 10;
int b = 3;

System.out.println("a + b = " + (a + b)); // 13
System.out.println("a - b = " + (a - b)); // 7
System.out.println("a * b = " + (a * b)); // 30
System.out.println("a / b = " + (a / b)); // 3
System.out.println("a % b = " + (a % b)); // 1
```

### 2. Toán tử so sánh
- **Bằng**: `==`
- **Khác**: `!=`
- **Lớn hơn**: `>`
- **Nhỏ hơn**: `<`
- **Lớn hơn hoặc bằng**: `>=`
- **Nhỏ hơn hoặc bằng**: `<=`
### 3. Toán Tử Logic

- **Và**: `&&`
- **Hoặc**: `||`
- **Phủ định**: `!`

```java
boolean isAdult = age >= 18;
boolean hasPermission = true;

if (isAdult && hasPermission) {
    System.out.println("Được phép tham gia.");
} else {
    System.out.println("Không được phép tham gia.");
}
```

### Bài tập thực hành
#### Bài 1: Viết chương trình cho phép người dùng:
- Nhập vào hai số nguyên
- Tính và in ra các phép tính giữa 2 số:
  - Tổng
  - Hiệu
  - Tích
  - Thương
  - Phần dư
- Chú thích: đặt tên file, biến chuẩn theo quy tắc đã học, tránh đặt tên biến như `a`, `b`,...
#### Bài 2: Nhập vào tổng số giây. Hãy quy đổi và in ra số giờ, số phút, số giây từ tổng số giây đã nhập
- Ví dụ: 
  - input: 123
  - output: 0 giờ 2 phút 3 giây


