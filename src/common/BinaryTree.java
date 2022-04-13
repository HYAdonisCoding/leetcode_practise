package common;

import java.util.LinkedList;
import java.util.Queue;

import com.adam.printer.BinaryTreeInfo;

@SuppressWarnings({ "unchecked", "unused" })
public class BinaryTree<E> implements BinaryTreeInfo {
	protected int size;
	protected Node<E> root;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	/// 前序遍历
	public void preorderTraversal(BST.Visitor<E> visitor) {
		if (visitor == null) {
			return;
		}
		preorderTraversal(root, visitor);
	}

	// 中序遍历
	public void inorderTraversal(BST.Visitor<E> visitor) {
		if (visitor == null) {
			return;
		}
		inorderTraversal(root, visitor);

	}

	// 后序遍历
	public void postorderTraversal(BST.Visitor<E> visitor) {
		if (visitor == null) {
			return;
		}
		postorderTraversal(root, visitor);

	}

	private void inorderTraversal(Node<E> node, BST.Visitor<E> visitor) {
		if (node == null || visitor.stop) {
			return;
		}
		inorderTraversal(node.left, visitor);
		if (visitor.stop) {
			return;
		}
		visitor.stop = visitor.visit(node.element);
		inorderTraversal(node.right, visitor);

	}

	private void postorderTraversal(Node<E> node, BST.Visitor<E> visitor) {
		if (node == null || visitor.stop) {
			return;
		}

		postorderTraversal(node.left, visitor);
		postorderTraversal(node.right, visitor);
		if (visitor.stop) {
			return;
		}
		visitor.stop = visitor.visit(node.element);

	}

	private void preorderTraversal(Node<E> node, BST.Visitor<E> visitor) {
		if (node == null || visitor.stop) {
			return;
		}

		visitor.stop = visitor.visit(node.element);
		preorderTraversal(node.left, visitor);
		preorderTraversal(node.right, visitor);
	}

	public boolean isComplete() {
		if (root == null) {
			return false;
		}
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);

		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) {
				return false;
			}
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				// node.left == null && node.right != null
				return false;
			}

			if (node.right != null) {
				queue.offer(node.right);
			} else {
				// node.left == null && node.right == null
				// node.left != null && node.right == null
				leaf = true;
			}

		}
		return true;
	}

	public int height() {
		if (root == null) {
			return 0;
		}
		int height = 0;
		// 每一层的元素数量
		int levelSize = 1;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();

			///
			levelSize--;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}

	public int height1() {
		return height1(root);
	}

	private int height1(Node<E> node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height1(node.left), height1(node.right));
	}

	protected Node<E> predecessor(Node<E> node) {
		if (node == null) {
			return null;
		}
		// 前驱节点在左子树当中（left.right.right...）
		Node<E> pNode = node.left;
		if (pNode != null) {

			while (pNode.right != null) {
				pNode = pNode.right;
			}
			return pNode;
		}
		// 从父节点和祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		// node.parent == null
		// node == node.parent.right
		return node.parent;
	}

	protected Node<E> successor(Node<E> node) {
		if (node == null) {
			return null;
		}
		// 前驱节点在左子树当中（right.left.left...）
		Node<E> pNode = node.right;
		if (pNode != null) {

			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		// 从父节点和祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		// node.parent == null
		// node == node.parent.left
		return node.parent;
	}

	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;

		Node<E> parent;

		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		public boolean hasTwoChildren() {

			return left != null && right != null;
		}

	}

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>) node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>) node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = ((Node<E>) node);
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}
}
