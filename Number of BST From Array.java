// Java 

import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int maxN = 6;
        long[] catalan = new long[maxN + 1];
        catalan[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (arr[j] < arr[i]) left++;
                else if (arr[j] > arr[i]) right++;
            }
            int count = (int)(catalan[left] * catalan[right]);
            result.add(count);
        }

        return result;
    }
}
