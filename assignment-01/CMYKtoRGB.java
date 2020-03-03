public class CMYKtoRGB {
    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white;
        int red, green, blue;

        white = (1.0 - black);
        red = (int) (Math.rint(255 * white * (1.0 - cyan)));
        green = (int) (Math.rint(255 * white * (1.0 - magenta)));
        blue = (int) (Math.rint(255 * white * (1.0 - yellow)));

        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);
    }
}