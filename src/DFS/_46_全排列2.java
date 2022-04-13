package DFS;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @auther adam
 * @date 2022/2/17
 * @apiNote DFS
 */
public class _46_全排列2 {
    private List<List<Integer>> list;
    private int[] nums;
    /** 用来存储每一层存储的数字*/
    private List<Integer> result;
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        result = new ArrayList<>();
        this.nums = nums;
        dfs(0);

        return list;
    }

    private void dfs(int idx) {
        if (idx == nums.length) {
            // 已经进入到最后一层了不能再深入了
            // 得到一个正确的解
            list.add(new ArrayList<>(result));
            return;
        }
        for (int num : nums) {
            if (result.contains(num)) continue;
            result.add(idx, num);
            dfs(idx + 1);
            result.remove(result.size() - 1);
        }
    }

}
