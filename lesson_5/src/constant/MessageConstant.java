package constant;

public class MessageConstant {

    public static class ErrorMessage {
        public static final String INVALID_CHOICE = "invalid choice";
    }

    public static class SuccessMessage {
        public static final String NO_ANIMAL_SWIMMABLE = "No animal can swim";
        public static final String NO_FLYABLE = "No animal can fly";
        public static final String NO_ANIMAL_SWIMMABLE_FLYABLE = "No animal can both swim and fly";
    }

    public static class MenuMessage {
        public static final String MENU = "---Menu---\n1. Các con vật có thể bơi\n2. Các con vật có thể bay\n3. Xóa con vật có thể bơi\n4. Xóa con vật vừa có thể bơi vừa có thể bay";
        public static final String INPUT_CHOICE = "Enter your choice: ";
    }
}
