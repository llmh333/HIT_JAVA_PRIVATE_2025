# Buổi 5: Polymorphism, Abstraction

## `Polymorphism` (Tính đa hình)

- Hiểu đơn giản về tính đa hình, tức là cùng một lời gọi hàm nhưng cho ra các hành vi khác nhau tùy thuộc vào đối tượng đang thực thi
- Khi nhắc tới tính đa hình, ta nghĩ ngay đến 2 khái niệm nổi bật nhất đó là 
  - Overriding (ghi đè)
  - Overloading (nạp chồng)
### `Overriding` (Ghi đè)
- Tính đa hình được thể hiện qua `run time polymorphism`
- Ghi đè tức là ta có thể định nghĩa 1 phương thức theo nhiều các khác nhau.
- Khi ghi đè 1 phương thức, ta sử dụng từ khóa `Overide` ở trước phương thức đó.
- Ghi đè chỉ xuất hiện trong quan hệ kế thừa.
- Phương thức được ghi đè phải có phạm vi truy cập lớn hơn hoặc bằng phạm vi truy cập của phương thức gốc.
```java
public class Animal {
    public void makeSound() {
        System.out.println("make some sound");
    }
}

public class Dog extends Animal {
    
    @Override
    public void makeSound() {
        System.out.println("Gau Gau");
    }
}


public class Cat extends Animal {
    
    @Override
    public void makeSound() {
        System.out.println("Meo Meo");
    }
}

public class Main {
    public static void main(String[] args) {
        model.Dog dog = new model.Dog();
        model.Cat cat = new model.Cat();
        
        // In ra "Gau gau"
        dog.makeSound();
        
        // In ra "Meo Meo" 
        cat.makeSound();
    }
}
```

### `Overloading` (nạp chồng)
- Tính đa hình được thể hiện qua `compile time polymorphism`
- Nạp chồng tức là có thể có nhiều phương thức cùng tên nhưng khác nhau về tham số và kiểu trả về.
```java
public class Main {
    
    public int sum(int a, int b) {
        return a + b;
    }
    
    public double sum(double a, double b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        int x1 = 5, y2 = 10;
        double x2 = 5.5, y2 = 1.2;

        System.out.println(sum(x1, x2));
        System.out.println(sum(x2, y2));
    }
}
```
- Khi compile code, java sẽ tự quyết định phương thức được gọi dựa trên các tham số truyền vào.

--- 
## `Abstraction` (Tính trừu tượng)
- Khi nhắc đến tính trừu tượng trong lập trình, khá khó hiểu về khái niệm trừu tượng là gì, vậy nên ta chỉ hiểu đơn giản là tính trừu tượng tập trung vào đối tượng có những hành vi nào thay vì hành vi đó được thực hiện như thế nào.
- Nói cách khác, chúng ta chỉ mô tả các hành vi mà đối tượng đó có mà không cần biết nó được thực hiện như thế nào
- Ví dụ ta định nghĩa một đối tượng `Car` có các hành vi như đi, bấm còi,... nhưng ta không cần biết là hành vi đi, bấm còi được thực hiện ra sao, logic như nào. Việc thực hiện logic hành vi đó sẽ để cho lớp con triển khai chi tiết.
- Trong Java, có 2 cách triển khai tính trừu tượng này đó là thông qua:
  - `Abstract class`
  - `Interface`
### `Abstract class` (Lớp trừu tượng)
- Abstract class sẽ như 1 class bình thường, cũng sẽ có các attribute (thuộc tính) và method (phương thức).
- Đặc biệt hơn, abstract class sẽ có thêm abstract method (phương thức trừu tượng). Phương thức trừu tượng tức là phương thức đó không có phần body.
```java
public abstract class Animal {
    private String name;
    private String age;
    
    abstract public void makeSound();
    
    public void setName(String name) {
        this.name = name;
    }
}
```

### `Interface` 
- Interface khá giống với abstract class nhưng interface không phải là một class.
- Trong interface ta chỉ khai báo những phương thức, thuộc tính trống không có thực thi.
- Trong interface chỉ chứa các hằng số.
```java
public interface Service {
    public void makeSound();
    public void eat();
}

public class People implements Service {
    @Override
    public void makeSound() {
        System.out.println("talk something");
    }
    
    @Override
    public void eat() {
        System.out.println("eat by mouth");
    }
}
```

