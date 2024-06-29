package xyz.barry.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hot7_215 {
    //    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    // 一眼顶针，鉴定为：构造二叉树

    public TreeNode constructTree(TreeNode node, int num){
        if (node == null) return new TreeNode(num);

        if (num < node.val){
            node.left = constructTree(node.left, num);
        } else {
            node.right = constructTree(node.right, num);
        }

        return node;
    }

    private int count = 0;
    private int result = 0;
    public void findKth(TreeNode root, int k){
        if (root == null || count >= k) return ;

        findKth(root.right, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        findKth(root.left, k);
    }

    // 复杂度太高，用堆
    public int findKthLargest(int[] nums, int k) {

        TreeNode root = null;

        for (int num : nums){
            if (root == null){
                root = new TreeNode(num);
            }else{
                constructTree(root, num);
            }
        }

        findKth(root, k);
        return result;
    }

    
}
