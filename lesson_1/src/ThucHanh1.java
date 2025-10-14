import java.util.Scanner;

public class ThucHanh1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số thứ nhất: ");
        int numberOne = sc.nextInt();

        System.out.print("Số thứ hai: ");
        int numberTwo = sc.nextInt();

        System.out.println("Tổng hai số: " + (numberOne + numberTwo));
        System.out.println("Hiệu hai số: " + (numberOne - numberTwo));
        System.out.println("Thương hai số: " + (numberOne / numberTwo));
        System.out.println("Tích hai số: "  + (numberOne * numberTwo));
        System.out.println("Chia lấy dư: " + (numberOne % numberTwo));
    }
}
