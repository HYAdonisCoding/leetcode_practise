package DFS;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @auther adam
 * @date 2022/2/17
 * @apiNote DFS
 */
public class _46_全排列3 {
    public List<List<Integer>> permute(int[] nums) {
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
            swap(nums, idx, i);
            dfs(idx + 1, nums, list);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
