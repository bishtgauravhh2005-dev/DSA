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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root ==null ) return null;
        if(root.val == key){
                if(root.left == null) return root.right;
                if(root.right == null) return root.left;
                else{
                    TreeNode prev = root.left;
                    TreeNode temp = root.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    temp.left = prev;
                    return root.right;
                }
        }
        if(root.val < key){
            root.right = deleteNode(root.right , key);
        }
        else{
            root.left = deleteNode(root.left , key);
        }
        return root;
    }
}