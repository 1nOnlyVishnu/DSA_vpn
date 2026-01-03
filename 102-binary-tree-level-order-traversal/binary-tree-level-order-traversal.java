/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       

        List<List<Integer>> result = new ArrayList<List<Integer>>();

         if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(q.size() > 0){
            int levelSize = q.size();
            ArrayList<Integer> subList = new ArrayList<>(levelSize);

            for(int i=0;i<levelSize;i++){
                TreeNode currentNode = q.poll();

                subList.add(currentNode.val);

                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }
            result.add(subList);

        }

        return result;
    }
}