
public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int sum = 0;
        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
                double rn = Math.random();
                if (rn < 0.25) {
                    y++;
                } else if (rn < 0.50) {
                    y--;
                } else if (rn < 0.75) {
                    x++;
                } else {
                    x--;
                }
                steps++;
            }
            sum += steps;
        }

        System.out.println("average number of steps = " + ((double) sum / trials));
    }
}