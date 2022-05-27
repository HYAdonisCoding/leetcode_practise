package 堆;

import javax.swing.*;
import java.util.*;

/**
 * @auther adam
 * @date 2022/5/27
 * @apiNote 堆
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 */
public class _347_前K个高频元素 {
    /**
     * 思路3 ：桶排序
     * @param nums 数组
     * @param k 前k个
     * @return 频次最高数组
     */
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> frequents = new HashMap<>();
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((Map.Entry<Integer, Integer> i1, Map.Entry<Integer, Integer> i2) -> {
            return i1.getValue() - i2.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : frequents.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (entry.getValue() > queue.peek().getValue()) {
                queue.poll();
                queue.offer(entry);
            }

        }
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    /**
     * 思路2 ：PriorityQueue 写法2
     * @param nums 数组
     * @param k 前k个
     * @return 频次最高数组
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequents = new HashMap<>();
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((Map.Entry<Integer, Integer> i1, Map.Entry<Integer, Integer> i2) -> {
            return i1.getValue() - i2.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : frequents.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (entry.getValue() > queue.peek().getValue()) {
                queue.poll();
                queue.offer(entry);
            }

        }
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    /**
     * 思路2 ：PriorityQueue 写法1
     * @param nums 数组
     * @param k 前k个
     * @return 频次最高数组
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> frequents = new HashMap<>();
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer i1, Integer i2) -> {
            return frequents.get(i2) - frequents.get(i1);
        });
        for (Integer num : frequents.keySet()) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (frequents.get(num) > frequents.get(queue.peek())) {
                queue.poll();
                queue.offer(num);
            }

        }
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(0, queue.poll());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 思路1 ：全排序
     * @param nums 数组
     * @param k 前k个
     * @return 频次最高数组
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequents = new HashMap<>();
        for (int num : nums) {
            frequents.put(num, frequents.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer>[] entries = new Map.Entry[frequents.size()];
        frequents.entrySet().toArray(entries);
        Arrays.sort(entries, (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> {
            return e2.getValue() - e1.getValue();
        });
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = entries[i].getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        _347_前K个高频元素 o = new _347_前K个高频元素();
        int[] r = o.topKFrequent(nums, 2);
        System.out.println(r.toString());
    }
}
