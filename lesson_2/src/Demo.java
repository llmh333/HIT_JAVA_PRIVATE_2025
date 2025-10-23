import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    static List<DongVat> dongVats = new ArrayList<>();

    public static void test(){
        dongVats.add(new DongVat("Cho", "30.0 kg"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = "Khuong";
        String b = "Khuong";

        if (a.equals(b)){
            System.out.println("Duplicate name");
        } else {
            System.out.println("Valid name");
        }

    }
}
