//MadarChod Constraints

/*

~~~~~~~~~~~~~  WORKS FOR ONLY POSTIVE INPUTS  ~~~~~~~~~~~~~~~~~~~

*/
// class Solution {
//     public int minimumDifference(int[] nums) {
//         int Range = 0;
//         for(int num : nums){
//             Range = Range + num;
//         }

//       ArrayList<Integer> result = SubsetSum(nums,Range);

//       int minAns = Integer.MAX_VALUE;
      
//       if(nums.length == 0) return 0;
      
//       for(int i = 0;i<result.size();i++){
//         minAns = Math.min(minAns,Range - 2 * result.get(i));
//       }

//       return minAns;


        
//     }

//     public static ArrayList<Integer> SubsetSum(int[] nums ,int Range){
//         ArrayList<Integer> ans  = new ArrayList<>();
//         int n = nums.length -1 ;

//         boolean[][] t = new boolean[n+1][Range+1];

//             for (int i = 0; i <= n; i++) {
//                 t[i][0] = true;
//             }
//             for (int j = 1; j <= Range; j++) {
//                 t[0][j] = false;
//             }


//         for(int i = 1;i<n+1;i++){
//             for(int j = 1;j<Range+1;j++){
//                 if(nums[i-1] <= j){
//                     t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
//                 }else{
//                     t[i][j] = t[i-1][j];
//                 }
//             }
//         }

//         int lastRow = t.length - 1;
//         for(int i = 0;i<=Range / 2;i++){
//             if(t[lastRow][i]){
//                 ans.add(i);
//             }
            
//         }

//         return ans;

//     }
// }

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 *n);
        
        
        List<List<Integer>> leftSums = generateSubsetSums(left);
        List<List<Integer>> rightSums = generateSubsetSums(right);
        
        int total = 0;
        for (int x : nums) total += x;
        int target = total/2;
        
        int ans = Integer.MAX_VALUE;
        
        for (int k = 0; k <= n; k++) {
            List<Integer> A = leftSums.get(k);
            List<Integer> B = rightSums.get(n - k);
            Collections.sort(B);
            
            for (int sumA : A) {
                int need = target - sumA;
                int idx = Collections.binarySearch(B, need);
                if (idx < 0) idx = -idx - 1;
                
                if (idx < B.size()) {
                    int sum = sumA + B.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
                if (idx - 1 >= 0) {
                    int sum = sumA + B.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }
        
        return ans;
    }
    
    private List<List<Integer>> generateSubsetSums(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k <= n; k++) res.add(new ArrayList<>());
        
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    bits++;
                }
            }
            res.get(bits).add(sum);
        }
        return res;
    }
}
