
class Pair {
    int freq;
    int num;

    Pair(int freq, int num) {
        this.freq = freq;
        this.num = num;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.freq - b.freq);

      
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.add(new Pair(entry.getValue(), entry.getKey()));
            if (heap.size() > k) {
                heap.poll();
            }
        }

    
        int[] result = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            result[i++] = heap.poll().num;
        }

        return result;
    }
}
