public class RevesPuzzle {

    public static void reve(int n, int k, String from, String to, String spare) {
        hanoi(n, k, from, to, spare);
    }

    public static void hanoi(int n, int k, String from, String to, String spare) {
        if (n == 0)
            return;
        else {
            hanoi(n - 1, k, from, spare, to);
            StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
            hanoi(n - 1, k, spare, to, from);
        }
    }

    public static void hanoi(int n, String from, String to, String spare) {
        if (n == 0)
            return;
        else {
            hanoi(n - 1, from, spare, to);
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            hanoi(n - 1, spare, to, from);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // Poles are A B C and D
        // A - from
        // D - destination
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1) + 0.5);

        hanoi(k, "A", "B", "C"); // at the end here are all at pole B
        reve(n - k, k, "A", "D", "C");
        hanoi(k, "B", "D", "A");

    }
}