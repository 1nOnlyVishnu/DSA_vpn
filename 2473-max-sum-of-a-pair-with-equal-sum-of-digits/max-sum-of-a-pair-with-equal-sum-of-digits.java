class Solution {

    public int maximumSum(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int maxSum = -1;

        for (int num : nums) {

            int ds = digitSum(num);

            // If digit sum already exists,
            // we found a valid pair
            if (map.containsKey(ds)) {

                maxSum = Math.max(
                    maxSum,
                    num + map.get(ds)
                );
            }

            // Store the largest number
            // for this digit sum
            map.put(
                ds,
                Math.max(
                    map.getOrDefault(ds, 0),
                    num
                )
            );
        }

        return maxSum;
    }

    private int digitSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}