
public class Node<T> {
	private T data;
	Node next;
	Node prev;
	public Node(T data) {
		this.data = data;
		next = null;
		prev = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
