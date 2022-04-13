package DFS;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @auther adam
 * @date 2022/2/17
 * @apiNote DFS
 */
public class _17_电话号码的字母组合 {
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},
    };
    private char[] chars;
    /** 用来存储每一层存储的字母*/
    private char[] string;
    private List<String> list;
    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        list = new ArrayList<>();
        chars = digits.toCharArray();

        if (chars.length == 0) return  list;
        string = new char[chars.length];
        dfs(0);
        return list;
    }

    /** 深度优先搜索
    * 正在搜索第i层
    * @Param:  i
    */
    private void dfs(int i) {
        if (i == chars.length) {
            // 已经进入到最后一层了不能再深入了
            // 得到一个正确的解
            list.add(new String(string));
            return;
        }
        /// 先枚举这一层可以做的索引选择
        char[] letters = lettersArray[chars[i] - '2'];
        for (char letter: letters) {
            string[i] = letter;
            dfs(i + 1);
        }
    }
}
