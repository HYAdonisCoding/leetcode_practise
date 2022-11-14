package 动态规划;

import java.util.Arrays;

/**https://leetcode.cn/problems/split-array-with-same-average/
 * 给定你一个整数数组 nums
 *
 * 我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
 *
 * 如果可以完成则返回true ， 否则返回 false  。
 *
 * 注意：对于数组 arr ,  average(arr) 是 arr 的所有元素除以 arr 长度的和。
 *
 * @auther adam
 * @date 2022/11/14
 * @apiNote 动态规划
 */
public class _805_数组的均值分割 {
    public static void main(String[] args) {
        _805_数组的均值分割 o = new _805_数组的均值分割();
        int[] nums = {1,2,3,4,5,6,7,8};

        boolean result = o.splitArraySameAverage(nums);
        System.out.println("1 " + result);
        nums = new int[]{1, 2, 1};
        result = o.splitArraySameAverage(nums);
        System.out.println("2 " + result);
    }

    //两组的平均值相等的话，证明我所有的和的平均值是相等的
    public boolean splitArraySameAverage(int[] nums) {
        int len = nums.length;
        if (len == 0 || (len & 1) != 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        Arrays.sort(nums);
        for (int i = 1; i <= len / 2; i++) {
            if (sum * i % len == 0) {
                //是否存在长度为i 的 sum和为 sum * i / len  B arr
                if (dfs(nums, i, sum * i / len, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int[] A, int n, int targetSum, int startIndex) {
        if (targetSum == 0 && n == 0) {
            return true;
        }
        if (n != 0) {
            for (int i = startIndex; i < A.length; i++) {
                if (i > startIndex && A[i] == A[i - 1]) {
                    continue;
                }
                if (dfs(A, n - 1, targetSum - A[i], i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
