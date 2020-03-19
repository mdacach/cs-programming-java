public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long count = 0;
        for (long a = 1; a <= (long) Math.cbrt(n); a++) {
            long bCube = n - a * a * a;
            long b = (long) (Math.cbrt(bCube));
            boolean isInteger = (b * b * b == bCube);

            if (isInteger) {
                count++;
            }
        }
        return (count > 2); // Each way is counted two times
    }

    // Takes a long integer command-line argument and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}