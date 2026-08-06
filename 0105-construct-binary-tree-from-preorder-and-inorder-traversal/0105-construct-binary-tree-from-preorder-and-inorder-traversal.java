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
    int preindex = 0;
    public TreeNode helper(int[] preorder , int[] inorder , int start , int end){
        if(start>end){
            return null;
        }
        int rootindex = start;
        int rootvalue = preorder[preindex++];
        TreeNode root = new TreeNode(rootvalue);

        while(rootvalue != inorder[rootindex]){
            rootindex ++;
        }
        
        root.left = helper(preorder , inorder , start , rootindex-1);
        root.right = helper(preorder , inorder , rootindex+1 ,end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder , inorder , 0 , inorder.length -1 );
    }
}