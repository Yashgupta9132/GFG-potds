// Java 

import java.util.*;

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;

        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.data);
    }
}
