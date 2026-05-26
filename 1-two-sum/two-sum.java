class Solution {
    public int[] twoSum(int[] nums, int target) {
        // target ,  nums array as input
        // find two val that add up to target
        // return their indices
        // x + y = target
        // use value from nums as x, then the equation will become something like 2 + y = 9 
        // y = 9 - 2;
        // y = target - nums[i];
        // O(1) == set and map
        // if i use set == > keys (individual values) but for this problem i need to return the indices...
        // hashmap ==>  nums[i] , i


        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for ( int i = 0; i < nums.length; i++ ){
            int y = target - nums[i];
            if(freqMap.containsKey(y)){
                return new int[] {freqMap.get(y),i};
            }

            freqMap.put(nums[i] , i);
        }

        return new int[] {};
    }
}