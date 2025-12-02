import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputDemo {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("D:\\HIT_JAVA_PRIVATE_2025\\lesson_7\\src\\test.txt", true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Hello world!", 0, 5);
        bw.close();
    }
}
