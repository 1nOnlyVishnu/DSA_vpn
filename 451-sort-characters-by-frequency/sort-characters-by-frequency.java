class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        char[] arr = s.toCharArray();

        for(char ch: arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

                maxHeap.addAll(map.entrySet());

                StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}