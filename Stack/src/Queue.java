import java.util.ArrayList;

public class Queue<T> {
	ArrayList<T> data;
	public Queue() {
		data = new ArrayList<T>();
	}
	public void add(T t) {
		data.add(t);
	}
	public T remove() {
		T t = data.get(0);
		data.remove(0);
		return t;
	}
	public int size() {
		return data.size();
	}
	public T peek() {
		T t = data.get(0);
		return t;
	}
	public boolean empty() {
		return data.size() == 0;
	}
}
