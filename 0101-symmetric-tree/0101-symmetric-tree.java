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
    public boolean isSymmetry(TreeNode left , TreeNode right){
        if(left == null || right == null){
            return right == left;
        }

        if(right.val != left.val) return false;

        return isSymmetry(left.right , right.left) && isSymmetry(left.left , right.right);
    }
    public boolean isSymmetric(TreeNode root) {
        return root== null || isSymmetry(root.left , root.right);
    }

}