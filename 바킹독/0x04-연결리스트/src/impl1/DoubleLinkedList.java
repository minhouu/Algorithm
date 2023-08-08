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
		addr.pre.nxt = neo;
		neo.pre = addr.pre;
		addr.pre = neo;
		neo.nxt = addr;
		
	}

	public void delete(DoubleLinkedList addr) {
		addr.pre.nxt = addr.nxt;
	}
}
