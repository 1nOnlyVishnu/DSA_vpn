class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> numCounts = new HashMap<>();

        for(int num: nums){
            numCounts.put(num,numCounts.getOrDefault(num,0)+1);
        }

        List<Integer> ans = new ArrayList<>();

        for(HashMap.Entry<Integer,Integer> entry: numCounts.entrySet()){
            if(entry.getValue() > 1){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}