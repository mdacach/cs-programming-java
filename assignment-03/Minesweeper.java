public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] grid = new String[m][n];
        int[][] count = new int[m][n];
        int countMines = 0;

        while (countMines < k) {

            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);

            if (grid[x][y].equals("*"))
                continue;
            else {
                grid[x][y] = "*";
                boolean left = (x - 1 >= 0);
                boolean right = (x + 1 < m);
                boolean up = (y - 1 >= 0);
                boolean down = (y + 1 > n);
                boolean leftUpDiag = (left && up);
                boolean leftDownDiag = (left && down);
                boolean rightUpDiag = (right && up);
                boolean rightDownDiag = (right && down);

                if (left)
                    count[x - 1][y]++;
                if (right)
                    count[x + 1][y]++;
                if (up)
                    count[x][y - 1]++;
                if (down)
                    count[x][y - 1]++;
                if (leftUpDiag)
                    count[x - 1][y - 1]++;
                if (leftDownDiag)
                    count[x - 1][y + 1]++;
                if (rightUpDiag)
                    count[x + 1][y - 1]++;
                if (rightDownDiag)
                    count[x + 1][y + 1]++;

                countMines++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j].equals("*"))
                    System.out.print(count[i][j] + "  ");
                else
                    System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}