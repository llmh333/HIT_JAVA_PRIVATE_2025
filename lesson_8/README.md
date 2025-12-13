# Cơ bản về JDBC

## Tổng quan: JDBC là gì và tại sao cần nó?
- `JDBC` là viết tắt của `Java Database Connectivity`
- JDBC là một API tiêu chuẩn của Java cho phép các ứng dụng Java tương tác với các hệ quản trị cơ sở dữ liệu (DBMS) khác nhau (MySQL, PostgreSQL, Oracle, SQL Server...).
- Nó đóng vai trò như một chiếc "cầu nối" hoặc một "người phiên dịch". Java nói tiếng Java, Database nói tiếng SQL, JDBC Driver sẽ phiên dịch giữa hai bên.

## Thiết kế kiến trúc
- Kiến trúc `JDBC` gồm 2 phần chính:

**`JDBC API:**`
- Bộ công cụ để thao tác với cơ sở dữ liệu
- Cung cấp các Interface như: `Statement`, `PreparedStatement`,...
  **`JDBC Driver`**:
- Là phần mềm do nhà cung cấp Database viết.
- Chứa các `class` cụ thể implements các interface ở trên.

## Các thành phần cốt lõi
| Thành phần      | Vai trò                                    | Ví dụ đời thực                        |
| :---------------| :------------------------------------------| :------------------------------------ |
| `DriverManager` | Quản lý danh sách các Driver.              | Người điều phối xe.                   |
| `Connection`    | Đại diện cho phiên làm việc vật lý với DB. | Đường dây điện thoại đã được kết nối. |
| `Statement`     | Đối tượng để gửi câu lệnh SQL tới DB.      | Chiếc xe chở hàng (câu lệnh SQL).     |
| `ResultSet`     | Chứa dữ liệu trả về từ câu lệnh SELECT.    | Thùng hàng nhận được.                 |
| `SQLExceptione` | Lớp xử lý lỗi đặc thù của Database.        | Báo cáo sự cố.                        |

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

### Phân biệt Statement vs. PreparedStatement
1. Statement:
- Dùng cho câu lệnh SQL tĩnh, không tham số.
- Nguy hiểm: Dễ bị tấn công SQL Injection nếu nối chuỗi.
- Ví dụ xấu: String sql = "SELECT * FROM users WHERE name = '" + userName + "'";
2. PreparedStatement (Khuyên dùng):
- Dùng cho câu lệnh SQL động, có tham số (?).
- Lợi ích:  
  - Chống SQL Injection (tự động escape ký tự đặc biệt).
  - Hiệu năng cao hơn.

### `Statment`
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

- Hàm `.next()` để kiểm tra phần tử tiếp theo của danh sách kết quả trả về có tồn tại không, nếu có con trỏ sẽ nhảy đến phần tử đó.

### `PrepareStatement`

- Khi chạy lần đầu, Database ghi nhớ và cache câu lệnh này lại, các lần thực hiện tiếp theo chỉ thay tham số -> hiệu suất cao

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
                String name = resultSet.getString("name");
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

## Bài tập thực hành

### Phần 1: Thiết kế Cơ sở dữ liệu
``` SQL
CREATE DATABASE inventory_db;
USE inventory_db;

-- Bảng danh mục (Ví dụ: Điện tử, Thời trang...)
CREATE TABLE category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

-- Bảng sản phẩm, có khóa ngoại trỏ về category
CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Data mẫu
INSERT INTO category (name) VALUES ('Laptop'), ('Mobile');
```

### Phần 2: Cấu trúc Project Java
- model: Chứa các entity
- dao: Chứa code JDBC
- utils: Chứa DB Connection
- constrant: Chứa các định nghĩa, hằng số
- service: Chứa các logic nghiệp vụ
- exception (nếu có): Chứa custom exceprion
- main

<img width="744" height="812" alt="image" src="https://github.com/user-attachments/assets/bba97f9d-7ddd-4c48-8c2c-474f22ba7936" />
