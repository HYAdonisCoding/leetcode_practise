package 链表;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return val + ",  " + next;
//		return "ListNode [val=" + val + ", next=" + next + "]";
	}
}
