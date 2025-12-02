# Thread, Regex, Exception, I/O

## Cơ bản về Thread (Luồng)
- Bình thường chúng ta code và chạy file Main, không có tác vụ nào khác, khi này code của chúng ta sẽ chạy một cách tuần tự, xử lí các tác vụ, công việc một cách tuần tự
- Khi có nhiều các tác vụ cần xử lí đồng thời, khi này ta cần đến multithread.
- Để hiểu và áp dụng được multithread thì ta cần hiểu về thread, cách tạo và chạy 1 thread.
- Để tạo 1 thread ta có 2 cách

**Cách 1**: Ta cần kế thừa lại lớp `Thread` có sẵn trong java và override lại method run()
```java
// Định nghĩa 1 thread
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread đang chạy công việc A");
    }
}

// Cách khởi chạy
class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
```

**Cách 2**: Ta triển khai interface `Runnable` của thư viện `java.lang`
```java
// Tạo 1 class triển khai Runnable
class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread đang chạy công việc A");
    }
}

// Cách khởi chạy
class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
}
```

- **Lưu ý**: Tránh nhầm lẫn giữa lời gọi `.run()` và `.start()`
  - Khi gọi `.run()` thực chất chỉ là một lời gọi hàm thông thường, chương trình sẽ không tạo ra 1 luồng mới mà chỉ chạy trên luồng chính (Main thread)
  - Khi gọi `.start()`, khi này JVM sẽ cấp phát và tạo ra 1 luồng mới, tự động gọi hàm `.run()` và chạy song song với luồng chính (Main thread)
- Khi này phát sinh ra 1 vần đề, nếu nhiều luồng cùng xử lí 1 dữ liệu, các thread sẽ tranh nhau thao tác vào dữ liệu đó, dẫn đến việc ghi chồng chéo, sai lệch dữ liệu. Thuật ngữ để nói về vấn đề này là `Race condition`
- Để khắc phục lỗi này 1 cách đơn giản, ta dùng từ khóa `synchronized` cho method, khối câu lệnh cần được đảm bảo vẹn toàn dữ liệu.

## Xử lí Exception
- Bình thường khi code, sẽ có những lỗi xảy ra mà ta không thể ngờ được, chia làm 2 loại exception:
  - Checked Exception (xảy ra khi compile)
  - Unchecked Exception (xảy ra khi runtime)
- Để xử lí các lỗi này, ta có rất nhiều cách, về cơ bản và áp dụng nhiều, ta sẽ sử dụng `try-catch-finally`
```java
try {
    // Khối lệnh mà bạn nghi ngờ sẽ xảy ra lỗi    
} catch (Exception e) {
    // Khi có Exception ném ra thì thực hiện các hành vi ở đây
} finally {
    // Thực hiện cuối cùng sau khi đã chạy ở trên.
}
```

- Luồng thực hiện của `try-catch-finanlly`:
  - Code ở `try` sẽ chạy trước, nếu có exception ném ra, sẽ nhảy vào khối `catch` để handling
  - Cuối cùng khối `finally` luôn luôn được chạy dù khối `try` có ném ra exception hay không.
- Bên cạnh đó ta cũng có thể custom các exception của riêng mình định nghĩa sao cho phù hợp dự án.
- Để tự tạo 1 handle exception, ta sẽ kế thừa lại class `Exception` hoặc `RuntimeException` và dùng từ khóa new để khởi tạo handle exception đó

```java
class InvalidCalculateException extends RuntimeException {
    public InvalidCalculateException(String message) {
        super(message);
        System.out.println(message);
    }
}

class Main {
    public static void main(String[] args) {
        try {
            int a = 0, b = 5;
            System.out.println(a/b);
        } catch (Exception e) {
            throw new InvalidCalculateException("Tính toán xảy ra lỗi");
        } finally {
            System.out.println("Hoàn thành việc tính toán");
        }
    }
}
```

## Java I/O
- Trong java có rất nhiều cách để thực hiện đọc ghi dữ liệu sử dụng Java IO
- Bài học hiện tại, ta chỉ tim hiểu về đọc ghi file. Bên cạnh đó còn rất nhiều công việc cần đến đọc ghi như trong socket, http,...
- Để thực hiện đọc ghi 1 file dữ liệu, ta sử dụng `FileReader` và `FileWriter`

