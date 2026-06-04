class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long val = mid * mid;

            if (val <= x) {
                ans = (int) mid;  // store current valid answer
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }

        return ans;
    }
}