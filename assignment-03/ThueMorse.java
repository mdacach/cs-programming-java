public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int power = 1;
        while (n > power) {
            power *= 2;
        }

        int[] sequence = new int[power * 2];
        sequence[0] = 0;

        int size = 1;
        int ind = 1;
        while (ind < n) {
            for (int i = ind; i < ind + size; i++) {
                if (sequence[i - size] == 1) {
                    sequence[i] = 0;
                } else {
                    sequence[i] = 1;
                }

            }
            ind = ind + size;
            size *= 2;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+" + "  ");
                } else {
                    System.out.print("-" + "  ");
                }
            }
            System.out.println();
        }

    }

}