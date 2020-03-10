public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdOut.print("width: " + width + "   height: " + height + "\n");

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            StdOut.println("name: " + name);

            int vertices = StdIn.readInt();
            StdOut.println("vertices: " + vertices);

            double x[] = new double[vertices];
            double y[] = new double[vertices];

            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                StdOut.println(x[i] + "  ");
                y[i] = StdIn.readDouble();
                StdOut.println(y[i] + "  ");

            }
            StdDraw.polygon(x, y);

        }
    }
}