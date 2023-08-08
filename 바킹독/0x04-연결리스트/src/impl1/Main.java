package impl1;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedList nodeStart = new DoubleLinkedList(-1);
 		DoubleLinkedList node1 = new DoubleLinkedList(1);
		DoubleLinkedList node2 = new DoubleLinkedList(2);
		DoubleLinkedList node3 = new DoubleLinkedList(3);
		
		nodeStart.nxt = node1;
		
		node1.nxt = node2;
		node2.pre = node1;
		
		node2.nxt = node3;
		node3.pre = node2;
		
		nodeStart.traverse();
		DoubleLinkedList neo = new DoubleLinkedList(10);
		nodeStart.insert(node2, neo);
		nodeStart.traverse();
		
		nodeStart.delete(node3);
		nodeStart.traverse(); 
		
	}

}
