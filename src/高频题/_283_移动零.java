package 高频题;

/** https://leetcode-cn.com/problems/move-zeroes/
 * @auther adam
 * @date 2022/2/18
 * @apiNote 高频题
 */
public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0, cur = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (cur != i) {
                nums[cur] = nums[i];
                nums[i] = 0;
            }
            cur++;
        }

    }
}
