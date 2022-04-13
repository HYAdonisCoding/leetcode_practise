package 二叉搜索树;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 */
public class _450_删除二叉搜索树中的节点 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		TreeNode cur = root;
		TreeNode parent = null; // 记录cur的父节点，用来删除cur
		// 迭代遍历节点
		while (cur != null) {
			if (cur.val == key)
				break;
			parent = cur;
			if (cur.val > key) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		if (parent == null) {// 删除根节点
			return deleteOneNode(cur);
		}
		// parent 节点要判断是删除左节点还是右节点
		if (parent.left != null && parent.left.val == key) {
			parent.left = deleteOneNode(cur);
		}
		if (parent.right != null && parent.right.val == key) {
			parent.right = deleteOneNode(cur);
		}
		return root;
	}

	// 将目标节点（删除节点）的左子树放到目标节点的右子树的最左面节点的左子树位置上
	// 并返回目标节点右孩子为新的根节点
	private TreeNode deleteOneNode(TreeNode root) {
		if (root == null) {
			return root;
		}
		if (root.right == null) {
			return root.left;
		}
		TreeNode cur = root.right;
		while (cur.left != null) {
			cur = cur.left;
		}
		cur.left = root.left;
		return root.right;
	}

}
