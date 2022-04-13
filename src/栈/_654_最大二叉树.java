package 栈;

import java.util.Arrays;
import java.util.Stack;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 
 * @author adam
 *
 */
public class _654_最大二叉树 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null) {
			return null;
		}
		return findRoot(nums, 0, nums.length);
	}

	/**
	 * 找出[l,r)范围内的根节点
	 * 
	 * @param nums
	 * @param l
	 * @param r
	 * @return
	 */
	private TreeNode findRoot(int[] nums, int l, int r) {
		if (l == r) {
			return null;
		}
		int maxIdx = l;
		// 找出[l,r)范围内的最大值
		for (int i = l + 1; i < r; i++) {
			if (nums[i] > nums[maxIdx]) {
				maxIdx = i;
			}
		}
		TreeNode root = new TreeNode(nums[maxIdx]);
		root.left = findRoot(nums, l, maxIdx);
		root.right = findRoot(nums, maxIdx + 1, r);
		return root;
	}

	/**
	 * 1.扫描一遍所有元素 2.保持栈从栈底到栈顶是单调递减的
	 * 
	 * @param nums
	 * @return
	 */
	public int[] parentIndexes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int[] lis = new int[nums.length];
		int[] ris = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			ris[i] = -1;
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				ris[stack.pop()] = i;
			}
			lis[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
//		System.out.println(Arrays.toString(lis));
//		System.out.println(Arrays.toString(ris));
		int[] pis = new int[nums.length];

		for (int i = 0; i < pis.length; i++) {
			if (lis[i] == -1 && ris[i] == -1) {
				// 根节点
				pis[i] = -1;
				continue;
			}
			if (lis[i] == -1) {
				pis[i] = ris[i];
			} else if (ris[i] == -1) {
				pis[i] = lis[i];
			} else if (nums[lis[i]] < nums[ris[i]]) {
				pis[i] = lis[i];
			} else {
				pis[i] = ris[i];
			}
		}
		return pis;
	}

	/**
	 * * * @param args
	 */
	public static void main(String[] args) {
		// 0 1 2 3 4 5
		// 3 2 1 6 0 5
		// 3 0 1 -1 5 3
		_654_最大二叉树 o = new _654_最大二叉树();
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		int[] ris = o.parentIndexes(nums);
		System.out.println(Arrays.toString(ris));
	}
}
