package 栈;

import java.util.Stack;

// https://leetcode-cn.com/problems/implement-queue-using-stacks/submissions/
public class _232_用栈实现队列 {
	private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();

	public _232_用栈实现队列() {

	}

	public void push(int x) {
		inStack.push(x);
	}

	public int pop() {
		checkOutStack();
		return outStack.pop();
	}

	public int peek() {
		checkOutStack();
		return outStack.peek();
	}

	public boolean empty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}

	private void checkOutStack() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
