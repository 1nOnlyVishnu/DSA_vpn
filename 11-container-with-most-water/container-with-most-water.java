class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        
        while(left <= right){
            int length = Math.min(height[left] , height[right]);
            int breadth = right - left;

            int area = length * breadth;

            maxArea = Math.max(maxArea , area);

            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }

        }

        return maxArea;

    }
}