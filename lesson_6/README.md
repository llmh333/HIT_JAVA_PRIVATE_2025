# Buổi 6: Collection, Lambda, Stream
--- 
## Collection
- Để xử lí một tập hợp các đối tượng trong Java, chúng ta có Java Collection API. 
- Java Collection API cung cấp những class và interface giúp chúng ta làm việc dễ dàng hơn với tập hợp các đối tượng
- Về cơ bản, chúng ta nhóm các collection lại theo chức năng thì sẽ có 3 nhóm cần chú ý, trong mỗi nhóm sẽ có nhiều các collection khác:
   - List: ArrayList, LinkedList, Vector, Stack
   - Set: SortedSet, NavigableSet,...
   - Queue: Dequeue,...
- Chúng ta sẽ tìm hiểu chủ yếu về `List`, `ArrayList`, `Set`
- Mọi người có thể tìm hiểu thêm ở trang tài liệu sau [jenkov.com](https://jenkov.com/tutorials/java-collections/collection.html) (anh rất recommend)
### `List`
- List biểu diễn một danh sách đối tượng được sắp xếp theo thứ tự. Tức là chúng ta có thể truy cập vào các phần tử thông qua chỉ số (index) theo thứ tự xuất hiện của chúng trong danh sách.
- `ArrayList` là một triển khai từ interface list, sử dụng như 1 mảng động trong Java để lưu trữ phần tử, hỗ trợ nhiều phương thức để thao tác với mảng
- Khai báo một ArrayList:
```java
public static void main(String[] args) {
   ArrayList<Integer> array1 = new ArrayList<Integer>();

   ArrayList<VD.Person> array2 = new ArrayList<VD.Person();
}
```
- Lưu ý:
   - Kiểu dữ liệu truyền vào phải là 1 lớp hoặc 1 wrapper class: Integer, String, Double, ...
   - ArrayList là 1 class nên nó sẽ có những phương thức riêng để thao tác với mảng được tạo ra

- Các phương thức quan trọng của ArrayList:
   - add, addAll
   - contains
   - retainAll, removeAll
   - indexOf, lastIndexOf
   - size, get, set

```java
public static void main(String[] args) {
   ArrayList<Integer> array1 = new ArrayList<Integer>();

   // Thêm phần tử vào dãy: add và addAll
   array1.add(1);
   array1.add(2);
   array1.add(3);
   array1.add(5);
   // array1: 1, 2, 3, 5

   array1.add(1, 4); // add theo chỉ số (index)
   // array1: 1, 4, 2, 3, 5

   ArrayList<Integer> array2 = new ArrayList<Integer>();
   array2.add(5);
   array2.add(6);
   // array2: 5, 6

   array1.addAll(array2); // add ArrayList vào ArrayList khác
   // array1: 1, 4, 2, 3, 5, 5, 6

   // Kiểm tra phẩn tử có trong dãy hay không (true hoặc false): contains
   boolean checkNumber = array1.contains(5); // => true

   // Phương thức array1.retainAll(array2): xóa những phần tử không thuộc
   // array2 khỏi array1
   // array1: 1, 4, 2, 3, 5, 5, 6
   // array2: 5, 6
   array1.retainAll(array2);
   // array1: 5, 5, 6
   // array2: 5, 6

   // Phương thức array1.removeAll(array2): ngược lại, xóa những phần tử thuộc array2 khỏi array1
   array1.removeAll(array2);
   // array1: (NOTHING)
   // array2: 5, 6

   // Phương thức lấy vị trí của phần tử dãy
   ArrayList<Integer> array3 = new ArrayList<Integer>();
   array3.add(1);
   array3.add(2);
   array3.add(3);
   array3.add(1);
   array3.add(4);

   int idx1 = array3.indexOf(1);
   int idx2 = array3.lastIndexOf(1);
   int idx3 = array3.indexOf(5);

   // Các phương thức thông dụng khác để truy xuất đến phần tử trong dãy
   for(int i = 0 ; i < array3.size() ; i++){
      array3.set(i, 100);
      System.out.print(array3.get(i) + " ");
   }
}
```
### `Set`
- Ngược lại với `List`, `Set` chỉ cho phép mỗi đối tượng xuất hiện một lần trong danh sách và ta không thể truy cập theo phần tử.

```java
public static void main(String[] args) {
   Set<String> set = new HashSet<>();
   set.add("one");
   set.add("two");
   set.add("three");
   set.add("one");

   for(String s : set){
      System.out.println(s);
   }

   // Kết quả in ra: one two three
}
```

## Lambda expressions
- Lambda expressions là một hàm ẩn danh, có đầy đủ các tính chất của một hàm như tham số truyền vào (parameters), nội dung thực thi (body)
```text
public static void main(String[] args) {
   List<Integer> list = new List<>();
   list.add(1);
   list.add(2);
   list.add(3);
    
   // Đây là một biểu thức lambda
   list.forEach(n -> System.out.println(n));

}
```

## Stream
- Streams là cách thức mới để xử lý tập hợp dữ liệu - Collections data bên cạnh các cách thức thông thường là vòng lặp - for, bộ lặp - iterator.

- Với Stream, ta có thể xử lí dữ liệu của collection một cách dễ dàng hơn
- Stream xử lí các phần tử của tập hơn theo 2 bước:
   - Cấu hình (configuration): filter, map
   - Xử lí (processing): collection,...

```java
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");

        List<String> filterList = list.stream().filter(element -> element.equals("a")).collect(Collectors.toList());
        List<String> mapList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
    }
}
```
