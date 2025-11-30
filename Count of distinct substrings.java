class Solution {
    static class State {
        int len, link;
        int[] next = new int[26];

        State() {
            Arrays.fill(next, -1);
        }
    }

    public static int countSubs(String s) {
        int n = s.length();
        State[] st = new State[2 * n];
        for (int i = 0; i < 2 * n; i++) st[i] = new State();
        
        int last = 0, sz = 1;
        st[0].len = 0;
        st[0].link = -1;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            int cur = sz++;
            st[cur].len = st[last].len + 1;

            int p = last;
            while (p != -1 && st[p].next[c] == -1) {
                st[p].next[c] = cur;
                p = st[p].link;
            }

            if (p == -1) {
                st[cur].link = 0;
            } else {
                int q = st[p].next[c];
                if (st[p].len + 1 == st[q].len) {
                    st[cur].link = q;
                } else {
                    int clone = sz++;
                    st[clone].len = st[p].len + 1;
                    st[clone].next = st[q].next.clone();
                    st[clone].link = st[q].link;

                    while (p != -1 && st[p].next[c] == q) {
                        st[p].next[c] = clone;
                        p = st[p].link;
                    }

                    st[q].link = st[cur].link = clone;
                }
            }

            last = cur;
        }

        long ans = 0;
        for (int i = 1; i < sz; i++) {
            ans += st[i].len - st[st[i].link].len;
        }

        return (int) ans;
    }
}
