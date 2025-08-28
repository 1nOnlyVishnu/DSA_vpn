class Solution {
    public boolean isPalindrome(int x) {
        int origNum = x;
        int revNum = 0;
        while (x > 0) {
            int lastDig = x % 10;
            revNum = (revNum * 10) + lastDig;
            x = x / 10;
        }

        if (revNum == origNum) {
            return true;
        }

        return false;
    }
}