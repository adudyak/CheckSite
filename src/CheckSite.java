import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;

public class CheckSite implements Runnable {
    private static int thread = 0;
    int threadCount = thread++;
    URL myURL = new URL("http://google.com");
    int attemptsAmount = 3;
    int intervalBetweenAttempts = 1000; //ms

    public void run() {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) myURL.openConnection();
            connection.setRequestMethod("HEAD");
            for (int i = 0; ; i++) {
                System.out.println("Attempt-" + i + " " + Thread.currentThread().getName() + " "+  LocalDateTime.now() + " Response code " + connection.getResponseCode());
                if (i == attemptsAmount) break;
                Thread.sleep(intervalBetweenAttempts);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public CheckSite() throws IOException {
    }
}
