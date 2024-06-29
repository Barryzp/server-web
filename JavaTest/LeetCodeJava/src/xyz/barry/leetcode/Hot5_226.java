package xyz.barry.leetcode;

public class Hot5_226 {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode leftChild = invertTree(root.left);
        TreeNode rightChild = invertTree(root.right);

        if (leftChild != null || rightChild != null){
            // swap subtree
            root.left = rightChild;
            root.right = leftChild;
        }
        return root;
    }
}
