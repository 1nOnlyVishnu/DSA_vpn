class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<>();

       if(root == null){
        return result;
       }

       inorder(root,result);

       return result;
    }

    void inorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

   
}
