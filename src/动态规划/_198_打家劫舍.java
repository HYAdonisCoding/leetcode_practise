package 动态规划;

import com.sun.source.tree.IfTree;

/**
 * @auther adam
 * @date 2022/5/27
 * @apiNote 动态规划
 * https://leetcode.cn/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 */
public class _198_打家劫舍 {
    /**
     * 思路 4：   非递归 两个整形变量
     * 空间复杂度O(1)   时间复杂度都是：O(n)
     * 利用数组存放前 n 个房屋的最高偷窃金额
     * @param nums 数组
     * @return 最高金额
     */
    public int rob4(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int first = 0;
        int second = 0;
        for (int num: nums) {
            int tmp = second;
            second = Math.max(num + first, second);
            first = tmp;
        }
        return second;
    }
    /**
     * 思路 4：   非递归 两个整形变量
     * 空间复杂度O(1)   时间复杂度都是：O(n)
     * 利用数组存放前 n 个房屋的最高偷窃金额
     * @param nums 数组
     * @return 最高金额
     */
    public int rob3(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(nums[i] + first, second);
            first = tmp;
        }
        return second;
    }
    /**
     * 思路 3：   非递归
     * 空间复杂度、时间复杂度都是：O(n)
     * 利用数组存放前 n 个房屋的最高偷窃金额
     * @param nums 数组
     * @return 最高金额
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] array = new int[nums.length];
        array[0] = nums[0];
        array[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            array[i] = Math.max(nums[i] + array[i-2], array[i-1]);
        }

        return array[array.length-1];
    }
    /**
     * 思路 2：    递归  从后往前 时间复杂度是：O(2^n) ，空间复杂度是：O(n)
     * @param nums 数组
     * @return 最高金额
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        return rob1(nums, nums.length - 1);
    }
    public int rob1(int[] nums, int begin) {
        if (begin == 0) {
            return nums[begin];
        }
        if (begin == 1) {
            return Math.max(nums[0], nums[1]);
        }
        int cur = nums[begin] + rob1(nums, begin - 2);
        int next = rob1(nums, begin - 1);
        return Math.max(cur, next);
    }

    /**
     * 思路 1：    递归  从前往后 时间复杂度是：O(2^n) ，空间复杂度是：O(n)
     * @param nums 数组
     * @return 最高金额
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        return rob(nums, 0);
    }
    public int rob(int[] nums, int begin) {
        if (begin == nums.length - 1) {
            return nums[begin];
        }
        if (begin == nums.length - 2) {
            return Math.max(nums[begin], nums[begin + 1]);
        }
        int cur = nums[begin] + rob(nums, begin + 2);
        int next = rob(nums, begin + 1);
        return Math.max(cur, next);
    }

}
