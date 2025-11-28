class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        int totalXor = 0;
        if (n % 4 == 1) totalXor = 1;
        else if (n % 4 == 2) totalXor = n + 1;
        else if (n % 4 == 3) totalXor = 0;
        else totalXor = n;

        if (totalXor == n) {
            for (int i = 1; i <= n; i++) ans.add(i);
            return ans;
        }

        int x = totalXor ^ n; 
        boolean[] removed = new boolean[n + 1];

        if (x >= 1 && x <= n) {
            removed[x] = true;
        } else {
            for (int a = 1; a <= n; a++) {
                int b = a ^ x;
                if (b >= 1 && b <= n && a != b) {
                    removed[a] = true;
                    removed[b] = true;
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!removed[i]) ans.add(i);
        }

        return ans;
    }
}
