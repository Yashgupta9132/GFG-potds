import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0, high = m - 1;
        
        while (low <= high) {
            int midCol = low + (high - low) / 2;
            
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            
            int curr = mat[maxRow][midCol];
            int left = (midCol > 0) ? mat[maxRow][midCol - 1] : Integer.MIN_VALUE;
            int right = (midCol < m - 1) ? mat[maxRow][midCol + 1] : Integer.MIN_VALUE;
            
            if (curr >= left && curr >= right) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(maxRow);
                res.add(midCol);
                return res;
            }
            
            if (left > curr) {
                high = midCol - 1;
            } else {
                low = midCol + 1;
            }
        }
        
        return new ArrayList<>(); 
    }
}
