package 集合;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode-cn.com/problems/intersection-of-two-arrays/
/*
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
*/
public class _349_两个数组的交集 {
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length - 1;
		int len2 = nums2.length - 1;
		Set<Integer> result = new HashSet<>();
		while (len1 > -1 && len2 > -1) {
			if (nums1[len1] == nums2[len2]) {
				result.add(nums1[len1]);
				len1--;
				len2--;
			} else if (nums1[len1] < nums2[len2])
				len2--;
			else
				len1--;
		}
		int[] results = new int[result.size()];
		int start = 0;
		for (int item : result) {
			results[start] = item;
			start++;
		}
		return results;

	}

	public int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> result = new TreeSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			int data1 = nums1[i];
			for (int j = 0; j < nums2.length; j++) {
				int data2 = nums2[j];
				if (data1 == data2) {
					result.add(data1);
				}
			}
		}

		int[] results = new int[result.size()];
		int start = 0;
		for (int item : result) {
			results[start] = item;
			start++;
		}
		return results;
	}

	public static void main(String[] args) {

	}

}
