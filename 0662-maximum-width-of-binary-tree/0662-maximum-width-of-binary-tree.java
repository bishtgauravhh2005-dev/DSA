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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node , int idx){
            this.node = node ;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int MaxWidth =0;

        while(!q.isEmpty()){
            int size= q.size();
            int st = 0;
            int end = 0;
            int min = q.peek().idx;
            

            for(int i=0 ;i<size;i++){
                Pair curr = q.poll();
                TreeNode node= curr.node;
                int index = curr.idx - min;
                if(i== 0){
                    st = index;
                }
                if(i== size-1){
                    end = index;
                }
                if(node.left != null){
                    q.offer(new Pair(node.left , 2 * index+1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right , 2* index+2));
                }
            } 
            MaxWidth = Math.max(MaxWidth , end-st+1);
        }
    return MaxWidth;
    }
}