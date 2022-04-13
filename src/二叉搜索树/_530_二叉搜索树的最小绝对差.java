package 二叉搜索树;


/**
 * @auther adam
 * @date 2022/4/13
 * @apiNote 二叉搜索树
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 同783. 二叉搜索树节点最小距离 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class _530_二叉搜索树的最小绝对差 {
    private TreeNode preNode;
    private int minValue = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {

        getMinimumDiff(root);
        return minValue;
    }

    private void getMinimumDiff(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimumDifference(root.left);

        if (preNode != null) {
            minValue = Math.min(minValue, Math.abs(preNode.val - root.val));
        }
        preNode = root;
        getMinimumDifference(root.right);
    }

}
