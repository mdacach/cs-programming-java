public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int diag = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Math.abs(j - diag) <= width)
                    System.out.print('*');
                else
                    System.out.print('0');
                System.out.print("  ");
            }
            System.out.println();
            diag++;
        }

    }
}