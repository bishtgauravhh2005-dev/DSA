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
    // List<Integer> s = new ArrayList<>();
    // public void inorder(TreeNode root){
    //     if(root == null){
    //         return;
    //     }

    //     inorder(root.left);
    //     s.add(root.val);
    //     inorder(root.right);
    // }
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     inorder(root);
    //     return s;
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while(curr!=null){
            
            // is left child exist ?
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }

                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }
                else{
                    pred.right = curr;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        
        }
    return ans;
     }


}