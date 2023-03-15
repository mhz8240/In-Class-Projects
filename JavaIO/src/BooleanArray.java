import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BooleanArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("boolean.txt");
		Scanner scanner = new Scanner(file);
		//Create an arraylist of strings to store the lines
		ArrayList<String> strings = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			strings.add(line);
		}
		int rows = strings.size();
		int columns = strings.get(0).length();
		//create the boolean array
		boolean[][] arr = new boolean[rows][columns];
		int row = 0;
		// loop through each char in strings and add true or false in the boolean array accordingly
		for (String s : strings) {
			for (int i = 0; i < columns; i++) {
				int num = Integer.parseInt(s.substring(i,i+1));
				if (num == 1) {
					arr[row][i] = true;
				}
				if (num == 0) {
					arr[row][i] = false;
				}
			}
			row++;
		}
		// print out the boolean array
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
