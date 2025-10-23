import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int a = 5;

    public void test(){
        System.out.println("check");
    }

    private static void printArrayReverse(){
        for (int i = Mang.array.length - 1; i >= 0; i--){
            System.out.println(Mang.array[i]);
        }
    }

    public static void main(String[] args) {

        Mang.printArray();

        printArrayReverse();

//        DongVat[] animals = new DongVat[2];
//        DongVat cho = new DongVat("Cho", "12 Kg");
//        DongVat meo = new DongVat("Meo", "1 Kg");
//
//        animals[0] = cho;
//        animals[1] = meo;
//        System.out.println(animals[0].getName());
    }
}