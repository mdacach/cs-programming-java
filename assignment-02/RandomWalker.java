public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;

        System.out.println("(" + x + ", " + y + ")");

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
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}