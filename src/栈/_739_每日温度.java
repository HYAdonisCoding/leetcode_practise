package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 
 * @author adam
 *
 */
public class _739_每日温度 {
	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return null;
		}
		int[] values = new int[temperatures.length];

		for (int i = temperatures.length - 2; i >= 0; i--) {
			int j = i + 1;
			while (true) {
				if (temperatures[i] < temperatures[j]) {
					values[i] = j - i;
					break;
				} else if (values[j] == 0) {
					values[i] = 0;
					break;
				}
				j = j + values[j];
			}
		}
		return values;

	}

	public int[] dailyTemperatures1(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return null;
		}
		int[] values = new int[temperatures.length];

		for (int i = temperatures.length - 2; i >= 0; i--) {
			int j = i + 1;
			while (true) {
				if (temperatures[i] < temperatures[j]) {
					values[i] = j - i;
					break;
				} else if (values[j] == 0) {
					values[i] = 0;
					break;
				} else if (temperatures[i] == temperatures[j]) {
					values[i] = values[j] + j - i;
					break;
				} else {
					j = j + values[j];
				}
			}
		}
		return values;

	}

	public int[] dailyTemperatures_stack(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return null;
		}
		int[] result = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int topIdx = stack.peek();
				result[topIdx] = i - topIdx;
				stack.pop();
			}
			stack.push(i);
		}
		return result;
	}
}
