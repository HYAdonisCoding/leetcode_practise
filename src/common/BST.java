package common;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({ "unchecked", "unused" })
public class BST<E> extends BinaryTree<E> {

	private Comparator<E> comparator;

	public BST(Comparator<E> comparator) {
		this.comparator = comparator;
	}

	public BST() {
		this(null);
	}

	public void add(E element) {
		elementNotNullCheck(element);
		// 添加的是第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		// 添加的不是第一个节点
		Node<E> node = root;

		// 父节点
		Node<E> parent = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else {
				// 相等
				node.element = element;
				break;
			}

		}
		/// 看看插入到父节点的哪一个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else if (cmp < 0) {
			parent.left = newNode;
		}
		size++;
	}

	public void remove(E element) {
		remove(node(element));
	}

	public boolean contains(E element) {

		return node(element) != null;
	}

	private void remove(Node<E> node) {
		if (node == null) {
			return;
		}
		size--;

		if (node.hasTwoChildren()) {// 度为2的节点
			// 找到后继节点
			Node<E> sNode = successor(node);
			// 用后继节点的值覆盖度为2的节点的值
			node.element = sNode.element;
			// 删除后继节点
			node = sNode;
		}
		// 删除node节点(node的度必然是1或者0)
		Node<E> replacementNode = node.left != null ? node.left : node.right;

		if (replacementNode != null) {// node是度为1的节点
			// 更改parent
			replacementNode.parent = node.parent;
			// 更改parent的left\right的指向
			if (node.parent == null) {// node是度为1的节点并且是根节点
				root = replacementNode;
			} else if (node == node.parent.left) {
				node.parent.left = replacementNode;
			} else {// node == node.parent.right
				node.parent.right = replacementNode;
			}
		} else if (node.parent == null) {// 叶子节点并且是根节点
			root = null;
		} else {
			// 叶子节点 但不是根节点
			if (node == node.parent.left) {
				node.parent.left = null;
			} else {
				node.parent.right = null;
			}
		}
	}

	private Node<E> node(E element) {
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) {
				return node;
			}
			if (cmp > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	}

	// 返回值 0 ：e1和e2相等，大于0： e1大于e2， 小于0：e1小于e2
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable) e1).compareTo(e2);
	}

	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element can not be null");
		}
	}

	public void levelOrderTraversal(Visitor<E> visitor) {
		if (root == null || visitor == null) {
			return;
		}
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) {
				return;
			}
			;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

	public static abstract class Visitor<E> {
		boolean stop;

		/// 返回true停止遍历
		public abstract boolean visit(E element);
	}

}
