public class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        // default value for unused dry days (must be > 0). Problem allows any positive integer.
        Arrays.fill(ans, 1);

        Map<Integer, Integer> full = new HashMap<>(); // lake -> last day index when it was filled
        TreeSet<Integer> dryDays = new TreeSet<>();   // indices of days with rains[i] == 0

        for (int i = 0; i < n; ++i) {
            if (rains[i] == 0) {
                // dry day: record index for later assignment
                dryDays.add(i);
                // ans[i] already 1 (placeholder); we might overwrite it later
            } else {
                int lake = rains[i];
                if (!full.containsKey(lake)) {
                    // lake was empty; now it becomes full
                    full.put(lake, i);
                    ans[i] = -1; // raining day
                } else {
                    // lake is already full; we must have dried it after its last fill and before now
                    int lastFill = full.get(lake);
                    Integer dryIndex = dryDays.higher(lastFill); // earliest dry day after lastFill
                    if (dryIndex == null) {
                        // no available dry day in the required interval -> impossible
                        return new int[0];
                    }
                    // schedule drying of this lake on dryIndex
                    ans[dryIndex] = lake;
                    dryDays.remove(dryIndex);

                    // now lake is considered filled at day i
                    full.put(lake, i);
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
}
