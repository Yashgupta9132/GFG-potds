import java.util.*;

class Solution {

    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();

        generateSums(left, 0, 0, leftSums);
        generateSums(right, 0, 0, rightSums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int sum : rightSums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int count = 0;
        for (int sum : leftSums) {
            count += map.getOrDefault(k - sum, 0);
        }

        return count;
    }

    private void generateSums(int[] arr, int idx, int currSum, List<Integer> list) {
        if (idx == arr.length) {
            list.add(currSum);
            return;
        }
        generateSums(arr, idx + 1, currSum, list);
        generateSums(arr, idx + 1, currSum + arr[idx], list);
    }
}
