public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        // Handling illegal cases
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");

        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + this.hue + ", " + this.saturation + ", " + this.brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (this.saturation == 0 || this.brightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        // Handling null argument
        if (that == null)
            throw new IllegalArgumentException("no color to compare");
        int absValueHue = Math.abs(this.hue - that.hue);
        int distHue = Math.min(absValueHue * absValueHue, (360 - absValueHue) * (360 - absValueHue));
        int distSat = (this.saturation - that.saturation) * (this.saturation - that.saturation);
        int distBright = (this.brightness - that.brightness) * (this.brightness - that.brightness);
        // Distance is all distances added.
        int distanceSquared = distHue + distSat + distBright;
        return distanceSquared;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB ourColor = new ColorHSB(h, s, b);

        int minDistance = Integer.MAX_VALUE;
        String bestColorName = "";
        ColorHSB bestColor = null;

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int hue = StdIn.readInt();
            int saturation = StdIn.readInt();
            int brightness = StdIn.readInt();
            ColorHSB thatColor = new ColorHSB(hue, saturation, brightness);
            int distance = ourColor.distanceSquaredTo(thatColor);

            if (distance < minDistance) {
                minDistance = distance;
                bestColorName = colorName;
                bestColor = thatColor;
            }

        }

        StdOut.println(bestColorName + " " + bestColor);
    }

}