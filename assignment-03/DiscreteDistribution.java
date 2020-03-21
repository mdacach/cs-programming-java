public class DiscreteDistribution {
    public static void main(String[] args) {
        // args is the string array of arguments from command-line
        int m = Integer.parseInt(args[0]);
        int size = args.length;
        int[] a = new int[size];
        int[] sums = new int[size + 1];

        for (int i = 1; i < size; i++) {
            a[i] = Integer.parseInt(args[i]);
        }

        for (int i = 1; i <= size; i++) {
            sums[i] = 0;

            for (int j = 1; j <= i - 1; j++) {
                sums[i] += a[j];
            }
        }

        for (int i = 1; i <= m; i++) {

            int rn = (int) (Math.random() * (sums[size]));
            int ind = 0;
            while (sums[ind] <= rn) {
                ind++;
            }
            System.out.print((ind - 1) + " ");
        }

    }
}