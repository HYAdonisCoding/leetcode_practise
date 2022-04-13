package 字符串;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * 
 * @author adam
 *
 */
public class 面试题01_09_字符串轮转 {
	public static boolean isFlipedString(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		/// 可考虑KMP算法
		return (s1 + s1).contains(s2);
	}

	public static void main(String[] args) {
		System.out.println(isFlipedString("cdab", "abcd"));
	}

}
