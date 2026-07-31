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
    // public int height(TreeNode root){      //TC = O(n)
    //     if(root == null){
    //         return 0 ;
    //     }
    //     int left = height(root.left);
    //     int right = height(root.right);

    //     return Math.max(left , right)+1;
        
    // }
    // public int diameterOfBinaryTree(TreeNode root) {      // TC = O(n)  Total : O(n2) 
    //     if(root == null){
    //         return 0;
    //     }
    //     int left = diameterOfBinaryTree(root.left);
    //     int right = diameterOfBinaryTree(root.right);
    //     int ans = height(root.left) + height(root.right);

    //     return Math.max(left , Math.max(right , ans));
    // }




    // More optimal approach :
    int ans = 0;
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        
        ans = Math.max(ans , left+right);

        return Math.max(left , right ) +1;
    }
    public int diameterOfBinaryTree(TreeNode root){
        height(root);
        return ans ;
    }
}