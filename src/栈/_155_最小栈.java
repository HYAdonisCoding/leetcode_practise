package 栈;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @auther adam
 * @date 2022/5/29
 * @apiNote 栈
 * https://leetcode.cn/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 */
public class _155_最小栈 {
    /**
     * 思路：链表方式实现
     */
    public _155_最小栈() {
        head = new Node(0, Integer.MAX_VALUE, null);
    }
    private Node head;
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

//    /**
//     * 思路：辅助栈
//     */
//    public _155_最小栈() {
//        stack = new Stack<>();
//        hStack = new Stack<>();
//    }
//    private Stack<Integer> stack;
//    private Stack<Integer> hStack;
//
//    public void push(int val) {
//        stack.push(val);
//        if (hStack.isEmpty() || hStack.peek() > val) {
//            hStack.push(val);
//        } else  {
//            hStack.push(hStack.peek());
//        }
//    }
//
//    public void pop() {
//        stack.pop();
//        hStack.pop();
//
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return hStack.peek();
//    }

    /**
     * 思路： 优先级队列 最小堆
     */
//    public _155_最小栈() {
//        stack = new Stack<>();
//        queue = new PriorityQueue<>((Integer i1, Integer i2) -> {
//            if (i1 == Integer.MIN_VALUE) { return -1; }
//            if (i2 == Integer.MIN_VALUE) { return 1; }
//            return i1 - i2;
//        });
//    }
//    private Stack<Integer> stack;
//    private PriorityQueue<Integer> queue;
//
//    public void push(int val) {
//        stack.push(val);
//        queue.add(val);
//        System.out.println("push:" + val + ", min:" + queue.peek());
//    }
//
//    public void pop() {
//        Integer o = stack.pop();
//        boolean success = queue.remove(o);
//        System.out.println("remove:" + o + ", " + success);
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return queue.peek();
//    }

    public static void main(String[] args) {
        _155_最小栈 obj = new _155_最小栈();
//        obj.push(-2);
//        obj.push(0);
//        obj.push(-3);
//        int param_3 = obj.top();
//        int param_4 = obj.getMin();
//        System.out.println(param_3 + " -- " + param_4); // -3 -- -3
//        obj.pop();
//
//        int param_5 = obj.top();
//        int param_6 = obj.getMin();
//        System.out.println(param_5 + " -- " + param_6); // 0 -- -2
//       ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        int param_1 = obj.top();
        obj.pop();
        int param_2 = obj.getMin();
        obj.pop();
        int param_3 = obj.getMin();
        obj.pop();
        obj.push(2147483647);
        int param_4 = obj.top();
        //"getMin","push","top","getMin","pop","getMin"
        int param_5 = obj.getMin();
        obj.push(-2147483648);
        int param_6 = obj.top();
        int param_7 = obj.getMin();
        obj.pop();
        int param_8 = obj.getMin();
        System.out.println(param_1 + "," + param_2 + "," + param_3 + "," + param_4 + "," + param_5 + "," + param_6 + "," + param_7 + "," + param_8);

        //[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]

    }
}
