package 二叉树;

/** https://leetcode-cn.com/problems/largest-bst-subtree/
 * 给定一个二叉树,找到其中最大的二叉搜索树(BST)子树,其中最大树指的是子节点数最多的.
 * 注意: 子树必须包含其所有后代.
 * @auther adam
 * @date 2022/2/16
 * @apiNote 二叉树
 */
public class _333_最大BST子树 {
    /** 后续遍历判断 successor */
    public int largestBSTSubtree(TreeNode root) {

        return root == null ? 0 : getInfo(root).size;
    }
    /**
    * @Description: 以node为根节点的最大BST子树的信息
    * @Param:
    * @return:
    * @Author: Adam
    * @Date: 2022/2/16
    */
    private Info getInfo(TreeNode root) {
        if (root == null) {
            return null;
        }
        // li(left info) 左子树的最大BST子树的信息
        Info li = getInfo(root.left);
        // ri(right info) 左子树的最大BST子树的信息
        Info ri = getInfo(root.right);
        /**
         * 有四种情况, 以root为根节点的二叉树就是一颗BST,最大BST子树就是其本身
         * 1.li != null && ri != null && li.root == root.left &&
         *    root.val > li.max && ri.root == root.right &&
         *    root.val < ri.min
         *
         * 2.li != null && ri == null &&
         *      li.root == root.left && root.val > li.max
         * 3.li == null && ri != null &&
         *      ri.root == root.right && root.val < ri.min
         *
         * 4. li == null && ri == null
         * */
        int leftBstSize = -1, rightBstSize = -1, max = root.val, min = root.val;
        if (li == null) {
            leftBstSize = 0;
        } else if (li.root == root.left && root.val > li.max) {
            leftBstSize = li.size;
            min = li.min;
        }
        if (ri == null) {
            rightBstSize = 0;
        } else if (ri.root == root.left && root.val < ri.min) {
            rightBstSize = ri.size;
            max = ri.max;
        }
        if (leftBstSize >= 0 && rightBstSize >= 0) {
            return new Info(root, 1+ leftBstSize + rightBstSize, max, min);
        }
        // 以root为根节点的二叉树不是BST

        // 返回最大BST子树的节点数量较多的那个Info
        if (li != null && ri != null) {
            return ((li.size > ri.size) ? li : ri);
        }
        // 返回li ri中不为空的那个Info
        return (li != null) ? li : ri;
    }
    /** 最大BST子树的信息 */
    private static  class Info {
        /** 根节点 */
        public TreeNode root;
        /** 节点数量 */
        public int size = 1;
        /** 最大值 */
        public int max;
        /** 最小值 */
        public int min;

        public Info(TreeNode root, int size, int max, int min) {
            this.root = root;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

/************-----------------------------------*/
    private boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        return min < node.val && node.val < max && isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
    private int nodesCount(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + nodesCount(node.left) + nodesCount(node.right);
    }
    public int largestBSTSubtree1(TreeNode root) {
        if (root == null) {
            return  0;
        }
        if (isBST(root)) {
            return nodesCount(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
}
