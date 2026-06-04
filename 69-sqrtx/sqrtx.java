class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int result = 1;

        for (long i = 1; i <= x; i++) {
            if (i * i <= x) {
                result = (int) i;
            } else {
                break;
            }
        }

        return result;
    }
}