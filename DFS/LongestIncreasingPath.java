public class Solution {
    
    
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int result = 0;
        
        int[][] cache = new int[matrix.length][matrix[0].length];
        
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                result = longestIncreasingPath(matrix, i, j, cache) > result ? longestIncreasingPath(matrix, i, j, cache) : result;
            }
        }
        
        return result;
        
        
    }
    
    public int longestIncreasingPath(int[][] matrix, int row, int col, int[][] cache) {
        if(cache[row][col] != 0) return cache[row][col];
        
        int max = 1;
        int len;
        
        if(legalMove(matrix, row-1, col, row, col)) {
            len = 1+longestIncreasingPath(matrix, row-1, col, cache);
            max = Math.max(max, len);
        }
        
        if(legalMove(matrix, row+1, col, row, col)) {
            len = 1+longestIncreasingPath(matrix, row+1, col, cache);
            max = Math.max(max, len);
        }
        
        if(legalMove(matrix, row, col-1, row, col)) {
            len = 1+longestIncreasingPath(matrix, row, col-1, cache);
            max = Math.max(max, len);
        }
        
        if(legalMove(matrix, row, col+1, row, col)) {
            len = 1+longestIncreasingPath(matrix, row, col+1, cache);
            max = Math.max(max, len);
        }              
        
        cache[row][col] = max;
       
        return max;
    }
    
    private boolean legalMove(int[][] matrix, int row, int col, int cRow, int cCol) {
        if(row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0) return false;
        return matrix[row][col] > matrix[cRow][cCol]; 
    }
}