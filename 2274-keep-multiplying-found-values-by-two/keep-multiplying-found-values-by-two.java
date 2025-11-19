class Solution {
    public int findFinalValue(int[] nums, int original) {

        // Keep looping as long as we find the current value in nums
        boolean found = true;

        while(found) {
            found = false;

            // Search for the value in the array
            for(int n : nums) {
                if(n == original) {
                    original *= 2;   // Double it
                    found = true;    // Found, so continue the cycle
                    break;
                }
            }
        }

        return original;
    }
}
