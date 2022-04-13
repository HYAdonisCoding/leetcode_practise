package 高频题;

import java.util.HashMap;
import java.util.Map;

/** https://leetcode-cn.com/problems/two-sum/
 * @auther adam
 * @date 2022/2/18
 * @apiNote 高频题
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) return  new int[] {idx, i};
            map.put(nums[i], i);
        }
        return result;
    }
}
