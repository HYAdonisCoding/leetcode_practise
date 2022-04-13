package 二叉搜索树;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 
 */
public class _700_二叉搜索树中的搜索 {
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		TreeNode cur = root;
		TreeNode parent = null; // 记录cur的父节点，用来删除cur
		// 迭代遍历节点
		while (cur != null) {
			if (cur.val == val) {
				parent = cur;
				break;
			}
			if (cur.val > val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return parent;
	}
}