#### Vậy cùng là thực hiện trừu tượng hóa, khi nào ta dùng `abstract class` và `interface`.
- Ta sử dụng `abstract class` khi muốn định nghĩa một loại đối tượng có chung thuộc tính, phương thức, yêu cầu dev khi tạo một đối tượng mới bắt buộc phải định nghĩa các thuộc tính, phương thức đó.
```java
abstract class Animal {
    String name;
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    public abstract void eat();
}
```

- Sử dụng `interface` khi chỉ muốn đinh nghĩa hành vi mà các đối tượng phải thực hiện, muốn có đa kế thừa.
```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() { System.out.println("Duck flies"); }
    public void swim() { System.out.println("Duck swims"); }
}
```

### Upcasting, downcasting
- Đây cũng là một dạng ép kiểu nhưng được thực hiện với đối tượng
- Upcasting là ép kiểu từ lớp con lên lớp cha.
```java
public class Animal {
    abstract public void makeSound();
}

public class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Gau Gau");
    }
}

public class Main {
    public static void main(String[] args) {
        model.Animal dog = new model.Dog();
    }
}
```

- Downcasting là ép kiểu từ lớp cha xuống lớp con.
- Sử dụng từ khóa `instaceof` để nhận biết kiểu dữ liệu của đối tượng đó.

```java
import java.util.ArrayList;

public class Animal {
    abstract public void makeSound();
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Gau Gau");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        model.Dog dog = new model.Dog();
        model.Cat cat = new model.Cat();
        model.Animal a = (model.Animal) dog;
        model.Animal b = (model.Animal) cat;
        List<model.Animal> animals = new ArrayList<>();
        animals.add(a);
        animals.add(b);
        
        for(model.Animal animal : animals) {
            if (animal instanceof model.Dog) {
                animal.makeSound();
            }
        }
    }
}
```
---
## Bài tập thực hành
### Triển khai sơ đồ đối tượng sau:
![](https://uml.planttext.com/plantuml/png/jLHBRiCW5Dnp2fQfAkS2gQAahIf5wiudU3Ol5YeV2x2hgEtTQnlZYfhq8oTia6OUZu4Ps5a7nZLIa5A0jNIlk0H1tmZjHaPhensM3XdDdU6geWeaRiwHK0Kk6wPRMZU5u2LjDMTKmWlckb5iTRD9q0WkJKZTOizy4CALGtE44cd-ogM4Gk0ejT1Q82XgEtnM_2HEYTAZECqg3_xyEPgMbs719EUPMtVdAxOKXjbEGbOfzlk1KZMZkZ-j3zeP2dGuYlsNWXyxx1NxHKrtNJueZxeAAGbcdtDvRc_aguSI1lgD7i1TQAEfvJqtxAhYO_GhQ7xxE6G7MVltjZHcoqAsD68N31WPFw7r-dqRtcw4JUq8wMEOPHtcUKBwk4J0O7Q49Ev_Q1lZXEnGiVvd_0G0)
- Yêu cầu:
  - Triển khai theo package:
    - model: `Dog`, `Cat`, `Bird`, `Animal`
    - constant: (tự các bạn định nghĩa)
    - service: `Swimmable`, `Flyable`, `IAnimalService`
    - service.impl: `IAnimalServiceImpl`
  - Khởi tạo 1 danh sách gồm 5 đối tượng animal:
    - Kiểm tra và in ra các con vật có thể bơi.
    - Kiểm tra và in ra các con vật có thể bay.
    - Thực hiện xóa những con vật có thể bay.
    - Thực hiện xóa những con vật vừa có thể bay vừa có thể bơi.
  - Viết menu lựa chọn như sau:
    - ```shell
        --- Menu ---
      1. Các con vật có thể bơi
      2. Các con vật có thể bay
      3. Xóa con vật có thể bơi
      4. Xóa con vật vừa có thể bơi vừa có thể bay
```