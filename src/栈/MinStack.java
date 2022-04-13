package 栈;

/**
 * https://leetcode-cn.com/problems/min-stack/ 设计一个支持 push ，pop ，top
 * 操作，并能在常数时间内检索到最小元素的栈。 155. 最小栈
 * 
 * @author adam
 *
 */
/// 链表方式实现
class MinStack {
	private Node head;

	public MinStack() {
		head = new Node(0, Integer.MAX_VALUE, null);
	}

	public void push(int val) {
		head = new Node(val, Math.min(val, head.min), head);
	}

	public void pop() {
		head = head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

	private static class Node {
		public int val;
		public int min;
		public Node next;

		public Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}

	}
}
/// 两个栈实现
//public class MinStack {
//
//	/**
//	 * 用来存放正常数据
//	 */
//	private Stack<Integer> stack;
//	/**
//	 * 用来存放最小数据
//	 */
//	private Stack<Integer> minStack;
//
//	public MinStack() {
//		stack = new Stack<>();
//		minStack = new Stack<>();
//	}
//
//	public void push(int val) {
//		stack.push(val);
//		if (minStack.isEmpty()) {
//			minStack.push(val);
//		} else {
//			minStack.push(Math.min(val, minStack.peek()));
//		}
//	}
//
//	public void pop() {
//		stack.pop();
//		minStack.pop();
//	}
//
//	public int top() {
//		return stack.peek();
//	}
//
//	public int getMin() {
//		return minStack.peek();
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
