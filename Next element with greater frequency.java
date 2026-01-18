import java.util.*;

class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int cur = arr[i];
            int curFreq = freq.get(cur);

            while (!st.isEmpty() && freq.get(st.peek()) <= curFreq) {
                st.pop();
            }

            ans.set(i, st.isEmpty() ? -1 : st.peek());

            st.push(cur);
        }

        return ans;
    }
}
