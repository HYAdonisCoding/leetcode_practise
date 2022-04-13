package 栈;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/implement-stack-using-queues/
// 栈 后进先出	队列	先进先出
public class _225_用队列实现栈 {
	public _225_用队列实现栈() {

	}

	private Queue<Integer> mainQueue = new LinkedList<Integer>();
	private Queue<Integer> tempQueue = new LinkedList<Integer>();

	public void push(int x) {
		tempQueue.offer(x);
		while (!mainQueue.isEmpty()) {
			tempQueue.offer(mainQueue.poll());
		}
		Queue<Integer> queue = tempQueue;
		tempQueue = mainQueue;
		mainQueue = queue;
	}

	public int pop() {
		return mainQueue.poll();
	}

	public int top() {
		return mainQueue.peek();
	}

	public boolean empty() {
		return mainQueue.isEmpty();
	}
}
