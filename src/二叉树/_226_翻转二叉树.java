package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/invert-binary-tree/
public class _226_翻转二叉树 {

	/// 前序遍历
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	/// 后序遍历
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return root;
		}
		invertTree(root.left);
		invertTree(root.right);
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		return root;
	}

	/// 中序遍历
	public TreeNode invertTree3(TreeNode root) {
		if (root == null) {
			return root;
		}
		invertTree(root.left);
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		invertTree(root.left);

		return root;
	}

	/// 层序遍历
	public TreeNode invertTree4(TreeNode root) {
		if (root == null) {
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tempNode = node.left;
			node.left = node.right;
			node.right = tempNode;

			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

		return root;
	}

	public static void main(String[] args) {

	}

}
