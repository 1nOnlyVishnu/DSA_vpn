class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        int right = left + 1;
        int profit = 0;

        while(right < prices.length){
            int currentProfit = 0;
            if(prices[left] < prices[right]){
                currentProfit = prices[right] - prices[left];
                profit = Math.max(currentProfit,profit);
            }else{
                left = right;
            }
            right++;
        }
        return profit;
    }
}