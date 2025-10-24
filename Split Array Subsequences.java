// Java

import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int k) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(num - 1)) {
                PriorityQueue<Integer> prevHeap = map.get(num - 1);
                int smallestLength = prevHeap.poll(); 
                if (prevHeap.isEmpty()) map.remove(num - 1);

                map.computeIfAbsent(num, x -> new PriorityQueue<>()).offer(smallestLength + 1);
            } else {
                map.computeIfAbsent(num, x -> new PriorityQueue<>()).offer(1);
            }
        }

        for (PriorityQueue<Integer> heap : map.values()) {
            for (int len : heap) {
                if (len < k) return false;
            }
        }

        return true;
    }
}
