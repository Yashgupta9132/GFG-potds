// Java 

class Solution {
    static int sum = 0;

    public static void transformTree(Node root) {
        sum = 0;  
        transform(root);
    }

    private static void transform(Node root) {
        if (root == null)
            return;
        transform(root.right);

        int temp = root.data;
        root.data = sum;  
        sum += temp;      

        transform(root.left);
    }
}
