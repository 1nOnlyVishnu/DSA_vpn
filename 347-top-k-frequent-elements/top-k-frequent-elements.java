class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());

        int[] result = new int[k];

        for(int i=0;i<k;i++){
            int maxVal = Collections.max(values);
            int index = values.indexOf(maxVal);

            int element = keys.get(index);

            result[i] = element;

            values.remove(index);
            keys.remove(index);
        }

        return result;
    }
}