public class RevesPuzzle {

    private static void hanoi3(int n, int disc, char from, char to, char sp) {
        if (n == 0) {
            // StdOut.println("end hanoi3");

            return;

        }

        // StdOut.println("hanoi4 with n: " + n);
        hanoi3(n - 1, disc - 1, from, sp, to);
        StdOut.println("Move disc " + disc + " from " + from + " to " + to);
        hanoi3(n - 1, disc - 1, sp, to, from);

    }

    private static void hanoi4(int n, int disc, char from, char to, char sp1, char sp2) {
        if (n == 0) {
            // StdOut.println("end hanoi4");
            return;
        }
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));

        hanoi4(k, k, from, sp1, to, sp2);
        hanoi3(n - k, n, from, to, sp2);
        hanoi4(k, k, sp1, to, from, sp2);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
        // StdOut.println("k: " + k);
        hanoi4(k, k, 'A', 'B', 'C', 'D');
        // StdOut.println("------------------------------ ");
        hanoi3(n - k, n, 'A', 'D', 'C');
        // StdOut.println("------------------------------ ");
        hanoi4(k, k, 'B', 'D', 'A', 'C');
    }
}