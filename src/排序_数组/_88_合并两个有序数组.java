package 排序_数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author adam
 *
 */
public class _88_合并两个有序数组 {

	public static void main(String[] args) {

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1 = m - 1, i2 = n - 1, cur = nums1.length - 1;
		while (i2 >= 0) {
			// 赋值
			if (i1 > 0 && nums2[i2] < nums1[i1]) {
				nums1[cur--] = nums1[i1--];

			} else {
				// i1<0||nums2[i2--]>nums2[i2]
				nums1[cur--] = nums2[i2--];
			}
		}
	}
}
