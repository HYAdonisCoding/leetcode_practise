package 字符串;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 
 * @author adam
 *
 */
public class _242_有效的字母异位词 {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		char[] schars = s.toCharArray();
		char[] tchars = t.toCharArray();
		if (schars.length != tchars.length) {
			return false;
		}
		int[] counts = new int[26];
		for (int i = 0; i < schars.length; i++) {
			counts[schars[i] - 'a']++;
		}
		for (int i = 0; i < tchars.length; i++) {
			if (--counts[tchars[i] - 'a'] < 0)
				return false;
		}
		return true;
	}

	public boolean isAnagram1(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		int[] counts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			if (--counts[t.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
