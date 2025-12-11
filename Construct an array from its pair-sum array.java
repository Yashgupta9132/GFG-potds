import java.util.*;

class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {

        int m = arr.length;

        if (m == 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            ans.add(arr[0] - 1);
            return ans;
        }

        int n = (int)((1 + Math.sqrt(1 + 8.0 * m)) / 2);

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        ans.set(0, (arr[0] + arr[1] - arr[n - 1]) / 2);

        for (int i = 1; i < n; i++) {
            ans.set(i, arr[i - 1] - ans.get(0));
        }

        return ans;
    }
}
