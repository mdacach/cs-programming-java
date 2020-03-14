public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2);

    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 1)
            drawSquare(x, y, length);
        else {
            draw(n - 1, x + length / 2, y + length / 2, length / 2);
            draw(n - 1, x - length / 2, y + length / 2, length / 2);
            draw(n - 1, x + length / 2, y - length / 2, length / 2);
            draw(n - 1, x - length / 2, y - length / 2, length / 2);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        for (int i = 3; i >= 1; i--)
            draw(i, 0.5, 0.5, 0.5);
    }
}