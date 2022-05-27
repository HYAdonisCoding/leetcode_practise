package 二叉树;

/**
 * @auther adam
 * @date 2022/5/26
 * @apiNote 二叉树
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class _124_二叉树中的最大路径和 {
    public int maxPathSum(TreeNode root) {
        value(root);
        return sum;
    }
    private int sum = Integer.MIN_VALUE;
    private int value(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lv = Math.max(value(node.left), 0);
        int rv = Math.max(value(node.right), 0);
        sum = Math.max(sum, node.val+ lv + rv);

        return node.val + Math.max(lv, rv);
    }
}
