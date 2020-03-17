public class TrinomialDP {
    public static long trinomial(int n, int k) {
        if (Math.abs(k) > Math.abs(n))
            return 0;

        k = Math.abs(k); // handle negative k

        long[][] tri = new long[n + 1][n + 1];
        tri[0][0] = 1; // all the others are assigned 0

        for (int i = 1; i <= n; i++) {
            tri[i][i] = 1;
            for (int j = 0; j < i; j++) {
                tri[i][j] = tri[i - 1][j] + tri[i - 1][j + 1] + tri[i - 1][Math.abs(j - 1)];
            }
        }

        // print all the matrix
        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < n + 1; j++) {
        // StdOut.print(tri[i][j] + " ");
        // }
        // StdOut.println();
        // }

        return tri[n][k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));

    }
}