class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int num: nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        for(HashMap.Entry<Integer,Integer> entry:freqMap.entrySet()){
            if(entry.getValue() > 1){
                return entry.getKey();
            }
        }

        return -1;
    }
}