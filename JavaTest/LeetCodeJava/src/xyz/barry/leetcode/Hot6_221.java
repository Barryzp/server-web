package xyz.barry.leetcode;
//char[][] matrix =
//        {
//                {'1'},
//        };
//                {
//                {'1','1'},
//                {'1','1'},
//        };
//                {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };
//        {{'1','0','1','0','0','0'},
//        {'1','0','1','1','1','1'},
//        {'1','1','1','1','1','1'},
//        {'1','0','0','1','1','1'}};
//        {{'1','1','1','1','1','0'},
//        {'1','1','1','1','1','0'},
//        {'1','1','1','1','1','1'},
//        {'1','1','1','1','1','1'}};


public class Hot6_221 {

    public int judgeMaxBorder(char[][] matrix, int rows, int columns){
        int rowsBorder = matrix.length;
        int columnsBorder = matrix[0].length;

        int maxLoops = Math.min(rowsBorder - rows, columnsBorder - columns);
        int areaBorder = 1;

        if (rowsBorder < 2 || columnsBorder < 2) return areaBorder;

        // 已经到达边界了
        while (true) {
            if (areaBorder >= maxLoops) break;

            int rowsVar = rows + areaBorder;
            int colsVar = columns + areaBorder;

            boolean canAutoIncrement = true;
            for (int i = 0; i < areaBorder+1; i++) {
                if ((rows + i)<rowsBorder && (columns + i)<columnsBorder){
                    if (matrix[rows+i][colsVar] == '1'
                            && matrix[rowsVar][columns+i] == '1') continue;
                    else canAutoIncrement = false;
                }else {
                    canAutoIncrement = false;
                }
            }
            if (canAutoIncrement) areaBorder++;
            else break;
        }
        return areaBorder;
    }
    public int maximalSquare(char[][] matrix) {
        int rowsBorder = matrix.length;
        int columnsBorder = matrix[0].length;
        int maxBorder = 0;

        for (int rows = 0; rows < rowsBorder; rows++) {
            if (maxBorder >= (rowsBorder - rows)) break;
            for (int columns = 0; columns < columnsBorder; columns++) {
                if (maxBorder >= (columnsBorder - columns)) break;

                if (matrix[rows][columns] == '1'){
                    int curBorder = judgeMaxBorder(matrix, rows, columns);
                    if (curBorder > maxBorder) maxBorder = curBorder;
                    System.out.println(maxBorder);
                }
            }
        }

        return maxBorder * maxBorder;
    }

    public int maximalSquare_usedp(char[][] matrix) {
        int rowsBorder = matrix.length;
        int columnsBorder = matrix[0].length;

        int maxBorder = 0;

        int[][] dp = new int[rowsBorder][columnsBorder];

        for (int i = 0; i < rowsBorder; i++) {
            for (int j = 0; j < columnsBorder; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    if (maxBorder < dp[i][j]) maxBorder = dp[i][j];
                }
            }
        }

        return maxBorder * maxBorder;
    }
}
