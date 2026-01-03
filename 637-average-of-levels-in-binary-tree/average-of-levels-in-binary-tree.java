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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(q.size() > 0){
            int levelSize = q.size();
            double levelSum = 0;
            

            for(int i=0;i<levelSize;i++){
                TreeNode currentNode = q.poll();
                levelSum = levelSum + currentNode.val;

                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }

            result.add(levelSum/levelSize);
            
        }

        return result;
    }
}