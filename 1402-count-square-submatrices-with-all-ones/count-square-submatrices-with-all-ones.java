class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];  
        int total = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // First row or first column can only form 1x1 square
                        dp[i][j] = 1;
                    } else {
                        // Take minimum of three neighbors and add 1
                        dp[i][j] = 1 + Math.min(dp[i - 1][j],
                                        Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                    total += dp[i][j];
                }
            }
        }

        return total;
    }
}
