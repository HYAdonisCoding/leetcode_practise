package 栈;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 根据 逆波兰表示法，求表达式的值。
有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：
输入：tokens = ["2","1","+","3","*"]
输出：9
解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
示例 2：
输入：tokens = ["4","13","5","/","+"]
输出：6
解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
示例 3：
输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
输出：22
解释：
该算式转化为常见的中缀算术表达式为：
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class _150_逆波兰表达式求值 {

	public static int evalRPN(String[] tokens) {
		int score = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String ch = tokens[i];
			if (!("+".equals(ch) || "-".equals(ch) || "*".equals(ch) || "/".equals(ch))) {
				Integer num = Integer.parseInt(ch);
				if (num != null) {
					stack.push(num);
				}
				continue;
			} else {
				if ("+".equals(ch)) {
					score = stack.pop() + stack.pop();
					stack.push(score);
					continue;
				} else if ("-".equals(ch)) {
					Integer a = stack.pop();
					Integer b = stack.pop();
					score = b - a;
					stack.push(score);
					continue;
				} else if ("*".equals(ch)) {
					score = stack.pop() * stack.pop();
					stack.push(score);
				} else if ("/".equals(ch)) {
					Integer a = stack.pop();
					Integer b = stack.pop();
					score = b / a;
					stack.push(score);
					continue;
				}
			}
		}
		return stack.pop();

	}

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };// 9
		System.out.println(evalRPN(tokens));
		String[] tokens1 = { "4", "13", "5", "/", "+" };// 6
		System.out.println(evalRPN(tokens1));
		String[] tokens2 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(evalRPN(tokens2));// 22

	}

}
