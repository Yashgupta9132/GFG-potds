import java.util.*;

class Solution {
    public String removeKdig(String s, int k) {
        int n = s.length();
        if (k >= n) return "0";

        StringBuilder st = new StringBuilder(); 

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            while (k > 0 && st.length() > 0 && st.charAt(st.length() - 1) > ch) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }
            st.append(ch);
        }

        while (k > 0 && st.length() > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }
        int idx = 0;
        while (idx < st.length() && st.charAt(idx) == '0') idx++;

        String res = st.substring(idx);

        return res.length() == 0 ? "0" : res;
    }
}
