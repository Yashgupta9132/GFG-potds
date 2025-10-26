// Java

import java.util.*;

class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();   
            int second = pq.poll();  
            int cost = first + second;
            totalCost += cost;
            pq.add(cost);            
        }

        return totalCost;
    }
}
