public class ActivationFunction {

    public static double heaviside(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        if (x < 0)
            return 0.0;
        else if (x == 0)
            return 0.5;
        else
            return 1.0;
    }

    public static double sigmoid(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        return 1 / (Math.exp(-x) + 1);

    }

    public static double tanh(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        if (x >= 20.0)
            return 1.0;
        if (x <= -20)
            return -1.0;

        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    public static double softsign(double x) {
        if (Double.isNaN(x))
            return Double.NaN;

        if (x == Double.POSITIVE_INFINITY)
            return 1.0;
        if (x == Double.NEGATIVE_INFINITY)
            return -1.0;

        return (x / (1 + Math.abs(x)));
    }

    public static double sqnl(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        if (x <= -2)
            return -1.0;
        if (x < 0)
            return (x + (x * x / 4));
        if (x < 2)
            return (x - (x * x / 4));
        else
            return 1.0;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("tanh(" + x + ") = " + tanh(x));
        StdOut.println("softsign(" + x + ") = " + softsign(x));
        StdOut.println("sqnl(" + x + ") = " + sqnl(x));
    }

}