import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StringDouble {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("stringDouble.txt");
		Scanner scanner = new Scanner(file);
		double sum = 0.0;
		int length = 0;
		double num = 0.0;
		// loop through the strings, and only take substring that contains the data value. Then, parse that to a double.
		while (scanner.hasNextLine()) {
			String s = "";
			String data = scanner.nextLine();
			for (int i = 0; i < data.length(); i++) {
				if (data.charAt(i) == ' ') {
					s = data.substring(i+1);
				}
			}
			num = Double.parseDouble(s);
			sum += num;
			length++;
		}
		// print out the average
		System.out.println(sum/length);
	}

}
