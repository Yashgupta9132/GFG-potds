// Java 

class Solution {
    int maxSum;

    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    int solve(Node root) {
        if (root == null)
            return 0;

        int left = Math.max(0, solve(root.left));  
        int right = Math.max(0, solve(root.right));

        maxSum = Math.max(maxSum, left + right + root.data);

        return root.data + Math.max(left, right);
    }
}
