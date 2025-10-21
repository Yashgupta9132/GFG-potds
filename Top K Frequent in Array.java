// Java

import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>(arr.length + 1);
        for (int i = 0; i <= arr.length; i++) buckets.add(new ArrayList<>());

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            buckets.get(e.getValue()).add(e.getKey());
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = arr.length; i >= 0 && res.size() < k; i--) {
            if (!buckets.get(i).isEmpty()) {
                Collections.sort(buckets.get(i), Collections.reverseOrder());
                for (int num : buckets.get(i)) {
                    res.add(num);
                    if (res.size() == k) break;
                }
            }
        }

        return res;
    }
}
