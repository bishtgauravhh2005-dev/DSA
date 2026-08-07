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
    public TreeNode helper(int[] inorder , int[] postorder , int st , int end ){
        if(st>end){
            return null;
        }
        int rootindex = st;
        int rootvalue = postorder[preindex--];
        TreeNode root = new TreeNode(rootvalue);

        while(rootvalue != inorder[rootindex]){
            rootindex ++;
        }
        root.right = helper(inorder , postorder ,  rootindex+1, end );
        root.left = helper(inorder , postorder ,  st ,rootindex-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        preindex = postorder.length-1;
        return helper(inorder , postorder , 0, inorder.length -1 );
    }
}