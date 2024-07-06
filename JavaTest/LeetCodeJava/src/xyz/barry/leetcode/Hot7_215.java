package xyz.barry.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hot7_215 {
    //    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    //    一眼顶针，鉴定为：构造堆
    //    注意了，大根堆是根结点大于子节点，小根堆是根结点小于子结点


    public TreeNode constructTree(TreeNode node, int num) {
        if (node == null) return new TreeNode(num);

        if (num < node.val) {
            node.left = constructTree(node.left, num);
        } else {
            node.right = constructTree(node.right, num);
        }

        return node;
    }

    private int count = 0;
    private int result = 0;

    public void findKth(TreeNode root, int k) {
        if (root == null || count >= k) return;

        findKth(root.right, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        findKth(root.left, k);
    }

    public int findKthLargest_high(int[] nums, int k) {

        TreeNode root = null;

        for (int num : nums) {
            if (root == null) {
                root = new TreeNode(num);
            } else {
                constructTree(root, num);
            }
        }

        findKth(root, k);
        return result;
    }

    public int findKthLargest_qk(int[] nums, int k) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums[len - k];
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int val = nums[l];

        int i = l, j = r;

        while (i < j) {
            while (i < j && val < nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && val > nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = val;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }


    // 建立堆
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            // 堆中删除元素一般来说就是把最后一个元素给它填到第一个位置上，然后再进行调整
            swap(nums, 0, i);
            --heapSize;
            adjustHeap(nums, 0, heapSize);
        }
        return nums[0];
    }


    public void buildMaxHeap(int[] arr, int heapSize){
        for (int i = heapSize/2; i >= 0 ; i--) {
            adjustHeap(arr, i, heapSize);
        }
    }

    // 堆本身就是一颗完全二叉树，需要对其重新调整
    public void adjustHeap(int[] a, int root, int heapSize) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // 和largest比较而不是和root比较
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }

        if (right < heapSize && a[right] > a[largest]){
            largest = right;
        }

        if (largest != root){
            swap(a, largest, root);
            adjustHeap(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