```java
import java.io.FileReader;
import java.io.FileWriter;

class Main {
    public static void main(String[] args) {
        String path = "";

        // Đọc file
        FileReader reader = new FileReader(path);
        int text = reader.read();
        while (text != -1) {
            System.out.println(text);
            text = reader.read();
        }

        // Ghi file
        FileWriter reader = new FileWriter(path);
        int text = reader.read();
        while (text != -1) {
            System.out.println(text);
            text = reader.read();
        }
    }
}

```

## Regex
- Khái niệm: regular expression hay còn gọi là biểu thức chính quy là 1 chuỗi những kí tự liên tục, thường được sử dụng để so khớp dữ liệu có phù hợp với mong muốn của người dùng hay không theo một quy tắc nhất định. Hiểu đơn giản là kiểm tra tính hơp lệ của chuỗi VD: Email, Phone number, username, password hợp lệ ...
```java
    String email1 = "admin@gmail.com";
    String phoneNumber1 = "0123456789";
    String phoneNumber2 = "0333484asd";
```
- Sử dụng regex để kiểm tra tính hợp lệ của chuỗi
  - Pattern: là đối tượng mẫu biên dịch từ regex, hiểu đơn giản là bộ lọc, thường sử dụng phương thức compile(regex) để biên dịch biểu thức
  - Matcher: là phương tiện để so khớp chuỗi với regex, thường sử dụng phương thức matcher(string) để so khớp string với biểu thức
- Quy tắc viết regex:
  - Dấu . : khớp bất kì kí tự đơn nào
  - Dấu ^ : khớp với phần đầu của chuỗi hoặc sử dụng để phủ định
  - Dấu $ : khớp với phần cuối của chuỗi
  - Dấu ? : tối thiểu số kí tự bằng 0 và tối đa là 1
  - Dấu + : tối thiểu số kí tự bằng 1 và tối đa là nhiều
  - Dấu * : tối thiểu số kí tự bằng 0 và tối đa là nhiều
  - {n} : có chính xác n lần xuất hiện
  - {n , } : có chính xác n hoặc nhiều hơn lần xuất hiện
  - {n , m} : có ít nhất n hoặc nhiều nhất m lần xuất hiện
  - (...) : khớp với các kí tự trong ()
  - [...] : khớp với bất kì kí tự nào trong []
  - [^...] : khớp với bất kì kí tự nào không trong []
  - [m-n] : khớp với từ kí tự m đến n trong bảng ASCII
  - \d : khớp với ký tự là chữ số, viết tắt của [0-9]
  - \D : khớp với ký tự không phải là chữ số, viết tắt của [^0-9]
  - \s : khớp với bất kỳ ký tự trống nào (dấu cách, tab, xuống dòng), viết tắt của [\t\n\x0B\f\r]
  - \S : khớp với bất kỳ ký tự không phải ký tự trống, viết tắt của [^\s]
  - \w : khớp bất kỳ ký tự chữ nào (chữ cái và chữ số), viết tắt của [a-zA-Z0-9]
  - \W : khớp bất kỳ ký tự nào không phải chữ cái và chữ số, viết tắt của [^\w] ...

- Ví dụ:
```java
    String regexPhoneNumber = "^0\\d{9}$"; // bắt đầu là 0 theo sau là 9 kí tự là số từ 0-9
    String regexMail = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Z|a-z]{2,}$"; // bắt đầu là chuỗi bắt kì + @ + chuỗi bất kì + dấu . + bất kì > 2 kí tự
    String regexPassword = "^.{8,}$"; // bắt đầu là bất kì kí tự nào và có ít nhất 8 kí tự
    String regexUsername = "^[a-z]{4,}$"; // tất cẩ là kí tự từ a-z và có ít nhất 4 kí tự

    String phoneNumber = "0355396153";

    Pattern pattern = Pattern.compile(regexPhoneNumber);
    Matcher matcher = pattern.matcher(phoneNumber);

    // (matcher.find())
    if(matcher.matches()) {
        System.out.println("SDT hop le");
    } else {
        System.out.println("SDT khong hop le");
    }


    // Dùng regex xóa khoảng trắng thừa
    String input = "   Hello     moi      nguoi   ";
    String result = input.replaceAll("\\s+", " ").trim();

    System.out.println(input);

```