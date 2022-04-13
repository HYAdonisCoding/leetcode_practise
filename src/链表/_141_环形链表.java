package 链表;

//https://leetcode-cn.com/problems/linked-list-cycle/
public class _141_环形链表 {
	// [-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5]
	// -1
	// 错误
	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			if (fast == slow) {
				return true;
			}
			System.out.println(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] data = { 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23,
				-21, 5 };
		ListNode head = new ListNode(-21);
		ListNode tmpListNode = head;
		for (int i = 0; i < data.length; i++) {

			tmpListNode.next = new ListNode(data[i]);
		}

		System.out.println(hasCycle(head));
	}
}
