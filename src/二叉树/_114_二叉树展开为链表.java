package 二叉树;

import java.util.Stack;

/**
 * @auther adam
 * @date 2022/5/27
 * @apiNote 二叉树
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
    /**
     * 思路2 – 后序遍历   迭代实现
     */
    public void flatten3(TreeNode root) {
        if (root == null) { return; }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            // 如果栈顶节点是叶子节点
            boolean leaf = (top.left == null) && (top.right == null);
            // 如果上一次访问的结点是栈顶节点的子节点
            boolean preIsChild = (prev != null) &&
                    ((prev == top.left) || (prev == top.right));
            if(leaf || preIsChild){
                if (prev != null) {
                    top.right = prev;
                    top.left = null;
                }
                prev = top;

                // 弹出栈顶节点
                stack.pop();

                // 标记为已访问
                prev = top;
            } else {
                if(top.left != null) {
                    stack.push(top.left);
                }
                if(top.right != null) {
                    stack.push(top.right);
                }
            }
        }
    }
    /**
     * 思路2 – 后序遍历   递归实现
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        if (prev != null) {
            root.right = prev;
            root.left = null;
        }
        prev = root;

    }
    private TreeNode prev;

    /**
     * 思路1 – 前序遍历   迭代实现
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode oldRight = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode right = root;
                while (right.right != null) {
                    right = right.right;
                }
                right.right = oldRight;
            }
            root = root.right;
        }

    }
    /**
     * 思路1 – 前序遍历   递归实现
     */
//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        TreeNode oldRight = root.right;
//        root.right = root.left;
//        root.left = null;
//        TreeNode right = root;
//        while (right.right != null) {
//            right = right.right;
//        }
//        right.right = oldRight;
//        flatten(root.right);
//    }

}
