package 字符串;

import com.adam.printer.BinaryTreeInfo;
import com.adam.printer.BinaryTrees;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 
 * @author adam
 *
 */
public class _572_另一棵树的子树 {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null) {
			return false;
		}
		return postSerialize(root).contains(postSerialize(subRoot));
	}

	private String postSerialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		postSerialize(root, sb);
		return sb.toString();
	}

	private void postSerialize(TreeNode node, StringBuilder sb) {
		if (node.left == null) {
			sb.append("#!");
		} else {
			postSerialize(node.left, sb);
		}
		if (node.right == null) {
			sb.append("#!");
		} else {
			postSerialize(node.right, sb);
		}
		sb.append(node.val).append("!");
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		root.right = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		BinaryTrees.println(new BinaryTreeInfo() {

			@Override
			public Object string(Object node) {
				return ((TreeNode) node).val;
			}

			@Override
			public Object root() {
				return root;
			}

			@Override
			public Object right(Object node) {
				return ((TreeNode) node).right;
			}

			@Override
			public Object left(Object node) {
				return ((TreeNode) node).left;
			}
		});
		_572_另一棵树的子树 o = new _572_另一棵树的子树();
		System.out.println(o.postSerialize(root));
	}
}
