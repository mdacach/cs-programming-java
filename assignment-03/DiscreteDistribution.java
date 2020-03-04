public class DiscreteDistribution {
    public static void main(String[] args) {
        // args is the string array of arguments from command-line
        int m = Integer.parseInt(args[0]);
        int size = args.length - 1;
        int[] a = new int[size];
        int[] sums = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
        }

        for (int i = 0; i < size; i++) {
            sums[i] = 0;
            for (int j = 0; j <= i; j++) {
                sums[i] += a[j];
            }

        }

        for (int i = 0; i < m; i++) {
            int rn = (int) (Math.random() * sums[size - 1]);

            int ind = 0;
            while (rn > sums[ind]) {
                ind++;
            }
            System.out.print((ind + 1) + "  ");
        }

    }
}