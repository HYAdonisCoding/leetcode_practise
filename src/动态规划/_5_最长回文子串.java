package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * @author adam
 *
 */
public class _5_最长回文子串 {
	private static char[] preprocess(char[] oldCs) {
		char[] cs = new char[(oldCs.length << 1) + 3];
		cs[0] = '^';
		cs[1] = '#';
		cs[cs.length-1] = '$';
		for (int i = 0;i < oldCs.length; i++) {
			int idx = (i + 1) << 1;
			cs[idx] = oldCs[i];
			cs[idx + 1] = '#';
		}
		return cs;
	}
	/**
	 * 马拉车 Manacher
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s == null) {
			return null;
		}

		char[] oldChars = s.toCharArray();
		if (oldChars.length <= 1) {
			return s;
		}
		//预处理
		char[] cs = preprocess(oldChars);
		// 构建m数组
		int[] m = new int[cs.length];
		// 最大回文字符串
		int maxLen = 0, idx = 0;
		int c = 1, r = 1, lastIdx = cs.length - 2;
		for (int i = 2; i < lastIdx; i++) {
			if (r > i) {
				int li = (c << 1) - i;
				m[i] =  (i + m[li] <= r) ? m[li] : (r - i);
			}
			// 以i为中心向左右扩散
			while (cs[i + m[i] + 1] == cs[i - m[i] - 1]) {
				m[i]++;
			}
			// 更新c, r
			if (i + m[i] > r) {
				c = i;
				r = i + m[i];
			}
			if (m[i] > maxLen) {
				maxLen = m[i];
				idx = i;
			}
		}
		int begin = (idx - maxLen) >> 1;
		System.out.println(begin+"_"+maxLen+"_"+idx);
		return new String(oldChars, begin, maxLen);
	}

	/**
	 * 扩展中心 优化
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindromeExtend1(String s) {
		if (s == null) {
			return null;
		}

		char[] chars = s.toCharArray();
		if (chars.length <= 1) {
			return s;
		}
		/// 最大回文子串的开始索引
		int begin = 0;
		/// 最大回文子串的长度
		int maxLen = 1;
		int i = 0;
		while (i < chars.length) {
			// 从l向左从r向右扩展
			int l = i - 1;
			// 找到右边第一个不等于i是位置
			int r = i;
			while (++r < chars.length && chars[r] == chars[i])
				;
			// r会成为新的i
			i = r;
			while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
				l--;
				r++;
			}
			// 扩展结束后, chars[l+1,r)就是最大回文子串
			// l++后就是找到的最大回文子串的开始索引
			int len = r - ++l;
			if (maxLen < len) {
				maxLen = len;
				begin = l;
			}

		}

		return new String(chars, begin, maxLen);
	}

	/**
	 * 扩展中心
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindromeExtend(String s) {
		if (s == null) {
			return null;
		}

		char[] chars = s.toCharArray();
		if (chars.length <= 1) {
			return s;
		}
		/// 最大回文子串的开始索引
		int begin = 0;
		/// 最大回文子串的长度
		int maxLen = 1;
		for (int i = chars.length - 2; i > 0; i--) {
			// 以字符为中心向左右扩展
			int len1 = palindromeLength(chars, i - 1, i + 1);
			// 以字符右边间隙为中心向左右扩展
			int len2 = palindromeLength(chars, i, i + 1);
			len1 = Math.max(len1, len2);
			if (len1 > maxLen) {
				maxLen = len1;
				begin = i - ((maxLen - 1) >> 1);
			}
		}
		/// 处理0号字符右侧间隙
		if (chars[0] == chars[1] && maxLen < 2) {
			maxLen = 2;
			begin = 0;
		}
		return new String(chars, begin, maxLen);
	}

	/**
	 * 从l开始向左扫描,以r开始向右扫描
	 * 
	 * @param cs
	 * @param l
	 * @param r
	 * @return [l,r)范围内的回文子串
	 */
	private static int palindromeLength(char[] cs, int l, int r) {
		while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
			l--;
			r++;
		}
		return r - l - 1;
	}

	/**
	 * 动态规划
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome_Dp(String s) {
		if (s == null) {
			return null;
		}

		char[] chars = s.toCharArray();
		if (chars.length <= 1) {
			return s;
		}
		/// 最大回文子串的开始索引
		int begin = 0;
		/// 最大回文子串的长度
		int maxLen = 1;
		boolean[][] dp = new boolean[chars.length][chars.length];
		/// 从下到上(i由大到小)
		for (int i = chars.length - 1; i >= 0; i--) {
			/// 从左到右(j由小到大)
			for (int j = i; j < chars.length; j++) {
				int len = j - i + 1;
				dp[i][j] = (chars[i] == chars[j]) && (len <= 2 || dp[i + 1][j - 1]);
				if (dp[i][j] && maxLen < len) {
					maxLen = len;
					begin = i;
				}
			}
		}
		return new String(chars, begin, maxLen);
	}

	public static void main(String[] args) {
//		System.out.println(longestPalindrome("babad"));
//		System.out.println(longestPalindrome("aa"));
//		System.out.println(longestPalindrome("ccc"));

		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("ac"));
	}

}
