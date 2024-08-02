class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<int []> ar = new ArrayList<int []>();
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j< matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    int [] temp = { i , j };
                    ar.add(temp);
                }
            }
        }
        sz( ar , matrix);

    }
    public static void sz( ArrayList<int []> a , int[][] m){
        for( int x = 0 ; x < a.size() ; x++){
            int [] c = new int[2];
            c = a.get(x);
            int row = c[0];
            int col = c[1];
            for(int j = 0 ; j< m[0].length ; j++){
                m[row][j] = 0;
            }
            for(int i = 0 ; i < m.length ; i++){
                m[i][col] = 0;
            }
        }
    }
}