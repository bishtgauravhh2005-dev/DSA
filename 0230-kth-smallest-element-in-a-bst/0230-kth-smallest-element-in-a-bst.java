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
    private ArrayList<Integer> a ;
    public void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        a.add(root.val);
        inorder(root.right);

        return;
    }

    public int kthSmallest(TreeNode root, int k) {
        a = new ArrayList<>();
        inorder(root);
        int ans = a.get(k-1);
        return ans;
    }
}