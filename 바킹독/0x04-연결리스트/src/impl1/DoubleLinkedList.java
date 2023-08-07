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
		// neo 앞뒤로 연결
		neo.pre = addr;
		neo.nxt = addr.nxt;

		// addr의 nxt가 존재하면
		// addr.nxt의 pre는 새 dll이 된다
		if (addr.nxt != null)
			addr.nxt.pre = neo;

		// addr의 nxt는 neo
		addr.nxt = neo;

	}

	public void delete(DoubleLinkedList addr) {
		addr.pre.nxt = addr.nxt;
	}
}
