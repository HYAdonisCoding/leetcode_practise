package 二叉搜索树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @auther adam
 * @date 2022/4/14
 * @apiNote 二叉搜索树
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 */
public class _938_二叉搜索树的范围和 {

    private int sum;
    // 迭代
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.addLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            root = root.right;
        }
        return sum;
    }
        // 递归
    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null || low > high) {
            return 0;
        }
        rangeBST(root, low, high);
        return sum;
    }

    private void rangeBST(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        rangeBST(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeBST(root.right, low, high);

    }

}
