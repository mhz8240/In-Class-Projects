import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NumberofFemales {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("Popular_Baby_Names.csv");
		Scanner scanner = new Scanner(file);
		int count = 0;
		while (scanner.hasNextLine()) {
			String data = scanner.nextLine();
			String s = data.substring(5,11);
			if (s.equals("FEMALE")) {
				count++;
			}
		}
		System.out.println(count);
	}

}
