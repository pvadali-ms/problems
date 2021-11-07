package misc;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingTest {

    ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(1000);
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    static boolean REACHED_END_OF_FILE = false;

    @Test
    public void multiThreadingTest() throws InterruptedException {
        List<Callable<String>> callables = List.of(new ReadFromFile(), new WriteToFile());
        executorService.invokeAll(callables);
    }

    class ReadFromFile implements Callable<String> {
        public String call() {
            try {
                String line;
                InputStream in = new FileInputStream("src/test/java/misc/sample");
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(" ");
                    for (String value : values) {
                        System.out.println("adding value: " + value + " to queue");
                        abq.put(value);
                    }
                }
                REACHED_END_OF_FILE = true;
            } catch (IOException | InterruptedException exception) {
                System.out.println("interrupted in read");
            }
            return "success";
        }
    }

    class WriteToFile implements Callable<String> {
        public String call() {
            try {
                FileWriter writer = new FileWriter("testfile.txt", true);
                while (!REACHED_END_OF_FILE || !abq.isEmpty()) {
                    if (!abq.isEmpty()) {
                        System.out.println("writing " + abq.peek() + " to file");
                        writer.append(abq.poll()).append(" ");
                    }
                }
                writer.close();
            } catch (IOException exception) {
                System.out.println("interrupted in write");
            }
            return "success";
        }
    }
}
