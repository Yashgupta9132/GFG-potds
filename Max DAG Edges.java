class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {

        int maxPossible = V * (V - 1) / 2;

        int existing = edges.length;

        return maxPossible - existing;
    }
}
