package 字符串;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 
 * @author adam
 *
 */
public class _151_翻转字符串里的单词 {
	public static String reverseWords(String s) {
		if (s == null) {
			return "";
		}
		char[] chars = s.toCharArray();
		/// 消除多余的空格
		// 字符串最终的有效长度
		int len = 0;
		/// 当前用来存放的字符的位置
		int cur = 0;
		/// 前一个字符是否为空格字符
		boolean space = true;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				// 非空格
				chars[cur++] = chars[i];
				space = false;
			} else if (space == false) {
				// 空格 chars[i-1]是非空格
				chars[cur++] = ' ';
				space = true;
			}
		}
		len = space ? (cur - 1) : cur;
		if (len < 0) {
			return "";
		}
		/// 翻转
		/// 对整个有效字符串进行翻转
		reverse(chars, 0, len);
		// 对每一个单词进行逆序
		// 前一个空格字符的位置(有-1位置有个假想的哨兵,就是一个假想的空格字符)
		int prevSpaceIdx = -1;
		for (int i = 0; i < len; i++) {
			if (chars[i] != ' ') {
				continue;
			}
			reverse(chars, prevSpaceIdx + 1, i);
			prevSpaceIdx = i;
		}
		reverse(chars, prevSpaceIdx + 1, len);

		return new String(chars, 0, len);
	}

	/**
	 * 将[li, ri)范围内的字符串进行翻转
	 * 
	 * @param chars
	 * @param li
	 * @param ri
	 */
	private static void reverse(char[] chars, Integer li, int ri) {
		ri--;
		while (li < ri) {
			char tmp = chars[li];
			chars[li] = chars[ri];
			chars[ri] = tmp;
			li++;
			ri--;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("     "));
		System.out.println(reverseWords("   hello word!  "));
		System.out.println(reverseWords("a good  word!  "));
		System.out.println(reverseWords("are you ok"));

	}

}
