import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger counter3 = new AtomicInteger(0);
    public static AtomicInteger counter4 = new AtomicInteger(0);
    public static AtomicInteger counter5 = new AtomicInteger(0);

    public static void main(String[] args) {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new CheckerRunner(CheckType.PALINDROME, texts));
        executorService.execute(new CheckerRunner(CheckType.SORTED, texts));
        executorService.execute(new CheckerRunner(CheckType.SAMECHARS, texts));
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
         e.printStackTrace();
         System.exit(1);
        }
        System.out.println("Красивых слов с длиной 3: " + counter3.toString() + " шт.");
        System.out.println("Красивых слов с длиной 4: " + counter4.toString() + " шт.");
        System.out.println("Красивых слов с длиной 5: " + counter5.toString() + " шт.");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}
