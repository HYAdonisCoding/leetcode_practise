package 高频题;

/** https://leetcode-cn.com/problems/trapping-rain-water/
 * @auther adam
 * @date 2022/2/22
 * @apiNote 高频题
 */
public class _42_接雨水 {
    // 精简1 空间复杂度O（1）， 时间复杂度O（n）
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int water = 0, l = 0, r = height.length - 1, lowerMax = 0;

        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            // 目前为止最大的lower
            lowerMax = Math.max(lowerMax, lower);
            water += lowerMax - lower;
        }
        return water;
    }
    // 精简
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int water = 0, lastIdx = height.length - 2, leftMax = 0;

        int[] rightMaxes = new int[height.length];
        for (int i = lastIdx; i >= 1; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i + 1]);
        }
        for (int i = 1; i <= lastIdx; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            // 求出左边最大， 右边最小的较小者
            int min = Math.min(leftMax, rightMaxes[i]);
            if (min <= height[i]) continue;
            // 说明这根柱子能放水
            water += min - height[i];
        }

        return water;
    }
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int water = 0, lastIdx = height.length - 2;
        int[] leftMaxes = new int[height.length];
        for (int i = 1; i <= lastIdx; i++) {
            leftMaxes[i] = Math.max(leftMaxes[i - 1], height[i - 1]);
        }
        int[] rightMaxes = new int[height.length];
        for (int i = lastIdx; i >= 1; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i + 1]);
        }
        for (int i = 1; i <= lastIdx; i++) {
            // 求出左边最大， 右边最小的较小者
            int min = Math.min(leftMaxes[i], rightMaxes[i]);
            if (min <= height[i]) continue;
            // 说明这根柱子能放水
            water += min - height[i];
        }

        return water;
    }
}
