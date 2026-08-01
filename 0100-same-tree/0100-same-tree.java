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
    public boolean isidentical(TreeNode p , TreeNode q){
        if(q == null || p == null){
            return p==q;
        }
        boolean left = isidentical(p.left , q.left);
        boolean right = isidentical(p.right , q.right);

        return left && right & p.val == q.val;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isidentical(p,q);
    }
}