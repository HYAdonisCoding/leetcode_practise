package 二叉搜索树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**	https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * */
public class _98_验证二叉搜索树 {
	/**
	 * 思路2 – 遍历的同时指定范围--层序遍历
	 */
	public boolean isValidBST3(TreeNode root) {
		if (root == null) {
			return true;
		}
		offer(root, null, null);
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			Integer min = mins.poll();
			Integer max = maxs.poll();
			if (min != null && node.val < min) {
				return false;
			}
			if (max != null && node.val > max) {
				return false;
			}
			offer(node.left, min, node.val);
			offer(node.right, node.val, max);

		}

		return true;
	}
	private void offer(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return;
		}
		nodes.offer(node);
		mins.offer(min);
		maxs.offer(max);
	}
	private Queue<TreeNode> nodes = new LinkedList<>();
	private Queue<Integer> mins = new LinkedList<>();
	private Queue<Integer> maxs = new LinkedList<>();

	/**
	 * 思路2 – 遍历的同时指定范围--前序遍历
	 */
	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isValid(root, null, null);
	}

	private boolean isValid(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}
		if (min != null && node.val < min) {
			return false;
		}
		if (max != null && node.val > max) {
			return false;
		}
		if (!isValid(node.left, min, node.val)) {
			return false;
		}
		if (!isValid(node.right, node.val, max)) {
			return false;
		}
		return true;
	}
	/**
	 * 思路1 – 中序遍历 - 迭代
	 */
	public boolean isValidBST1(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		Integer last = null;
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) { break; }
			root = stack.pop();
			if (last != null && last >= root.val)  { return false; }
			last = root.val;
			root = root.right;
		}
		return true;
	}

	/**
	 * 思路1 – 中序遍历 - 递归
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) { return false; }
		if (last != null && last >= root.val)  { return false; }
		last = root.val;
		if (!isValidBST(root.right)) { return false; }
		return true;
	}
	private Integer last;

	public static void main(String[] args) {
		//[5,1,4,null,null,3,6]
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1);
		node.right = new TreeNode(4);
		node.right.left = new TreeNode(3);
		node.right.right = new TreeNode(6);

		_98_验证二叉搜索树 o = new _98_验证二叉搜索树();
		System.out.println(o.isValidBST(node));

	}
}
