package 高频题;

import java.util.Arrays;

/** https://leetcode-cn.com/problems/meeting-rooms/ VIP
 * @auther adam
 * @date 2022/2/21
 * @apiNote 高频题
 */
public class _252_会议室 {
    /** 给定一个会议时间安排的数组，每个会议时间都包括开始和结束的时间
     * [[s1, e1], [s2, e2]....](si< ei)，请你判断一个人是否能够参加这里面的全部会议。
     * 输入：[[0, 30], [5, 10], [15, 20]]
     * 输出：false
     * 输入：[[7, 10], [2, 4]]
     * 输出：true
    * @Description:
    * @Param:
    * @return:
    * @Author: Adam
    * @Date: 2022/2/21
    */
    public boolean canAttendMettings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        // 按照会议的开始时间，从小到大排序
//        Arrays.sort(intervals, (m1, m2) -> {
//            return m1[0] - m2[0];
//        });
        // 简写
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
        // 遍历每一个会议
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _252_会议室 o = new _252_会议室();
        int[][] intervals;
        intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(o.canAttendMettings(intervals));
        intervals = new int[][]{{7, 10}, {2, 4}};
        System.out.println(o.canAttendMettings(intervals));
    }
}
