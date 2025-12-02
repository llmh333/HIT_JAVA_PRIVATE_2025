public class InvalidCalculateException extends RuntimeException {
    public InvalidCalculateException(String message) {
        super(message);
        System.out.println(message);
    }
}
