package 排序_数组;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * 
 * @author adam
 *
 */
public class _面试题16_16_部分排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] subSort(int[] array) {
		if (array.length == 0) {
			return new int[] { -1, -1 };
		}
		int l = -1, r = -1, max = array[0], min = array[array.length - 1];
		// 从左扫描到右寻找逆序对(正序:逐渐变大)
		for (int i = 1; i < array.length; i++) {
			int v = array[i];
			if (v >= max) {
				max = v;
			} else {
				r = i;
			}
		}
		// 提前结束
		if (r == -1) {
			return new int[] { -1, -1 };
		} // 从右扫描到左寻找逆序对(正序:逐渐变小)
		for (int i = array.length - 1; i >= 0; i--) {
			int v = array[i];
			if (v <= min) {
				min = v;
			} else {
				l = i;
			}
		}
		return new int[] { l, r };
	}
}
