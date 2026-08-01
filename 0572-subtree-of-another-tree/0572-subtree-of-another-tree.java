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
    public boolean isidentical(TreeNode root , TreeNode subroot){
        if(root == null || subroot == null){
            return root == subroot;
        }

        boolean left = isidentical(root.left , subroot.left);
        boolean right = isidentical(root.right , subroot.right);

        return left && right && root.val == subroot.val;
    }
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if(root == null || subroot == null){
            return root == subroot;
        }
        
        if(root.val == subroot.val && isidentical(root , subroot)){
            return true;
        }
        return isSubtree(root.left , subroot) || isSubtree(root.right , subroot);
    }
}