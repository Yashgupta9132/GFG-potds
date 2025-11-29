class Solution {
    public static int countSetBits(int n) {
        if (n == 0) return 0;

        int x = highestPowerOf2(n);
        int bitsUpto2x = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int rest = countSetBits(n - (1 << x));

        return bitsUpto2x + msbBits + rest;
    }

    private static int highestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n) x++;
        return x;
    }
}
