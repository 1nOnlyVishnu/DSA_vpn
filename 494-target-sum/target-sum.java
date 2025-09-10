class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sumOfArray = 0;
        for(int num : nums){
            sumOfArray = sumOfArray + num;
        }
        
        if ((sumOfArray + target) % 2 != 0 || Math.abs(target) > sumOfArray) return 0;
        
        int ans = (target + sumOfArray) / 2;

        if(ans < 0) return 0;
 
        return CountOfSubset(nums,ans);
    }
    public static int CountOfSubset(int[] nums,int sum){
        int n = nums.length ;
        
        int[][] t = new int[n+1][sum+1];
        
    
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }
        
        
        for(int i = 1;i<n+1;i++){
            for(int j = 0;j<sum+1;j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j- nums[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
        
        
        
        
    }
}