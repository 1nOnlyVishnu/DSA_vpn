class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int[] endZeroes = new int[n];

        for (int i = 0; i < n; i += 1){
            int j = n - 1;

            int count = 0;

            while( j > 0 && grid[i][j] == 0){
                count += 1;
                j--;
            }

            endZeroes[i] = count;
        }

        int steps = 0;

                for (int i = 0; i < n; i++) {

            int need = n - i - 1;

            int j = i;

            while (j < n && endZeroes[j] < need) {
                j++;
            }

            if (j == n) {
                return -1;
            }

            steps += (j - i);

            while (j > i) {
                int temp = endZeroes[j];
                endZeroes[j] = endZeroes[j - 1];
                endZeroes[j - 1] = temp;
                j--;
            }
        }

        return steps;

    }
}