class Solution {
    
    private int firstOneIndex(int[] row) {
        int low = 0, high = row.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        
        int maxOnes = 0;
        int rowIndex = -1;
        
        for (int i = 0; i < n; i++) {
            int firstOne = firstOneIndex(arr[i]);
            if (firstOne != -1) {
                int onesCount = m - firstOne;
                if (onesCount > maxOnes) {
                    maxOnes = onesCount;
                    rowIndex = i;
                }
            }
        }
        
        return rowIndex;
    }
}
