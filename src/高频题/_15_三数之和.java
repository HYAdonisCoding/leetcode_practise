package 高频题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** https://leetcode-cn.com/problems/3sum/
 * @auther adam
 * @date 2022/2/21
 * @apiNote 高频题
 */
public class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;
        /// 排序
        Arrays.sort(nums);
        // i 用来扫描三元猪的第一个元素
        int lastIndex = nums.length - 3;
        int lastR = nums.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;;
            int l = i + 1, r = lastR, remain =  -nums[i];
            while (l < r) {
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain) { /// 找到了符合条件的三元组
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                   // 跳过相同的值 去重
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    // 往中间移动
                    l++;
                    r--;
                } else if (sumLr < remain) {
                    l++;
                } else {// sumLr > remain
                    r--;
                }
            }
        }
        return list;
    }
}
