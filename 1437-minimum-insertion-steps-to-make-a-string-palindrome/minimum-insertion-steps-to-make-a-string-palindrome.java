class Solution {
    public int minInsertions(String s) {
        int m = s.length();

        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        String s2 = new String(arr);

        int n = s2.length();

        int insOps = s2.length() - lcsHelper(s,s2,m,n);
        return insOps;
    }

    public int lcsHelper(String s,String s2,int m,int n){
        char[] str1 = s.toCharArray();
        char[] str2 = s2.toCharArray();

        int[][] t = new int[m+1][n+1];

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1[i-1] == str2[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }

        return t[m][n];
    }
}