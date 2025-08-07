class Solution {
    public void setZeroes(int[][] matrix) {
    //  int m = matrix.length;//row
    //  int n = matrix[0].length;//col
    //  int marker = Integer.MIN_VALUE + 1;

    //  for(int i= 0;i<m;i++){ //row
    //     for(int j=0;j<n;j++){ //col
    //         if(matrix[i][j] == 0){
    //             rowMat(matrix,m,n,i,marker); 
    //             colMat(matrix,m,n,j,marker);
    //         }
    //     }
    //  }

    //  for(int i=0;i<m;i++){
    //     for(int j=0;j<n;j++){
    //         if(matrix[i][j] == marker ){
    //             matrix[i][j] = 0;
    //         }
    //     }
    //  }
        
    // }

    // public void rowMat(int[][] matrix,int m,int n,int i,int marker){
    //     for(int j=0;j<n;j++){
    //         if(matrix[i][j] != 0 && matrix[i][j] != marker){
    //             matrix[i][j] = marker;
    //         }
    //     }
    // }

    // public void colMat(int[][] matrix,int m,int n,int j,int marker){
    //     for(int i=0;i<m;i++){
    //         if(matrix[i][j] != 0 && matrix[i][j]!= marker){
    //             matrix[i][j] = marker;
    //         }
    //     }
    // }
int m = matrix.length;//row
int n = matrix[0].length;//col

boolean[] row = new boolean[m];
boolean[] column = new boolean[n];

for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
        if(matrix[i][j] == 0){
            row[i] = true;
            column[j] = true;
        }
    }
}

for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
        if(row[i] || column[j]){
            matrix[i][j] = 0;
        }
    }
}
    
}

}