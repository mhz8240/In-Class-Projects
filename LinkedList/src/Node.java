
public class Node<T> {
	private T data;
	Node next;
	public Node(T data) {
		this.data = data;
		next = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
