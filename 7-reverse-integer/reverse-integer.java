class Solution {
    public int reverse(int x) {
        int ans = 0;
        int big = Integer.MAX_VALUE;
        int smol = Integer.MIN_VALUE;
        while(x != 0){
            int lastDigit = x % 10;
            
        if((ans > big/10 ) || (ans < smol/10)){
            return 0;
        }
            ans = (ans*10) + lastDigit;
            x  = x / 10;
        }

        return ans;
    }
}