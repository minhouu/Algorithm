package impl1;

public class DoubleLinkedList {
	int val;
	DoubleLinkedList nxt;
	DoubleLinkedList pre;

	public DoubleLinkedList(int val) {
		this.val = val;
	}

	public void traverse() {
		DoubleLinkedList cur = this.nxt;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.nxt;
		}
	}

	public void insert(DoubleLinkedList addr, DoubleLinkedList neo) {
		// neo �յڷ� ����
		neo.pre = addr;
		neo.nxt = addr.nxt;

		// addr�� nxt�� �����ϸ�
		// addr.nxt�� pre�� �� dll�� �ȴ�
		if (addr.nxt != null)
			addr.nxt.pre = neo;

		// addr�� nxt�� neo
		addr.nxt = neo;

	}

	public void delete(DoubleLinkedList addr) {
		addr.pre.nxt = addr.nxt;
	}
}
