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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        if (root == null)  return new ArrayList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                if(!q.isEmpty()){
                    q.offer(null);
                    ans.add(l);
                    l = new ArrayList<>();
                }
                else{
                    ans.add(l);
                    break;
                }
            }
            else{
                l.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
    return ans ;
    }
}