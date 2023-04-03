
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		
		l.add(a);
		l.add(b);
		l.add(c);
		System.out.println(l.remove(1));
		System.out.println("hello");
		System.out.println(l);
		
	}

}
