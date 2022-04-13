package DFS;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode-cn.com/problems/generate-parentheses/
 * @auther adam
 * @date 2022/2/18
 * @apiNote DFS
 */
public class _22_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) {
            return list;
        }
        dfs(0, n, n, new char[n << 1], list);
        return list;

    }

    /**
    * @Description:
    * @Param:  idx 搜索的层号
     * leftRemain 左括号剩余数量
     * rightRemain 右括号剩余数量
     * string 搜索的层号
     * list 搜索的层号
    */
    private void dfs(int idx, int leftRemain, int rightRemain, char[] string, List<String> list) {
        if (idx == string.length) {
            list.add(new String(string));
            return;
        }
        /// 枚举这一层所有可能的选择
        // 选择一种可能后进入下一层搜索
//        什么情况下可以选择左括号？
//     *      （左括号数量 > 0）
        // 选择左括号
        if (leftRemain > 0) {
            string[idx] = '(';
            dfs(idx + 1, leftRemain - 1, rightRemain, string, list);
        }

//        什么情况下可以选择右括号？
//     *      （右括号数量 > 0）&& (右括号的数量 != 左括号的数量)
        // 选择右括号
        if (rightRemain > 0 && leftRemain != rightRemain) {
            string[idx] = ')';
            dfs(idx + 1, leftRemain, rightRemain - 1, string, list);
        }

    }

    /**
     * 当左括号 右括号一样时，只能选择左括号
     *  什么情况下可以选择左括号？
     *      （左括号数量 > 0）
     *  什么情况下可以选择右括号？
     *      （右括号数量 > 0）&& (右括号的数量 != 左括号的数量)
     */

    public static void main(String[] args) {
        _22_括号生成 o = new _22_括号生成();
        System.out.println(o.generateParenthesis(3));
    }
}
