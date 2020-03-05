public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] grid = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = "O";
            }
        }

        int[][] count = new int[m + 2][n + 2];
        int countMines = 0;

        while (countMines < k) {

            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);
            if (!grid[x][y].equals("*")) {
                grid[x][y] = "*";
                for (int i = x; i <= x + 2; i++) {
                    for (int j = y; j <= y + 2; j++) {
                        count[i][j]++;
                    }
                }
                countMines++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j].equals("*"))
                    System.out.print(count[i + 1][j + 1] + "  ");
                else
                    System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}