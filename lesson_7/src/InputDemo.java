import java.io.*;

public class InputDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("D:\\HIT_JAVA_PRIVATE_2025\\lesson_7\\src\\test.txt"));
        String a = in.readLine();
        System.out.println(a);
//        while (a != -1) {
//            System.out.println();
//            a = in.read();
//        }
//        System.out.println(a);
        in.close();
    }
}
