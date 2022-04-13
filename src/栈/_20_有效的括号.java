package 栈;

import java.util.HashMap;
import java.util.Stack;

//https://leetcode-cn.com/problems/valid-parentheses/sloution/
public class _20_有效的括号 {
	private static HashMap<Character, Character> map = new HashMap<>();

	static {
		// key - value
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	}

//	public _20_有效的括号() {
//		// key - value
//		map.put('(', ')');
//		map.put('[', ']');
//		map.put('{', '}');
//	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {/// z左括号
				stack.push(c);
			} else {/// 右括号
				if (stack.isEmpty()) {
					return false;
				}
				char left = stack.pop();
				if (c != map.get(left)) {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	public boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {/// z左括号
				stack.push(c);
			} else {/// 右括号
				if (stack.isEmpty()) {
					return false;
				}
				char left = stack.pop();
				if (left == '(' && c != ')') {
					return false;
				}
				if (left == '{' && c != '}') {
					return false;
				}
				if (left == '[' && c != ']') {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	public boolean isValid2(String s) {

		return false;
	}

	public static void main(String[] args) {

		System.out.println(isValid("()"));
	}
}
