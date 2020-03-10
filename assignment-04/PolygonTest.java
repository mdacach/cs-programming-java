public class PolygonTest {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 619);
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 619);

        double x[] = { 243.0527, 245.0755, 247.4356, 247.7727, 245.5813 };
        double y[] = { 76.8410, 80.5496, 80.8867, 80.0439, 76.8410 };

        StdDraw.polygon(x, y);

    }
}