class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num , mp.getOrDefault(num,0)+1);
        }

        int missing = -1;
        int duplicate = -1;

        for(int i = 1;i<=n;i++){
            if(!mp.containsKey(i)){
                missing = i;
            }else if(mp.get(i) > 1){
                duplicate = i;
            }
        }

        return new int[]{duplicate , missing };
    }
}