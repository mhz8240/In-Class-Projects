import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringInts {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("ints.txt");
		Scanner scanner = new Scanner(file);
		int sum = 0;
		int length = 0;
		int num = 0;
		// read the data values
		while (scanner.hasNextLine()) {
			num = scanner.nextInt();
			sum += num;
			length++; 
		}
		// print out the average
		System.out.println((double)(sum)/length);
	}

}
