public class Solution {
    public int trap(int[] height) {
        int size = height.length;

        int[] maxL = new int[size];
        int[] maxR = new int[size];

        maxL[0] = height[0];
        for(int i = 1;i<size;i++){
            maxL[i] = Math.max(maxL[i-1],height[i]);
        }

        maxR[size - 1] = height[size-1];
        for(int i=size-2;i>=0;i--){
            maxR[i] = Math.max(maxR[i+1],height[i]);
        }

        int[] water = new int[size];
        for(int i = 0;i<size;i++){
            water[i] = (Math.min(maxL[i] , maxR[i])) - height[i];
        }

        int area = 0;

        for(int num: water){
            area = area + num;
        }

        return area;
    }
}
