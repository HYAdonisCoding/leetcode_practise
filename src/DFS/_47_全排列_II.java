package DFS;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/permutations-ii/
 * @auther adam
 * @date 2022/2/17
 * @apiNote DFS
 */
public class _47_全排列_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;

        dfs(0, nums, list);

        return list;
    }
    private void dfs(int idx, int[] nums, List<List<Integer>> list) {
        if (idx == nums.length) {
            // 已经进入到最后一层了不能再深入了
            // 得到一个正确的解
            List<Integer> resultList = new ArrayList<>();
            for (int value: nums) {
                resultList.add(value);
            }

            list.add(resultList);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (isRepeat(nums, idx, i)) continue;
            swap(nums, idx, i);
            dfs(idx + 1, nums, list);
            swap(nums, i, idx);
        }
    }

    private boolean isRepeat(int[] nums, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        _47_全排列_II o = new _47_全排列_II();
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = o.permuteUnique(nums);
        System.out.println(list);

        nums = new int[] {1, 1, 2};
        list = o.permuteUnique(nums);
        System.out.println(list);
    }
}
