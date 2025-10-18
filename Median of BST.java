class Solution {
    
    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int count = 0;
    private int median = 0;

    private void findMedianUtil(Node root, int targetCount) {
        if (root == null) return;

        findMedianUtil(root.left, targetCount);
        
        count++;
        if (count == targetCount) {
            median = root.data;
            return;
        }
        
        findMedianUtil(root.right, targetCount);
    }

    public int findMedian(Node root) {
        if (root == null) return 0;

        int n = countNodes(root);

        if (n % 2 == 1) {  
            findMedianUtil(root, (n + 1) / 2);
            return median;
        } else {  
            findMedianUtil(root, n / 2);
            return median;
        }
    }
}
