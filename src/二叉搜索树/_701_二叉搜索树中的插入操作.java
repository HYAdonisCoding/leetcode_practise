package 二叉搜索树;

/** https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 
 * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */
public class _701_二叉搜索树中的插入操作 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		TreeNode cur = root;
		TreeNode parent = null; // 记录cur的父节点，用来删除cur
		// 迭代遍历节点
		while (cur != null) {
			if (cur.val == val) {
				break;
			}
			parent = cur;
			if (cur.val > val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		if (parent.val > val) {
			parent.left = new TreeNode(val);
		} else {
			parent.right = new TreeNode(val);
		}
		return root;
	}

	public TreeNode insertIntoBST1(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		TreeNode cur = root;
		// 记录上一个节点
		TreeNode parent = root;
		while (cur != null) {
			parent = cur;
			if (cur.val < val) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		// 遍历完成后进行赋值
		TreeNode node = new TreeNode(val);
		if (parent.val < val) {
			parent.right = node;
		} else {
			parent.left = node;
		}
		return root;
	}

}
