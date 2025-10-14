import java.util.Scanner;

public class ThucHanh2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tổng số giây: ");
        int second = sc.nextInt();
        while (second < 0) {
            System.out.print("Không hợp lệ, vui lòng nhập lại: ");
            second = sc.nextInt();
        }

        int hours = second / 3600;
        int minutes = (second - hours * 3600) / 60;
        int seconds = second % 60;
        System.out.println(hours + " giờ " + minutes + " phút " + seconds + " giây");
    }
}
