//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static double add(int a, double b) {
        return a + b;
    }

    public static double add(double a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        Dog shiba = new Dog("shiba", "yellow", 15);
        Dog dogMoon = new Dog("moon", "black", 20);

        System.out.println(shiba.toString());
        System.out.println(dogMoon.toString());
    }
}