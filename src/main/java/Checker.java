import java.util.Arrays;

public final class Checker {
    public static boolean isPalindrome(String text) {
        StringBuilder sb = new StringBuilder();
        return sb.append(text).reverse().toString().equals(text);
    }

    public static boolean isSorted(String text) {
        char charArray[] = text.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        return sortedString.equals(text);
    }

    public static boolean isSameChars(String text) {
        return isPalindrome(text) && isSorted(text);
    }
}
