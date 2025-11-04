class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = (int) getTopXSum(freq, x);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in = nums[i];

            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            freq.put(in, freq.getOrDefault(in, 0) + 1);

            ans[i - k + 1] = (int) getTopXSum(freq, x);
        }

        return ans;
    }

    private long getTopXSum(HashMap<Integer, Integer> freq, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> (b.freq != a.freq ? b.freq - a.freq : b.val - a.val)
        );

        for (var e : freq.entrySet()) {
            maxHeap.offer(new Pair(e.getKey(), e.getValue()));
        }

        long sum = 0;
        int count = 0;

        while (!maxHeap.isEmpty() && count < x) {
            Pair p = maxHeap.poll();
            sum += (long) p.val * p.freq;
            count++;
        }

        return sum;
    }

    private static class Pair {
        int val, freq;
        Pair(int v, int f) { val = v; freq = f; }
    }
}
