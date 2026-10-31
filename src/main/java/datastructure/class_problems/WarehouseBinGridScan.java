import java.util.Scanner;

public class WarehouseBinGridScan {
    static int[] warehouseSummary(int[][] grid) {
        int total = 0, maxValue = -1, maxRow = 0, maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter items in bin [" + i + "][" + j + "]: ");
                grid[i][j] = sc.nextInt();
            }
        }
        int[] result = warehouseSummary(grid);
        System.out.println("total = " + result[0] + ", maxCoordinate = (" + result[1] + ", " + result[2] + ")");
        sc.close();
    }
}
