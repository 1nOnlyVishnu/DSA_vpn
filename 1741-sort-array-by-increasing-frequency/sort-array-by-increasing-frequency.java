class Pair{
    int key;
    int value;

    Pair(int key , int value){
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int element = nums[i];
            mp.put(element,mp.getOrDefault(element,0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(a.value, b.value);
            if (cmp != 0) return cmp;
            return Integer.compare(b.key, a.key);
        });


    for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
        minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
    }

    int[] ans = new int[nums.length];

    int index = 0;

    while(!minHeap.isEmpty()){
        Pair p = minHeap.poll();
        for (int i = 0; i < p.value; i++) {
                ans[index++] = p.key;
            }
    }

    return ans;
    }
}