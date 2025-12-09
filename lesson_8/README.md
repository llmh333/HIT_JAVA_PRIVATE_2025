# Cơ bản về JDBC

## Khái niệm
- `JDBC` là viết tắt của `Java Database Connectivity`
- JDBC là API chuẩn của Java dùng để kết nối và thao tác với Database.
- JDBC thiết kế, quy định ra các Interface và các hãng hệ quản trị cơ sở dữ liệu sẽ tự viết các thư viện triển khai các Interface đó
- Vì vậy khi cần thay đổi Hệ quản trị cơ sở dữ liệu, ta chỉ cần thay đổi thư viện và thay đổi `url` của database, không cần viết lại code.

## Thiết kế kiến trúc
- Kiến trúc `JDBC` gồm 2 phần chính:

**`JDBC API:**`
- Bộ công cụ để thao tác với cơ sở dữ liệu
- Cung cấp các Interface như: `Statement`, `PreparedStatement`,...
  **`JDBC Driver`**:
- Là các file `.jar` (ví dụ: `mysql-connector-java.jar`, `ojdbc.jar`,...)
- Chứa các `class` cụ thể implements các interface ở trên.

## Quy trình triển khai
- Bước 1: Load Driver: Nạp Driver của DB vào bộ nhớ
- Bước 2: Open connection: Mở kết nối tới DB
- Bước 3: Create Statement: Tạo đối tượng để chờ câu lệnh SQL
- Bước 4: Execute Query: Gửi câu lệnh SQL và nhận kết quả
- Bước 5: Close resources: Đóng kết nối, trả lại tài nguyên.

```java
// 1. Thông tin kết nối
String url = "jdbc:mysql://localhost:3306/demo_db";
String user = "root";
String password = "123";

Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;

try {
    // 2. Mở kết nối (Lấy implementation từ Driver)
    conn = DriverManager.getConnection(url, user, password);

    // 3. Tạo câu lệnh (Dùng PreparedStatement để tránh SQL Injection)
    String sql = "SELECT * FROM users WHERE id = ?";
    stmt = conn.prepareStatement(sql);
    stmt.setInt(1, 10); // Truyền tham số

    // 4. Thực thi và hứng kết quả
    rs = stmt.executeQuery();

    while (rs.next()) {
        System.out.println("Tên user: " + rs.getString("name"));
    }

} catch (SQLException e) {
    e.printStackTrace();
} finally {
    // 5. Đóng kết nối (Bắt buộc làm trong finally)
    try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) { e.printStackTrace(); }
}
```

## Cách viết query tới DB

- Có rất nhiều cách viết query tới DB, chúng ta sẽ đề cập đến 2 cách phổ biến nhất đó là sử dụng `Statment` và `PrepareStatment`

### `Statment`

- Dùng để thực thi câu lệnh SQL gửi tới Database
- Mỗi lần chạy Database sẽ xử lí câu lệnh từ đầu -> (static SQL)

Cách sử dụng:

```java
import java.sql.ResultSet;

public class UserDAO {
    private final Connection connection = getConnection();

    public List<User> findAll() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executorQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getClob("name");
                double age = resultSet.getDouble("age");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
        }
    }
}
```

- `ResultSet` là một `interface` chứa các phương thức để thao tác với dữ liệu trả về từ câu lệnh truy vấn, được triển khai bởi các thư viện đặc thù của từng Hệ quản trị cơ sở dữ liệu.
- Hàm `.next()` để kiểm tra phần tử tiếp theo của danh sách kết quả trả về có tồn tại không, nếu có con trỏ sẽ nhảy đến phần tử đó.

Nhược điểm:
- Sử dụng `Statement` kém hiệu suất, đặc biệt dễ bị dính lỗ hổng bảo mật là `SQL Injection`

### `PrepareStatement`

- Cũng dùng để thực thi câu lệnh SQL gửi tới Database
- Khi chạy lần đầu, Database ghi nhớ và cache câu lệnh này lại, các lần thực hiện tiếp theo chỉ thay tham số -> hiệu suất cao

Cách sử dụng

```java
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    private final Connection connection = getConnection();

    public List<User> findAll(int age) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM users WHERE age > ?";
            preparedStatement = connection.prepareStatement(sql);
            statement.setInt(1, age);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getClob("name");
                double age = resultSet.getDouble("age");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }
    }
}
```

- Ta sẽ không viết câu lệnh tĩnh nữa, mà sẽ để `?` ở những nơi cần truyền giá trị, sau đó set giá trị thông qua lệnh
- Việc thực hiện như này sẽ loại bỏ được lỗ hổng bảo mật `SQL Injection`.
- Tăng hiệu suất cho chương trình.