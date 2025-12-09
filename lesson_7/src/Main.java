//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        try {
            int a = 5, b = 0;
            System.out.println(a/b);
        } catch (Exception e) {

            System.out.println(e.pr);
//            throw e;// new InvalidCalculateException("Tính toán xảy ra lỗi");
        } finally {
            System.out.println("Hoàn thành việc tính toán");
        }
    }
}

