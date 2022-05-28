package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther adam
 * @date 2022/5/28
 * @apiNote 哈希表
 * https://leetcode.cn/problems/valid-sudoku/
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 *
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 */
public class _36_有效的数独 {
    /**
     * 思路2 : 使用 位运算
     * @param board 数据
     * @return 是否
     */
    public boolean isValidSudoku2(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] boxes = new short[9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num == '.') {
                    continue;
                }
                num = (char) (1 << (num - '1'));
                if ((rows[row] & num) != 0) {
                    return false;
                }
                if ((cols[col] & num) != 0) {
                    return false;
                }
                int boxIdx = (row / 3) * 3 + col / 3;
                if ((boxes[boxIdx] & num) != 0) {
                    return false;
                }

                rows[row] |= num;
                cols[col] |= num;
                boxes[boxIdx] |= num;
            }
        }
        return true;
    }
    /**
     * 思路2 : 使用 boolean数组
     * @param board 数据
     * @return 是否
     */
    public boolean isValidSudoku1(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num == '.') {
                    continue;
                }
                num -= '1';
                if (rows[row][num]) {
                    return false;
                }
                if (cols[col][num]) {
                    return false;
                }
                int boxIdx = (row / 3) * 3 + col / 3;
                if (boxes[boxIdx][num]) {
                    return false;
                }

                rows[row][num] = true;
                cols[col][num] = true;
                boxes[boxIdx][num] = true;
            }
        }
        return true;
    }
    /**
     * 思路1 : 使用 HashSet
     * @param board 数据
     * @return 是否
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] boxes = new Set[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
//            char[] cols = board[row];
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num == '.') {
                    continue;
                }
                if (rows[row].contains(num)) {
                    return false;
                }
                if (cols[col].contains(num)) {
                    return false;
                }
                int boxIdx = (row / 3) * 3 + col / 3;
                if (boxes[boxIdx].contains(num)) {
                    return false;
                }

                rows[row].add(num);
                cols[col].add(num);
                boxes[boxIdx].add(num);

            }
        }
        return true;
    }
}
