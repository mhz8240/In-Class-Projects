package src;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Static variables can be accessed without an object.
		// they are properties of the class, not the object.
		System.out.println(Person.population);
		Person a = new Person();
		Person b = new Person();
		Person c = new Person();
		System.out.println(Person.population);
		a.multiply();
		System.out.println(a.population);
		System.out.println(b.population);
		System.out.println(c.population);
		System.out.println(Person.population);
	}

}
