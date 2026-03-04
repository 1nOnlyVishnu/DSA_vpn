class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length; //row
        int n = mat[0].length;

        int result = 0;

        if(mat.length == 0) return result;

        // int[] rowArr = new int[m];
        // int[] colArr = new int[n];


        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0) continue;

                boolean special = true;

                //check row
                for(int r = 0;r<m;r++){
                    if(r != i && mat[r][j] == 1){
                        special = false;
                        break;
                    }
                }


                //check col
                for(int c = 0;c<n;c++){
                    if(c != j && mat[i][c] == 1){
                        special = false;
                        break;
                    }
                }

                if(special == true){
                    result++;
                }

            }
        }

        return result;
        
    }
}