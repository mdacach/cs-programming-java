
public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] amplified = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            amplified[i] = alpha * a[i];
        }

        return amplified;
    }

    public static double[] reverse(double[] a) {
        double[] reversed = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            reversed[a.length - i - 1] = a[i];
        }
        return reversed;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] merged = new double[a.length + b.length];
        for (int i = 0; i < a.length + b.length; i++) {
            if (i < a.length)
                merged[i] = a[i];
            else
                merged[i] = b[i - a.length];
        }
        return merged;
    }

    public static double[] mix(double[] a, double[] b) {
        if (a.length >= b.length) {
            double[] mixed = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                if (i >= b.length)
                    mixed[i] = a[i];
                else
                    mixed[i] = a[i] + b[i];
            }
            return mixed;
        } else {
            double[] mixed = new double[b.length];
            for (int i = 0; i < b.length; i++) {
                if (i >= a.length)
                    mixed[i] = b[i];
                else
                    mixed[i] = a[i] + b[i];
            }
            return mixed;
        }
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        int size = (int) (a.length / alpha);
        double[] changed = new double[size];
        for (int i = 0; i < size; i++) {
            int index = (int) (i * alpha);
            changed[i] = a[index];

        }
        return changed;
    }

    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] silence = StdAudio.read("silence.wav");

        double[] audio1 = mix(piano, changeSpeed(harp, 0.5));
        double[] audio2 = merge(changeSpeed(cow, 4), reverse(beatbox));
        double[] audio3 = mix(amplify(reverse(piano), 0.2), changeSpeed(silence, 0.5));

        double[] fnAudio = mix(audio1, audio2);
        fnAudio = merge(fnAudio, audio3);

        for (int i = 0; i < fnAudio.length; i++) {
            if (fnAudio[i] > 1)
                fnAudio[i] = 1;
            if (fnAudio[i] < -1)
                fnAudio[i] = -1;
        }
        StdAudio.play(fnAudio);

    }
}