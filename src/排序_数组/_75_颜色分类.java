package 排序_数组;

/**
 * https://leetcode-cn.com/problems/sort-colors/ 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * @author adam
 *
 */
public class _75_颜色分类 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void sortColors(int[] nums) {
		int i = 0, l = 0, r = nums.length - 1;
		while (i <= r) {
			int v = nums[i];
			if (v == 0) {
				swap(nums, i++, l++);
			} else if (v == 1) {
				i++;
			} else {
				swap(nums, i, r--);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
