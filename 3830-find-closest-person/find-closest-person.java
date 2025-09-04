class Solution {
    public int findClosest(int x, int y, int z) {
        int distXtoZ = Math.abs(x - z);
        int distZtoY = Math.abs(y - z);

        if(distXtoZ > distZtoY){
            return 2;
        }else if(distXtoZ < distZtoY){
            return 1;
        }

    return 0;
    }
}