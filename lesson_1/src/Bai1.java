import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Họ tên: ");
        String name = sc.nextLine();

        System.out.println("Năm sinh: ");
        String dob = sc.nextLine();

        System.out.println("GPA: ");
        String gpa = sc.nextLine();

        System.out.println("Student{hoTen="+name+",dob="+dob+",gpa="+gpa+"}");
    }

}
