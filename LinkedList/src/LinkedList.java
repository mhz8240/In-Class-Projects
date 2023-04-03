
public class LinkedList {
	Node head;
	private int size;
	public LinkedList() {
		head = null;
		size = 0;
	}
	public void add(Node n) {
		if (size == 0) {
			head = n;
			size++;
			return;
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = n;
		size++;
	}
	public Node remove(int n) {
		if (n == 0) {
			Node next = head.next;
			head.next = null;
			head = next;
		}
		Node prev = head;
		Node current = head.next;
		int count = 0;
		while (count < n-1) {
			if (current == null) {
				return null;
			}
			prev = current.next;
			current = current.next;
			count++;
		}
		Node temp = current.next;
		current.next = null;
		prev.next = temp;
		return current;
	}
	public Node get(int index) {
		int count = 0;
		Node current = head;
		while (count < index) {
			if (current == null) {
				return null;
			}
			current = current.next;
			count++;
		}
		return current;
	}
	public int size() {
		return size;
	}
	public String toString() {
		String s = "[";
		Node current = head;
		while (current != null) {
			s += current.getData();
			if (current.next != null) {
				s += ", ";
			}
			current = current.next;
		}
		s += "]";
		return s;
	}
}
