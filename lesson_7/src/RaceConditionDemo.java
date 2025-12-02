public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for(int i=0; i<1000; i++) counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<1000; i++) counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Kỳ vọng: 2000. Thực tế: Thường < 2000 (ví dụ 1950, 1800...)
        System.out.println("Count: " + counter.count);
    }

}
