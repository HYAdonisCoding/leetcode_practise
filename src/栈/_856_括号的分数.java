package 栈;

import java.util.Stack;

// https://leetcode-cn.com/problems/score-of-parentheses/
public class _856_括号的分数 {
	// (()(())) -> 6
	public static int scoreOfParentheses(String s) {
		int score = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(score);
				score = 0;
				continue;
			}

			if (score == 0) { // "()"的情况
				score = 1;
			} else { // (A)的情况
				score *= 2;
			}
			score += stack.pop();
		}
		return score;
	}

	public static void main(String[] args) {
		System.err.println(scoreOfParentheses("()"));
		System.err.println(scoreOfParentheses("(())"));
		System.err.println(scoreOfParentheses("()()"));
		System.err.println(scoreOfParentheses("(()(()))"));
	}
}
