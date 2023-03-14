
public class Person {
	public static int population = 0;
	private String name;
	private boolean isFunny;
	private int netWorth;
	public Person() {
		name = "Daniel";
		isFunny = false;
		netWorth = 10;
		population++;
	}
	public void multiply() {
		population++;
	}
	public static void mystery2() {
		System.out.println("2nd static method");
	}
	//instance methods can call static methods
	//static methods can not call instance methods
	//instance methods must be associated with an object
}
