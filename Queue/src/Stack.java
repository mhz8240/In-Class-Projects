import java.util.ArrayList;

public class Stack<T> {
	ArrayList<T> data;
	public Stack() {
		data = new ArrayList<T>();
	}
	public void push(T t) {
		data.add(t);
	}
	public T pop() {
		T t = data.get(size()-1);
		data.remove(size()-1);
		return t;
	}
	public T peek() {
		T t = data.get(size()-1);
		return t;
	}
	public int size() {
		return data.size();
	}
	public boolean empty() {
		return data.size() == 0;
	}
}
