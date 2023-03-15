import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class intStringDouble {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("intStringDouble.txt");
		Scanner scanner = new Scanner(file);
		//set up sum and num variables for both columns
		double lastSum = 0.0;
		double lastNum = 0.0;
		int firstSum = 0; 
		int firstNum = 0;
		int length = 0;
		// loop through the strings, and only take substrings that contain the data values.
		while (scanner.hasNextLine()) {
			String s = "";
			String data = scanner.nextLine();
			firstNum = Integer.parseInt(data.substring(0,1));
			for (int i = 0; i < data.length(); i++) {
				if (data.charAt(i) == ' ') {
					s = data.substring(i+1);
				}
			}
			lastNum = Double.parseDouble(s);
			lastSum += lastNum;
			firstSum += firstNum;
			length++;
		}
		// print out the average for each column
		System.out.println("First column: " + (double)(firstSum)/length);
		System.out.println("Last column: " + (double)(lastSum)/length);
	}

}
