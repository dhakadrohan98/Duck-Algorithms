import java.util.LinkedList;
import java.util.Queue;

public class Test {

    /*
    A grid contains:

    0 = empty cell
    1 = fresh orange
    2 = rotten orange

    Every minute, a rotten orange makes its adjacent fresh oranges rotten. Return the minimum number of minutes required to rot all oranges.
    Input:
    [
      [2, 1, 1],
      [1, 1, 0],
      [0, 1, 1]
    ]

    Output:
    4
    */

    public int rotingOranges(
            int[][] grid) {

        int rows = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue =
        new LinkedList<>();

        int freshOranges = 0;

        for(int r=0; r < rows; r++) {
            for(int c = 0; c < col; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(
                            new int[]{r, c});

                } else if(grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0) {
            return 0;
        }
        int minutes = 0;
        int[][] directions = {{1,0}, {-1, 0},
        {0, 1}, {0, -1}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;

            for(int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];

                for(int[] dir: directions) {
                    int newRow = dir[0];
                    int newCol = dir[1];

                    if(newRow >= 0
                    && newRow < rows
                    && newCol >= 0 &&
                    newCol < col &&
                    grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                    }
                    freshOranges--;

                    queue.offer(new int[]{
                            newRow, newCol});
                }

            }
        }

        return 0;
    }

    public static void main() {
    }
}
