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
    private HashMap<Integer , TreeNode > map = new HashMap<>();
    private HashSet<Integer> leafNodevalues = new HashSet<>();
    private HashSet<Integer> used = new HashSet<>();
    private void merge(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left != null && map.containsKey(root.left.val)){
            TreeNode ChildTree = map.get(root.left.val);

            if(!used.contains(ChildTree.val)){
                root.left = ChildTree;
                used.add(ChildTree.val);
            }
        }

        if(root.right != null && map.containsKey(root.right.val)){
            TreeNode ChildTree = map.get(root.right.val);

            if(!used.contains(ChildTree.val)){
                root.right = ChildTree;
                used.add(ChildTree.val);
            }
        }
        merge(root.left);
        merge(root.right);
    }



    public boolean isValidBST(TreeNode root , long lower , long upper ){
        if(root == null){
            return true;
        }
        if(root.val <= lower || root.val >= upper){
            return false;
        }

        return isValidBST(root.left , lower , root.val ) && isValidBST(root.right , root.val , upper);
    }
    public TreeNode canMerge(List<TreeNode> trees) {
        

        for(TreeNode root : trees){
            map.put(root.val , root);
        }

        for(TreeNode root : trees){
            if(root.left != null){
                leafNodevalues.add(root.left.val);
            }

            if(root.right!= null){
                leafNodevalues.add(root.right.val);
            }
        }
        TreeNode root = null;
        for(TreeNode node : trees){
            if(!leafNodevalues.contains(node.val)){
                root = node;
                break;
            }
        }

        if(root == null){
            return null;
        }

        used.add(root.val);

        merge(root);

        if(used.size() != trees.size()){
            return null;
        }
        if(!isValidBST(root , Long.MIN_VALUE , Long.MAX_VALUE)){
            return null;
        }
        return root;
    }

    
}