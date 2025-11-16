class Solution {
    int[][] t;
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

         lcsHelper(str1,str2,m,n);

         return scsPrinter(t, m, n, str1, str2);


        
    }

    public int lcsHelper(String str1,String str2,int m,int n){
        char[] s1 = str1.toCharArray();

        char[] s2 = str2.toCharArray();

        t = new int[m+1][n+1];

        

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1[i-1] == s2[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        

        return t[m][n];
    }

public String scsPrinter(int[][] t, int m, int n, String str1, String str2) {
    int i = m, j = n;

    StringBuilder sb = new StringBuilder();

    while (i > 0 && j > 0) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            sb.append(str1.charAt(i - 1));
            i--;
            j--;
        } else if (t[i][j - 1] > t[i - 1][j]) {
            sb.append(str2.charAt(j - 1));
            j--;
        } else {
            sb.append(str1.charAt(i - 1));
            i--;
        }
    }

    // Add remaining characters
    while (i > 0) {
        sb.append(str1.charAt(i - 1));
        i--;
    }
    while (j > 0) {
        sb.append(str2.charAt(j - 1));
        j--;
    }

    // Reverse the result (since we built it backward)
    return sb.reverse().toString();
}


    
}