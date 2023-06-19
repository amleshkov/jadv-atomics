import java.util.Arrays;

public class CheckerRunner implements Runnable {
    private static CheckType checkType;
    private static String[] texts;

    public CheckerRunner(CheckType checkType, String[] texts) {
        this.checkType = checkType;
        this.texts = texts;
    }

    public void run() {
        Arrays.stream(texts)
                .filter(x -> check(x))
                .forEach(x -> Counter.count(x.length()));
    }

    private static boolean check(String text) {
        switch (checkType) {
            case PALINDROME -> {return Checker.isPalindrome(text);}
            case SORTED -> {return Checker.isSorted(text);}
            case SAMECHARS -> {return Checker.isSameChars(text);}
            default -> throw new IllegalArgumentException("Invalid checker type");
        }
    }


}
