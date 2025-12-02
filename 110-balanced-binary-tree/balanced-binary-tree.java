class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // Returns height if balanced, -1 if not balanced
    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1; // left subtree already unbalanced

        int right = height(node.right);
        if (right == -1) return -1; // right subtree already unbalanced

        if (Math.abs(left - right) > 1) return -1; // this node breaks balance

        return Math.max(left, right) + 1;
    }
}
