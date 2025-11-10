class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int hold = -arr[0];   
        int sell = 0;         
        int cool = 0;         

        for (int i = 1; i < n; i++) {
            int newHold = Math.max(hold, sell - arr[i]);
            int newSell = Math.max(sell, cool);
            int newCool = hold + arr[i];  

            hold = newHold;
            sell = newSell;
            cool = newCool;
        }

        return Math.max(sell, cool);
    }
}
