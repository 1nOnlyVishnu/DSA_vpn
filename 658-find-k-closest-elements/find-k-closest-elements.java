class Pair {
    int first, second;
    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (b.first != a.first) return b.first - a.first;
                return b.second - a.second;
            }
        );

        for (int num : nums) {
            maxHeap.add(new Pair(Math.abs(num - x), num));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll().second);
        }

        Collections.sort(ans);
        return ans;
    }
}
