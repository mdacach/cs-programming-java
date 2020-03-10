public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        String color = "gray";
        StdDraw.setScale(0, n);
        double x = 0.5;
        double y = 0.5;
        boolean isEven = (n % 2 == 0);

        for (int i = 0; i < n; i++) {
            if (isEven && i > 0) {
                if (color == "blue") {
                    color = "gray";
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                } else if (color == "gray") {
                    color = "blue";
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
            }

            for (int j = 0; j < n; j++) {
                if (color == "blue") {
                    color = "gray";
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                } else if (color == "gray") {
                    color = "blue";
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                StdDraw.filledSquare(x, y, 0.5);
                x += 1;
            }
            x = 0.5;
            y += 1;

        }
    }

}