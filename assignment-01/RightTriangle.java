public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        boolean allPositive = ((a > 0) && (b > 0) && (c > 0));

        boolean aHyp = (b * b + c * c == a * a);
        boolean bHyp = (a * a + c * c == b * b);
        boolean cHyp = (b * b + a * a == c * c);

        System.out.println(((aHyp) || (bHyp) || (cHyp)) && allPositive);
    }
}