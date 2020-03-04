public class Birthday {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] room = new int[n + 2];
        int[] count = new int[n + 2];

        for (int i = 0; i < trials; i++) {
            int index = 0;
            boolean sameBirthday = false;
            while (!sameBirthday) {
                int rn = (int) (Math.random() * n);
                room[index] = rn;

                for (int j = 0; j < index; j++) {
                    if (room[j] == rn) {
                        sameBirthday = true;
                        break;
                    }
                }
                index++;
            }
            // System.out.println(index + " people entered the room");
            count[index]++;
        }
        for (int i = 1; i <= n + 1; i++) {
            System.out.print(i + "\t" + count[i] + "\t");
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += count[j];
            }
            double fraction = ((double) sum / trials);
            System.out.print(fraction);
            System.out.println("\t");
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}