package xyz.barry.leetcode;

public class Hot11_200 {

    int[][] accessed;
    int numIsland = 0;

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        accessed = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && accessed[i][j] == 0){
                    numIsland++;
                    access(grid, i, j);
                }
            }
        }

        return numIsland;
    }

    // 递归遍历上下左右
    public void access(char[][] grid, int row, int col){
        // 撞见墙就返回
        if (grid[row][col] == '0' || accessed[row][col] != 0) return;
        accessed[row][col] = numIsland;

        // 上
        if (row - 1 >= 0) access(grid, row-1, col);
        // 下
        if (row + 1 < grid.length) access(grid, row+1, col);
        // 左
        if (col - 1 >= 0) access(grid, row, col-1);
        // 右
        if (col + 1 < grid[0].length) access(grid, row, col+1);
    }

}
