class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());

        List<String> result = new ArrayList<>();

        for(int i=0;i<k;i++){
            int maxVal = Collections.max(values);
            int index = -1;
            String chosen = "";


          for (int j = 0; j < values.size(); j++) {
                if (values.get(j) == maxVal) {
                    if (index == -1 || keys.get(j).compareTo(chosen) < 0) {
                        index = j;
                        chosen = keys.get(j);
                    }
                }
            }

            result.add(chosen);

            values.remove(index);
            keys.remove(index);
        }

    return result;

    }
}