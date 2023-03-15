
public class Queue<T> {
		private Stack<T> push;
	    private Stack<T> pop;
	    /* to be completed */
	    //constructor
	    public Queue() {
	        push = new Stack<T>();
	        pop = new Stack<T>();
	    }

	    //remove and return the element at the beginning of the list
	    public T remove(){
	        while (!empty()) {
	            pop.push(push.pop());
	        }
	        T t = (T)pop.pop();
	        while(!pop.empty()) {
	            push.push(pop.pop());
	        }
	        return t;
	    }


	    //add element at the end of the list
	    public void add(T el){
	      /* to be completed */
	      push.push(el);

	    }

	    //return a String representation of the list
	    //formatted as [el1, el2, el3, ..., elN]
	    public String toString(){
	        Stack<T> temp = new Stack<>();
	        String s = "[";
	        while (size() > 1) {
	            T t = remove();
	            s += t + ", ";
	            temp.push(t);
	        }
	        T last = (T)remove();
	        temp.push(last);
	        s += last + "]";
	        push = temp;
	        return s;
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
	    public T peek() {
	        while (!empty()) {
	            pop.push(push.pop());
	        }
	        T t = (T)pop.peek();
	        while(!pop.empty()) {
	            push.push(pop.pop());
	        }
	        return t; 
	    }

}
