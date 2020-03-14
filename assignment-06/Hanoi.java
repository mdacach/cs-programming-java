public class Hanoi {
    public static void solve(int n, String from, String to, String spare) {
        if (n == 0)
            return;
        else {

            solve(n - 1, from, spare, to);
            StdOut.println("move disc " + n + " from " + from + " to " + to);
            solve(n - 1, spare, to, from);

        }
    }

    public static void main(String[] args) {
        solve(3, "A", "B", "C");

    }

}