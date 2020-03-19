public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int curSize = 0; // Current size to check for
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    // Check if there is space for square of size we are
                    // looking for
                    boolean iInBounds = (i + curSize < a.length);
                    boolean jInBounds = (j + curSize < a.length);

                    // Find if it's all ones
                    boolean allOnes = true;
                    boolean breakFromLoop = false;
                    while (iInBounds && jInBounds && allOnes) {
                        for (int x = i; x <= i + curSize; x++) {
                            for (int y = j; y <= j + curSize; y++) {
                                if (a[x][y] == 0) {
                                    allOnes = false;
                                    breakFromLoop = true;
                                    break;
                                }
                            }
                            if (breakFromLoop)
                                break;
                        }
                        if (allOnes)
                            curSize++; // Looking for new bigger size

                        // Check boundaries again
                        iInBounds = (i + curSize < a.length);
                        jInBounds = (j + curSize < a.length);
                    }
                }
            }
        }
        return curSize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }

}