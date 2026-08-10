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
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     TreeNode root = new TreeNode(preorder[0]);
    //     for(int i =1 ;i< preorder.length ; i++){
    //         insert(root , preorder[i]);
    //     }
    //     return root;
    // }
    // public void insert(TreeNode root , int val){
    //     if(root.val > val){
    //         if(root.left == null){
    //             root.left = new TreeNode(val);
    //         }
    //         else{
    //             insert(root.left , val);
    //         }
    //     }
    //     else{
    //         if(root.right ==null ){
    //             root.right = new TreeNode(val);
    //         }
    //         else{
    //             insert(root.right , val);
    //         }
    //     }
    // }


    // more optimize approach 
    int index = 0;
    public TreeNode construct(int [] preorder , int upperbound){
        if(index == preorder.length || preorder[index] > upperbound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;

        root.left = construct(preorder, root.val);

        root.right = construct(preorder, upperbound);

        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder , Integer.MAX_VALUE);
    }
}