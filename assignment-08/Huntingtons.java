public class Huntingtons {

    // Returns the maximum number os consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        boolean previousWasCAG = false;
        int curCount = 0;
        int maxCount = 0;
        for (int start = 0; start <= 2; start++) {
            curCount = 0;
            for (int i = start; i <= dna.length() - 3; i += 3) {
                if (dna.substring(i, i + 3).equals("CAG")) {
                    if (previousWasCAG)
                        curCount++;
                    else {
                        previousWasCAG = true;
                        curCount = 1;
                    }
                } else {
                    curCount = 0;
                }
                maxCount = Math.max(curCount, maxCount);
            }
        }

        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines)
    // removed.
    public static String removeWhitespace(String s) {
        String newString = s;

        newString = newString.replace(" ", "");
        newString = newString.replace("\n", "");
        newString = newString.replace("\t", "");

        return newString;
    }

    // Returns one of these diagnoses corresponding to the maximum number of
    // repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats >= 181)
            return "not human";
        if (maxRepeats <= 35)
            return "normal";
        if (maxRepeats <= 39)
            return "high risk";
        else
            return "Huntington's";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String filename = args[0];
        In reader = new In(filename);
        String dna = reader.readAll();

        String dnaNoWhitespace = removeWhitespace(dna);
        int maxRepeats = maxRepeats(dnaNoWhitespace);
        String diagnose = diagnose(maxRepeats);

        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose);
    }
}