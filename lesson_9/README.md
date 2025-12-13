# Hibernate, ORM

## Hibernate

### Hibernate là gì?

- **Định nghĩa**: Hibernate là một framework mã nguồn mở, là một hiện thực hóa (`implementation`) mạnh mẽ nhất của chuẩn JPA (`Java Persistence API`).

- **Vai trò**: Nó là công cụ ORM giúp lập trình viên thao tác với Database hoàn toàn thông qua các đối tượng Java (POJO) mà không cần viết quá nhiều câu lệnh SQL thủ công.

### Cách Hibernate hoạt động
**Kiến trúc cơ bản**:

- `Configuration`: Đọc file cấu hình (hibernate.cfg.xml hoặc application.properties) để biết cách kết nối DB (User, Pass, Driver, Dialect).
- `SessionFactory`:
   - Được tạo ra từ Configuration.
   - Nặng (Heavyweight), chỉ nên có 1 cái trong toàn bộ ứng dụng (Singleton pattern).
   - Chứa thông tin về ánh xạ (Mapping) giữa Class và Table.
- `Session`:
   - Được tạo ra từ SessionFactory ("Factory pattern").
   - Nhẹ (Lightweight), mỗi luồng hoặc mỗi request nên dùng một Session riêng.
   - Đóng vai trò như một cầu nối trực tiếp để thực hiện save, delete, find.
- `Transaction`:
   - Nằm trong Session, chịu trách nhiệm quản lý phạm vi giao dịch (như đã giải thích ở trên).

**Vòng đời của một đối tượng trong Hibernate (Entity Lifecycle)**:
- Transient (Tạm thời): Đối tượng mới được new, chưa có ID, chưa liên kết với Session.
- Persistent (Bền vững): Đối tượng đã được lưu (save) hoặc truy vấn từ DB, đang nằm trong sự quản lý của Session. Mọi thay đổi trên object này sẽ tự động cập nhật vào DB khi transaction commit (tính năng Dirty Checking).
- Detached (Tách rời): Session đã đóng (close). Đối tượng vẫn có dữ liệu nhưng thay đổi trên nó sẽ không ảnh hưởng đến DB nữa.

### Cách cấu hình Hibernate trong Java
Bước 1: Cài đặt thư viện
```xml
<dependencies>
   <dependency>
      <groupId>org.hibernate.orm</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>6.5.2.Final</version>
   </dependency>

    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.3.0</version>
   </dependency>

   <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
   </dependency>
</dependencies>

 <build>
   <plugins>
      <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.13.0</version>
         <configuration>
            <source>17</source>
            <target>17</target>
            <annotationProcessorPaths>
               <dependency>
                  <groupId>org.projectlombok</groupId>
                  <artifactId>lombok</artifactId>
                  <version>${lombok.version}</version>
               </dependency>
            </annotationProcessorPaths>
         </configuration>
      </plugin>
   </plugins>
</build>

```
Bước 2: Cấu hình JPA (`persistence.xml`)
- Tạo file `persistence.xml` và đặt trong thư mục `META-INF`
- Đường dẫn chuẩn: `src/main/resources/META-INF/persistence.xml`
```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">

    <persistence-unit name="my-persistence-unit">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/demo_jpa"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="your_password"/>

            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>

            <property name="hibernate.hbm2ddl.auto" value="update"/>
            
            </properties>
    </persistence-unit>
</persistence>
```

Bước 3: Tạo Enity (`POJO class`)
- Sử dụng các annotation chuẩn của `jakarta`
```java
package com.example.entity;

import jakarta.persistence.*; // Nhớ import gói này, không import org.hibernate.annotations

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự tăng (Auto Increment)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String name;

    private String email;

    // Bắt buộc phải có Constructor rỗng
    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter & Setter, toString...
}
```

Bước 4: Tạo `EntityManager`
```java
public class DBConnection {
   private static EntityManagerFactory entityManagerFactory;

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("example-unit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            entityManagerFactory = buildEntityManagerFactory();
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
```
Bước 5: Sử dụng
```java
public class Main {
    public static void main(String[] args) {

        // 1. Khởi tạo EntityManagerFactory (theo tên trong persistence.xml)
        // Đây là đối tượng nặng, chỉ nên tạo 1 lần
        EntityManager entityManager = DBConnection.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try {
            // Bắt đầu giao dịch
            transaction.begin();

            // --- Thêm mới (Create) ---
            Student s1 = new Student("Nguyen Van A", "a@example.com");
            em.persist(s1);

            // --- Truy vấn (Read) ---
            Student foundStudent = em.find(Student.class, s1.getId()); // Truy vấn theo ID
            System.out.println("Tim thay: " + foundStudent.getName());

            // --- Cập nhật (Update) ---
            foundStudent.setName("Nguyen Van B");
            // Không cần gọi update(), JPA tự detect thay đổi (Dirty Checking) khi commit

            // --- Xóa (Delete) ---
            // em.remove(foundStudent);

            // Xác nhận giao dịch (lưu vào DB)
            transaction.commit();
        } catch (Exception e) {
            // Nếu lỗi thì rollback
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Luôn đóng EntityManager
            em.close();
            emf.close();
        }
    }
   
}
```

Các annotation thường xuyên sử dụng:
- `@Entity`: Đánh dấu đây là một Object sẽ được chuyển thành bảng.
- `Table`: Custom tên bảng,...
- `@Getter`, `@Setter`: Tự động sinh code Getter, Setter
## ORM
- Định nghĩa: Là kỹ thuật lập trình giúp chuyển đổi dữ liệu giữa các hệ thống cơ sở dữ liệu quan hệ (RDBMS - như MySQL, PostgreSQL) và lập trình hướng đối tượng (OOP - như Java).

- Vấn đề giải quyết:
   - Trong Java, chúng ta có Class, Object, List.
   - Trong Database, chúng ta có Table, Row, Relation.
   - ORM đóng vai trò là "người phiên dịch": Tự động biến một Object thành một dòng trong bảng (khi lưu) và ngược lại (khi truy vấn).
## Transactional
- Transactional đảm bảo tính toàn vẹn dữ liệu theo chuẩn ACID.
   - **Khái niệm**: Một Transaction là một tập hợp các hành động, được xem là một đơn vị công việc duy nhất.
   - **Nguyên tắc** `"Tất cả hoặc không gì cả" (All or Nothing)`:
      - Nếu tất cả các bước thành công $\rightarrow$ Commit (Lưu vào DB).
      - Nếu chỉ 1 bước thất bại $\rightarrow$ Rollback (Khôi phục lại trạng thái ban đầu).