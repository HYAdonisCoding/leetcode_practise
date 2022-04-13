package 二叉树;

import common.BinaryTree;

/** https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @auther adam
 * @date 2022/2/16
 * @apiNote 二叉树
 */
public class _99_恢复二叉搜索树 {
    /** 时间复杂度O(n), 空间复杂度O(1) Morris遍历
     * @Description: 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
     * @Param:
     * @return:
     * @Author: Adam
     * @Date: 2022/2/16
     */
    public void recoverTree(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点(predecessor)  后继节点(successor)
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else {
                    // 第二次遍历到前驱节点  node.right == node
                    find(node);
                    pred.right = null;
                    node = node.right;
                }
            } else {
                find(node);
                node = node.right;
            }
        }

        // 交换两个错误节点
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void find(TreeNode node) {
        /// 出现了逆序对
        if (prev != null && prev.val > node.val) {

            // 第二个错误节点是较小的
            second = node;

            if (first != null) {
                return;
            }
            ;
            first = prev;
        }
        prev = node;
    }

    /** *****************常规方法****************** */

    /** 上一次中序遍历过的节点 */
    private TreeNode prev;
    /** 第一个错误的节点 */
    private TreeNode first;
    /** 最后一个错误的节点 */
    private TreeNode second;
    /**
    * @Description: 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
    * @Param:  
    * @return:  
    * @Author: Adam
    * @Date: 2022/2/16 
    */
    public void recoverTree1(TreeNode root) {
        findWrongNodes(root);
        // 交换两个错误节点
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void findWrongNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        findWrongNodes(node.left);
        /// 出现了逆序对
        if (prev != null && prev.val > node.val) {

            // 第二个错误节点是较小的
            second = node;

            if (first != null) {
                return;
            }
            ;
            first = prev;
        }
        prev = node;

        findWrongNodes(node.right);
    }
}
