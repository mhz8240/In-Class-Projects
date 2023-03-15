
public class Stack<T> {
	private Queue<T> push;
	private Queue<T> pop;
	public Stack() {
		push = new Queue<T>();
		pop = new Queue<T>();
	}
	public void add(T t) {
		push.add(t);
	}
	public T remove() {
		 Queue<T> temp = new Queue<>();
		 while (size() > 1) {
			 temp.add(push.remove());
		 }
		 T t = push.remove();
		 push = temp;
		 return t;
		
	}
	public T peek() {
		 Queue<T> temp = new Queue<>();
		 while (size() > 1) {
			 temp.add(push.remove());
		 }
		 T t = push.remove();
		 temp.add(t);
		 push = temp;
		 return t;
		
	}
	 public int size(){
	      return push.size();
	    }
	
	 public boolean empty() {
	        if (size() == 0) {
	            return true;
	        }
	        return false;
	 }
}
