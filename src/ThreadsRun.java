import java.io.IOException;

public class ThreadsRun {
    public static void main(String[] args) throws IOException {
        Thread t0 = new Thread(new CheckSite());
        Thread t1 = new Thread(new CheckSite());
        Thread t2 = new Thread(new CheckSite());
        t0.setPriority(2);
        t1.setPriority(8);
        t2.setPriority(10);
        t0.start();
        t1.start();
        t2.start();
    }
}