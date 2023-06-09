
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
			head.prev = null;
			size++;
			return;
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = n;
		n.prev = curr;
		size++;
	}
	public Node remove(int n) {
		if (n == 0) {
			Node next = head.next;
			head.next = null;
			head = next;
			next.prev = null;
		}
		Node prev = head;
		Node current = head.next;
		int count = 0;
		while (count < n-1) {
			if (current == null) {
				return null;
			}
			prev = prev.next;
			current = current.next;
			count++;
		}
		Node temp = current.next;
		current.next = null;
		current.prev = null;
		prev.next = temp;
		temp.prev = prev;
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
