import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>(n);
        Stack<Integer> st = new Stack<>(); 

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            int val = st.isEmpty() ? (i + 1) : (i - st.peek());
            span.add(val);

            st.push(i);
        }

        return span;
    }
}
