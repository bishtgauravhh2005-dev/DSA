class Solution {

    HashMap<Integer, TreeNode> map = new HashMap<>();
    HashSet<Integer> leafValues = new HashSet<>();
    HashSet<Integer> used = new HashSet<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        // Store every tree by its root value
        for (TreeNode root : trees) {
            map.put(root.val, root);
        }

        // Store all leaf values
        for (TreeNode root : trees) {

            if (root.left != null) {
                leafValues.add(root.left.val);
            }

            if (root.right != null) {
                leafValues.add(root.right.val);
            }
        }

        // Find the final root
        TreeNode root = null;

        for (TreeNode node : trees) {

            if (!leafValues.contains(node.val)) {
                root = node;
                break;
            }
        }

        // No unique final root
        if (root == null) {
            return null;
        }

        // Mark final root as used
        used.add(root.val);

        // Merge all possible trees
        merge(root);

        // We must have used every tree
        if (used.size() != trees.size()) {
            return null;
        }

        // Validate BST
        if (!isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return null;
        }

        return root;
    }

    private void merge(TreeNode root) {

        if (root == null) {
            return;
        }

        // If left is a leaf and another tree has this root
        if (root.left != null && map.containsKey(root.left.val)) {

            TreeNode childTree = map.get(root.left.val);

            if (!used.contains(childTree.val)) {
                root.left = childTree;
                used.add(childTree.val);
            }
        }

        // If right is a leaf and another tree has this root
        if (root.right != null && map.containsKey(root.right.val)) {

            TreeNode childTree = map.get(root.right.val);

            if (!used.contains(childTree.val)) {
                root.right = childTree;
                used.add(childTree.val);
            }
        }

        merge(root.left);
        merge(root.right);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val)
            && isValidBST(root.right, root.val, max);
    }
}