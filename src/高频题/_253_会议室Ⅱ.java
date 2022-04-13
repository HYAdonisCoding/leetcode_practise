package 高频题;

import java.util.Arrays;
import java.util.PriorityQueue;

/** https://leetcode-cn.com/problems/meeting-rooms-ii/  VIP
 * @auther adam
 * @date 2022/2/21
 * @apiNote 高频题
 */
public class _253_会议室Ⅱ {
    /** 给定一个会议时间安排的数组，每个会议时间都包括开始和结束的时间
     * [[s1, e1], [s2, e2]....](si< ei)，为避免会议冲突，同时要考虑充分理由会议室资源，
     * 请你计算至少需要多少间会议室，才能满足这些会议安排。
     * 输入：[[0, 30], [5, 10], [15, 20]]
     * 输出：2
     * 输入：[[7, 10], [2, 4]]
     * 输出：1
     * @Description:
     * @Param:
     * @return:
     * @Author: Adam
     * @Date: 2022/2/21
     */
    // 分开排序
    public int minMettingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 存放所有的开始时间 结束时间
        int[] begins = new int[intervals.length], ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 按照开始时间, 结束，从小到大排序
        Arrays.sort(begins);
        Arrays.sort(ends);
        
        int room = 0, endIdx = 0;
        for (int begin: begins) {
            if (begin >= ends[endIdx]) {
                // 能重复利用会议室
                endIdx++;
            } else {
                // 需要新开一个会议室
                room++;
            }
        }

        return room;
    }
    // 最小堆
    public int minMettingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照会议的开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
        // 创建一个最小堆（存放每一个会议结束时间）
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 添加0号位置的结束时间
        heap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // i号会议的开始时间 >= 堆顶（目前占用的会议室中最早奇数的时间）
            if (intervals[i][0] >= heap.peek()) {
                heap.remove();
            }
            // 将i号会议的结束时间 加入堆中
            heap.add(intervals[i][1]);
        }
        return heap.size();
    }

    public static void main(String[] args) {
        _253_会议室Ⅱ o = new _253_会议室Ⅱ();
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(o.minMettingRooms(intervals));
        intervals = new int[][]{{7, 10}, {2, 4}};
        System.out.println(o.minMettingRooms(intervals));
    }
}
