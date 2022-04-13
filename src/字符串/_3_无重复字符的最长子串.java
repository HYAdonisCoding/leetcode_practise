package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author adam
 *
 */
public class _3_无重复字符的最长子串 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int[] prevIdxes = new int[128];
		for (int i = 0; i < prevIdxes.length; i++) {
			prevIdxes[i] = -1;
		}
		prevIdxes[chars[0]] = 0;
		// 以i-1位置字符结尾的最长不重复子串开始位置(最左索引)
		int li = 0;
		int max = 1;
		for (int i = 1; i < chars.length; i++) {
			// i位置字符 上一次出现位置
			int pi = prevIdxes[chars[i]];

			if (li <= pi) {
				li = pi + 1;
			}

			/// 存储这个字符出现的位置
			prevIdxes[chars[i]] = i;
			max = Math.max(max, i - li + 1);
		}
		return max;
	}

	public int lengthOfLongestSubstring1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] chars = s.toCharArray();
		Map<Character, Integer> prevIdxes = new HashMap<>();
		prevIdxes.put(chars[0], 0);
		// 以i-1位置字符结尾的最长不重复子串开始位置(最左索引)
		int li = 0;
		int max = 1;
		for (int i = 1; i < chars.length; i++) {
			// i位置字符 上一次出现位置
			Integer pi = prevIdxes.getOrDefault(chars[i], -1);

			if (li <= pi) {
				li = pi + 1;
			} else {

			}

			/// 存储这个字符出现的位置
			prevIdxes.put(chars[i], i);
			max = Math.max(max, i - li + 1);
		}
		return max;
	}
}
