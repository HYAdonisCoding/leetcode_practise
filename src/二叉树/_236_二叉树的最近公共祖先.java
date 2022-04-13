package 二叉树;

/** https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @auther adam
 * @date 2022/2/15
 * @apiNote 二叉树
 */
public class _236_二叉树的最近公共祖先 {


    /**
    *
    * 去以root为根节点的二叉树中查找p q的最近公共祖先
    * 1 如果p q同时存在这棵二叉树中,就能成功返回他们给的最近公共祖先
    * 2 如果p q都不存在这棵二叉树中,就返回null
    * 3 如果只有p存在这棵二叉树中,就返回p
    * 4 如果只有q存在这棵二叉树中,就返回q
    * @Description:
    * @Param:
    * @return:
    * @Author: Adam
    * @Date: 2022/2/15
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        /// 去以root左半部分为根节点的二叉树中查找p q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        /// 去以root右半部分为根节点的二叉树中查找p q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if ( left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}
