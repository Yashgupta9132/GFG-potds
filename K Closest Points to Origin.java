// Java 

import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        
        for (int[] p : points) {
            int dist = p[0] * p[0] + p[1] * p[1];
            maxHeap.offer(new int[]{dist, p[0], p[1]});
            if (maxHeap.size() > k) {
                maxHeap.poll(); 
            }
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            ArrayList<Integer> point = new ArrayList<>();
            point.add(top[1]);
            point.add(top[2]);
            result.add(point);
        }
        
        return result;
    }
}
