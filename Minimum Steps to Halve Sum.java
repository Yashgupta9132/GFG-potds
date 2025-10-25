// Java 

import java.util.*;

class Solution {
    public int minOperations(int[] arr) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double totalSum = 0;

        for (int num : arr) {
            totalSum += num;
            pq.offer((double) num);
        }

        double halfSum = totalSum / 2.0;
        double reducedSum = 0;
        int operations = 0;

        while (reducedSum < halfSum) {
            double largest = pq.poll();
            double half = largest / 2.0;
            reducedSum += half;
            pq.offer(half);
            operations++;
        }

        return operations;
    }
}
