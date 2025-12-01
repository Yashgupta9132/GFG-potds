class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int count = 0; 
    }

    TrieNode root = new TrieNode();

    void insert(int num) {
        TrieNode node = root;
        for (int bit = 15; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            if (node.child[b] == null) node.child[b] = new TrieNode();
            node = node.child[b];
            node.count++;
        }
    }
    int countLess(int num, int k) {
        TrieNode node = root;
        int res = 0;

        for (int bit = 15; bit >= 0; bit--) {
            if (node == null) break;

            int nb = (num >> bit) & 1;
            int kb = (k >> bit) & 1;

            if (kb == 1) {
                if (node.child[nb] != null)
                    res += node.child[nb].count;
                node = node.child[nb ^ 1];
            } else {
                node = node.child[nb];
            }
        }

        return res;
    }

    public int cntPairs(int[] arr, int k) {
        int pairs = 0;

        for (int x : arr) {
            pairs += countLess(x, k);
            insert(x);
        }

        return pairs;
    }
}
