public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] nums = new int[m + 1];
        double[] proportions = new double[m + 1];

        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            nums[x]++;
        }

        // get the total number of inputs
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += nums[i];
        }

        double H = 0.0; // H is the entropy
        for (int i = 1; i <= m; i++) {
            proportions[i] = (double) nums[i] / sum;
            double p = proportions[i];
            if (proportions[i] != 0) {
                H -= p * (Math.log(p) / Math.log(2));
            }
        }

        StdOut.println(H);

    }
}