//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int a = 5;

    public void test() {
        System.out.println(a);
    }

    public static void main(String[] args) {

        DongVat[] animals = new DongVat[2];
        DongVat cho = new DongVat("Cho", "12 Kg");
        DongVat meo = new DongVat("Meo", "1 Kg");

        animals[0] = cho;
        animals[1] = meo;
        System.out.println(animals[0].getName());
    }
}