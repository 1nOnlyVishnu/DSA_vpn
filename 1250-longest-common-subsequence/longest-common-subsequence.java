class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();

        int n = a.length;
        int m = b.length;

        return lcsHelper(a,b,n,m);
        
    }

public int lcsHelper(char[] a,char[] b,int n,int m){

    int[][] t = new int[n+1][m+1];

    for(int i = 0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            if(i==0){
                t[i][j] = 0;
            }

            if(j == 0){
                t[i][j] = 0;
            }
        }
    }


            // if(n == 0 || m == 0){
            //     return 0;
            // }


        // if(a[n-1] == b[m-1]){
        //     t[i][j] = 1 + lcsHelper(a,b,n-1,m-1);
        // }else{
        //     return Math.max(lcsHelper(a,b,n,m-1), lcsHelper(a,b,n-1,m));
        // }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(a[i-1] == b[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1] , t[i-1][j]);
                }
            }
        }

        return t[n][m];
            
     
    }
}

