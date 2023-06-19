public final class Counter {
    public static void count(int length) {
        switch (length) {
            case 3 -> Main.counter3.addAndGet(1);
            case 4 -> Main.counter4.addAndGet(1);
            case 5 -> Main.counter5.addAndGet(1);
            default -> throw new IllegalArgumentException("Invalid text length");
        }
    }
}
