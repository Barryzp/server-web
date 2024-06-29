package xyz.barry.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Hot2_236 {
    public boolean getAncestors(TreeNode root, TreeNode node, List<TreeNode> ancestors){
        if (root == null) return false;

        ancestors.add(root);
        if (root == node) return true;

        if (((root.left != null) && getAncestors(root.left, node, ancestors))||
                ((root.right != null) && getAncestors(root.right, node, ancestors))) return true;

        // 整体逻辑就是如果到头都没有找到，说明不在这一条分支上面，把以前的数组中的元素都慢慢地移除掉
        ancestors.remove(ancestors.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();

        getAncestors(root, p, pAncestors);
        getAncestors(root, q, qAncestors);

        // qAncestors和pAncestors都是层次的顺序便利，因此可以顺序去对比
        int pSize = pAncestors.size();
        int qSize = qAncestors.size();

        TreeNode lowestAncestor = null;
        for (int i = 0; i < pSize; i++) {
            if (i >= qSize) break;

            if (pAncestors.get(i) == qAncestors.get(i)){
                lowestAncestor = pAncestors.get(i);
            }else break;
        }

        return lowestAncestor;
    }
}
