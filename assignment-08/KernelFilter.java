import java.awt.Color;

public class KernelFilter {
    private static Picture applyKernel(Picture picture, double[][] kernel) {
        Picture newPic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                double sumRed = 0;
                double sumGreen = 0;
                double sumBlue = 0;
                for (int x = i - kernel.length / 2, ind1 = 0; x <= i + kernel.length / 2; x++, ind1++) {
                    for (int y = j - kernel.length / 2, ind2 = 0; y <= j + kernel.length / 2; y++, ind2++) {

                        int col = Math.floorMod(y, picture.width());
                        int row = Math.floorMod(x, picture.height());
                        Color color = picture.get(col, row);
                        int red = color.getRed();
                        int green = color.getGreen();
                        int blue = color.getBlue();
                        double valueRed = (kernel[ind1][ind2] * (double) red);
                        sumRed += valueRed;
                        double valueGreen = (kernel[ind1][ind2] * (double) green);
                        sumGreen += valueGreen;
                        double valueBlue = (kernel[ind1][ind2] * (double) blue);
                        sumBlue += valueBlue;
                    }
                }
                sumRed = Math.round(sumRed);
                sumGreen = Math.round(sumGreen);
                sumBlue = Math.round(sumBlue);

                if (sumRed < 0)
                    sumRed = 0;
                if (sumGreen < 0)
                    sumGreen = 0;
                if (sumRed > 255)
                    sumRed = 255;
                if (sumGreen > 255)
                    sumGreen = 255;
                if (sumBlue < 0)
                    sumBlue = 0;
                if (sumBlue > 255)
                    sumBlue = 255;

                Color newColor = new Color((int) sumRed, (int) sumGreen, (int) sumBlue);
                newPic.set(j, i, newColor);
            }
        }
        return newPic;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given
    // picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = { { 1.0 / 16, 2.0 / 16, 1.0 / 16 }, { 2.0 / 16, 4.0 / 16, 2.0 / 16 },
                { 1.0 / 16, 2.0 / 16, 1.0 / 16 } };
        return applyKernel(picture, kernel);

    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
        return applyKernel(picture, kernel);

    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernel = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
        return applyKernel(picture, kernel);

    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j)
                    kernel[i][j] = 1.0 / 9;
                else
                    kernel[i][j] = 0.0;
            }
        }
        return applyKernel(picture, kernel);

    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture("testing/baboon.png");
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();

        // emboss(picture).show();
        // laplacian(picture).show();

    }
}