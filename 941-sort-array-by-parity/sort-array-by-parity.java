class Solution {
    public int[] sortArrayByParity(int[] nums) {

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        int size = even.size() + odd.size();
        int[] ans = new int[size];
        int index = 0;

        for (int num : even) {
            ans[index++] = num;
        }

        for (int num : odd) {
            ans[index++] = num;
        }

        return ans;

    }
}