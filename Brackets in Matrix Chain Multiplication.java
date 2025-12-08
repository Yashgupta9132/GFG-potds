class Solution {
    static final int MOD = 1_000_000_007;

    int distinctSubseq(String str) {
        int n = str.length();
        long[] dp = new long[n + 1];
        dp[0] = 1; 

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            int c = str.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[c] != -1) {
                dp[i] = (dp[i] - dp[last[c]] + MOD) % MOD;
            }

            last[c] = i - 1;
        }

        return (int) dp[n];
    }
}
