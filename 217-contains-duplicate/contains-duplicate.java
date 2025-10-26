class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        for(int freq : freqMap.values()){
            if(freq > 1){
                return true;
            }
        }
        return false; 
    }
}