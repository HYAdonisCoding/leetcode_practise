package 栈;

import java.util.Stack;

/*
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
示例 1：

输入：s = "1 + 1"
输出：2
示例 2：

输入：s = " 2-1 + 2 "
输出：3
示例 3：

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23

 * 
 */
public class _224_基本计算器 {
	public static int calculate(String s) {
		// 将所有的空格去掉
		s = s.replaceAll(" ", "");
		if (!(s.contains("+") || s.contains("-"))) {
			return Integer.parseInt(s.replace("(", "").replace(")", ""));
		}
		int length = s.length();
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int result = 0, sign = 1;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9') { // 每次处理一个数（可能有几位）
				int cur = 0;
				while (i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
					cur = 10 * cur + (s.charAt(i) - '0');
					i++;
				}
				result += sign * cur;
				i--; // s[i]在减之前一定指向非数字的位置，留给下一个循环处理
			} else if (c == '+')
				sign = 1;
			else if (c == '-')
				sign = -1;
			else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} // 这里进入括号，栈中保存历史结果，res保存括号中计算中结果，要重置，相当于递归中每层的局部变量
			else if (c == ')') {
				result *= stack.pop();
				result += stack.pop();
			} // 栈顶先是符号，然后是操作数
		}
		return result;
	}

	public static void main(String[] args) {

		System.err.println(calculate("- (3 + (4 + 5))"));// -12
		System.err.println(calculate(" 2-1 + 2 "));
		System.err.println(calculate(" 22-1 + 2 "));
		System.err.println(calculate("(1+(4+5+2)-3)+(6+8)"));

	}

}
