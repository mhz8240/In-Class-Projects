
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vals = {1,3,5,7};
//		try {
//			double result = average(vals);
//		}
//		catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("You went out of bounds");
//			e.printStackTrace();
//		}
		try {
			test();
		}
		catch(Test e) {
			e.printStackTrace();
		}
		
	}
	public static double average(int[] vals) {
		double avg = 0;
		int sum = 0;
		for (int i = 0; i <= vals.length; i++) {
			sum += vals[i];
		}
		avg = (double)(sum) / vals.length;
		return avg;
	}
	public static void test() throws Test {
		throw new Test();
	}

}
