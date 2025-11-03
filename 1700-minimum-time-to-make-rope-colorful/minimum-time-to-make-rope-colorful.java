class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;

        int left = 0;

       char[] colorsArr =  colors.toCharArray();

        for(int right = 1;right<colorsArr.length;right++){
            if(colorsArr[left] == colorsArr[right]){
                if(neededTime[left] < neededTime[right]){
                    res += neededTime[left];
                    left = right;
                }else{
                    res += neededTime[right];
                }
            }else{
                left = right;
            }
        }
        return res;
    }
}