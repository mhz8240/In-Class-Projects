import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//command switches
		boolean stack = false;
		boolean queue = false;
		boolean opt = false;
		boolean time = false;
		boolean incoordinate = false;
		boolean outcoordinate = false;
		boolean help = false;
		//read command switches
		for (int i = 0; i < args.length-1; i++) {
//			try {
			switch(args[i]) {
			case "--Stack": 
//				if (queue || opt) {
//					throw new UserException("IllegalCommandLineInputsException");
//				}
				stack = true;
				break;
			case "--Queue":
//				if (stack || opt) {
//					throw new UserException("IllegalCommandLineInputsException");
//				}
				queue = true;
				break;
			case "--Opt":
//				if (stack || queue) {
//					throw new UserException("IllegalCommandLineInputsException");
//				}
				opt = true;
				break;
			case "--Time":
				
				time = true;
				break;
			case "--Incoordinate":
				
				incoordinate = true;
				break;
			case "--Outcoordinate":
				
				outcoordinate = true;
				break;
			case "--Help":
				help = true;
				break;
			}
			}
//			catch(UserException e) {
//				System.out.println(e.getMessage());
//				System.exit(-1);
//			}
			
//		}
		if (help) {
			System.out.println("This program finds a valid path which guides the wolverine to the wolverine buck.\n" +
		"It takes in command line switches, which include: --stack, --queue, --opt, --help, --time, --incoordinate, and --outcoordinate.\n" +
					" Only one of the stack, queue, and opt switches can be on, and that determines the approach for finding the path.\n" + 
		" If the incoordinate switch is on, then the input is in coordinate form. Otherwise, it is in map form. Same thing applies for outcoordinate.\n" +
					"If the time switch is on, then the runtime is printed.");
					
			System.exit(0);
		}
		
		//check for command switch errors
		try {
		if (!(stack || queue || opt)) {
			throw new UserException("IllegalCommandLineInputsException");
		}
		
		}
		catch(UserException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
//		FileWriter fw = new FileWriter("DesignPlan.txt");
////		fw.write("3 3 1\n" + "W..\n" + "|..\n" + "$@.");
//		fw.write(args[args.length-1]);
//		File file = new File("DesignPlan.txt");
//		fw.close();
//		Scanner scanner = new Scanner(file);
		File file = new File(args[args.length-1]);
		Scanner scanner = new Scanner(file);
		
		
		
		int rows = 0;
		int columns = 0;
		int mazes = 0;
		// check for map format exception
		try {
			rows = scanner.nextInt();
			
			columns = scanner.nextInt();
			mazes = scanner.nextInt();
		}
		catch (Exception e) {
			UserException ue = new UserException("IncorrectMapFormatException");
			System.out.println(ue.getMessage());
			System.exit(-1);
		}
		//this array represents the individual maze
		String[][] arr = new String[rows][columns];
		//the big arrays are for outputing
		//bigCoor is for outputing for outcoordinate format
		ArrayList<String> bigCoor = new ArrayList<>();
		//bigArr is for outputing in map format
		String[][] bigArr = new String[rows*mazes][columns];
		boolean[][] visited = new boolean[rows][columns];
		String valid = "";
		boolean found = false;
		//queue based implementation
		
		double runTime = 0;
		//newRow, newCol, and newS are for the incoordinate case only
		int newRow = -1;
		int newCol = -1;
		String newS = "";
		//loop through each maze
		scanner.nextLine();
			for (int i = 0; i < mazes; i++) {
				Queue<Node> q = new LinkedList<>();
				Stack<Node> st = new Stack<>();
				ArrayList<String> coor = new ArrayList<>();
				// here check if it's incoor or not
				if (!incoordinate) {
				for (int j = 0; j < rows; j++) {
					String line = scanner.nextLine();
					for (int k = 0; k < columns; k++) {
						String s = "";
						//check for incompletemapexception
						try {
							s = line.substring(k, k+1);
						}
						catch(Exception e) {
							UserException ue = new UserException("IncompleteMapException");
							System.out.println(ue.getMessage());
							System.exit(-1);
						}
						//check if input is valid, otherwise produce illegalmapcharacterexception
						try {
						if (s.equals("W")) {
							Node n = new Node(j,k,s);
							visited[j][k] = true;
							if (queue || opt) {
								q.add(n);
							}				
							if (stack) {
								st.add(n);
							}
							
							
						}
						else if (!(s.equals("@") || s.equals(".") || s.equals("|") || s.equals("$"))) {
							throw new UserException("IllegalMapCharacterException");
						}
						arr[j][k] = s;
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
							System.exit(-1);
						}
//						
					}
				}
				}
				//prevRow and prevCol are only for incoordinate case. 
				int prevRow = newRow;
				int prevCol = newCol;
				if (incoordinate) {
					// reset the maze
					arr = new String[rows][columns];
					// add the first element to the new maze because we broke out of the previous maze
					if (i > 0) {
						try {
						if (newS.equals("W")) {
							Node n = new Node(prevRow, prevCol, newS);
							visited[prevRow][prevCol] = true;
							if (queue || opt) {
								q.add(n);
							}				
							if (stack) {
								st.add(n);
							}
							
						}
						else if (!(newS.equals("@") || newS.equals(".") || newS.equals("|") || newS.equals("$"))) {
							throw new UserException("IllegalMapCharacterException");
						}
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
							System.exit(-1);
						}
						arr[prevRow][prevCol] = newS;
					}
						while (scanner.hasNext()) {
							
							String s = scanner.next();
							int j = scanner.nextInt();
							int k = scanner.nextInt();
							// check for map format exception
							try {
								if (j >= rows || k >= columns) {
									throw new UserException("IncorrectMapFormatException");
									
								}
							}
							catch (UserException e) {
								System.out.println(e.getMessage());
								System.exit(-1);
							}
							// compare to prevRow/prevCol. 
							//if it's in a lower row/column, then that marks the start of a new maze, so break out of the loop
							if (!(i==mazes-1)) {
								if (j < prevRow) {
									newRow = j;
									newCol = k;
									newS = s;
									break;
								}
								else if (j == prevRow && k <= prevCol) {
									newRow = j;
									newCol = k;
									newS = s;
									break;
								}
							}
							
							arr[j][k] = s;
							//check for valid input, otherwise throw an exception
							try {
								if (s.equals("W")) {
									Node n = new Node(j,k,s);
									visited[j][k] = true;
									if (queue || opt) {
										q.add(n);
									}				
									if (stack) {
										st.add(n);
									}
									
								}
								else if (!(s.equals("@") || s.equals(".") || s.equals("|") || s.equals("$"))) {
									throw new UserException("IllegalMapCharacterException");
								}
								arr[j][k] = s;
								}
								catch(Exception e) {
									System.out.println(e.getMessage());
									System.exit(-1);
								}
							if (scanner.hasNextLine()) {
								scanner.nextLine();
							}
							prevRow = j;
							prevCol = k;
						}
						//fill the rest of the elements with "."
						for (int j = 0; j < rows; j++) {
//							System.out.println("here");
							for (int k = 0; k < columns; k++) {
								if (arr[j][k] == null) {
									arr[j][k] = ".";
								}
							}
						}
						
				}	
				
				long initialTime = System.nanoTime();
				//find the path using the algorithm specified in the command line
				if (!found) {
					//the valid string represents whether the wolverine reaches a
					//dollar sign, walkway, or neither
					if (queue) {
						valid = checkQueue(arr, coor, rows, columns, q, outcoordinate);
					}
					
					if (stack) {
						valid = checkStack(arr, coor, rows, columns, st, outcoordinate);
					}
					
					if (opt) {
						valid = optimal(arr, coor, rows, columns, q, outcoordinate);
					}
				}
				long finalTime = System.nanoTime();
				//calculate runtime
				runTime += (finalTime - initialTime);
				//if wolverine reached the dollar sign, found is true
				if (valid.equals("$")) {
					found = true;
				}
				// if this is true, then the wolverine store is closed
				if (valid.equals("") && !found) {
					
					break;
				}
				//copy elements of arr into bigArr(map format output case)
				for (int a = 0; a < rows; a++) {
					for (int b = 0; b < columns; b++) {
						bigArr[rows*i+a][b] = arr[a][b];
					}
				}
				//copy elements of coor into bigCoor(coordinate format output case)
				for (String s : coor) {
					bigCoor.add(s);
				}
				
				
			}//end of mazes for loop
			//print results
			if (!found) {
				System.out.println("The Wolverine Store is closed.");
			}
			else {
				//print bigArr for !outcoordinate
				if (!outcoordinate) {
					for (String[] s : bigArr) {
						for (String str : s) {
							System.out.print(str);
						}
						System.out.println();
					}
				}
				//print bigCoor for outcoordinate
				else {
					for (String str : bigCoor) {
//						System.out.println("here");
						String s = str.substring(0,1);
						int row = Integer.parseInt(str.substring(2,3));
						int col = Integer.parseInt(str.substring(4,5));
						System.out.println(s + " " + row + " " + col);
					}
				}
			}
	
			if (time) {
				//System.out.println("Runtime of the program is " + runTime/1000000000 + " seconds");
			}
			

	}
	public static String checkQueue(String[][] arr, ArrayList<String> coor, int rows, int columns, Queue<Node> q, boolean outcoordinate) {
		Queue<Node> queue = q;
		boolean[][] visited = new boolean[rows][columns];
		String returnValue = "";
		//this checks if a walkway is available
		boolean walkway = false;
		Node walkwayNode = null;
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			
			if (n.s.equals("$")) {
				//call method here to guide the wolverine
				arr = guide(n, arr);
				if (outcoordinate) {
					coor = guideCoor(n, arr, coor);
				}
				returnValue = "$";
				break;
			}
					
			int row = n.row;
			int col = n.col;
			visited[row][col] = true;
			if (n.s.equals("|") && !walkway) {
				walkwayNode = n;
				walkway = true;
			}
//			if (n.s.equals(".") || n.s.equals("W")) {
				//check up node
				if (row > 0) {
					if (!arr[row-1][col].equals("@") && !visited[row-1][col]) {
						Node up = new Node(row-1, col, arr[row-1][col]);
						
							up.prev = n;
							queue.add(up);
						
						
					}
				}
				
				// check down node
				if (row < rows-1) {
					if (!arr[row+1][col].equals("@")  && !visited[row+1][col]) {
						Node down = new Node(row+1, col, arr[row+1][col]);
						
							down.prev = n;
							queue.add(down);
						
						
					}
				}
				//check right node
				if (col < columns-1) {
//					System.out.println("here");
					if (!arr[row][col+1].equals("@")  && !visited[row][col+1]) {
						Node right = new Node(row, col+1, arr[row][col+1]);
					
						right.prev = n;
						queue.add(right);
					}
				}
				//check left node
				if (col > 0) {
					if (!arr[row][col-1].equals("@")  && !visited[row][col-1]) {
						Node left = new Node(row, col-1, arr[row][col-1]);
						
						left.prev = n;
						queue.add(left);
					}
				}
//			}
			
			for (String[] s : arr) {
				for (String str : s) {
//					System.out.print(str);
				}
//				System.out.println();
			}
		}
		
		//walkway case
		if (!returnValue.equals("$") && walkway) {
			arr = guide(walkwayNode, arr);
			if (outcoordinate) {
				coor = guideCoor(walkwayNode, arr, coor);
			}
			
			returnValue = "|";
					
		}
		
		return returnValue;
	}
	public static String checkStack(String[][] arr, ArrayList<String> coor, int rows, int columns, Stack<Node> s, boolean outcoordinate) {
		
		Stack<Node> stack = s;
		boolean[][] visited = new boolean[rows][columns];
		String returnValue = "";
		boolean walkway = false;
		Node walkwayNode = null;
		while (!stack.isEmpty()) {
//			System.out.println("here");
			Node n = stack.pop();
			
			if (n.s.equals("$")) {
				//call method here to guide the wolverine
				arr = guide(n, arr);
				//this is for the outcoordinate condition
				if (outcoordinate) {
					coor = guideCoor(n, arr, coor);
				}
				returnValue = "$";
				break;
			}
					
			int row = n.row;
			int col = n.col;
			visited[row][col] = true;
			if (n.s.equals("|")) {
				walkwayNode = n;
				walkway = true;
			}
			
//			if (n.s.equals(".") || n.s.equals("W")) {
				//check up node
				if (row > 0) {
					if (!arr[row-1][col].equals("@") && !visited[row-1][col]) {
						Node up = new Node(row-1, col, arr[row-1][col]);
						
						up.prev = n;
//						visited[row-1][col] = true;
						stack.push(up);
					}
				}
				
				// check down node
				if (row < rows-1) {
					if (!arr[row+1][col].equals("@")  && !visited[row+1][col]) {
						Node down = new Node(row+1, col, arr[row+1][col]);
						down.prev = n;
//						visited[row+1][col] = true;
						stack.push(down);
					}
				}
				//check right node
				if (col < columns-1) {
//					System.out.println("here");
					if (!arr[row][col+1].equals("@")  && !visited[row][col+1]) {
						Node right = new Node(row, col+1, arr[row][col+1]);
						right.prev = n;
//						visited[row][col+1] = true;
						stack.push(right);
					}
				}
				//check left node
				if (col > 0) {
					if (!arr[row][col-1].equals("@")  && !visited[row][col-1]) {
						Node left = new Node(row, col-1, arr[row][col-1]);
						left.prev = n;
//						visited[row][col-1] = true;
						stack.push(left);
					}
				}
//			}
			
			
		}
		
		if (!returnValue.equals("$") && walkway) {
//			System.out.println("here");
			arr = guide(walkwayNode, arr);
			if (outcoordinate) {
				coor = guideCoor(walkwayNode, arr, coor);
			}
			returnValue = "|";
					
		}
		return returnValue;
		

	
	}
	//the queue based implementation is also an optimal approach
	public static String optimal(String[][] arr, ArrayList<String> coor, int rows, int columns, Queue<Node> q, boolean outcoordinate) {
		Queue<Node> queue = q;
		boolean[][] visited = new boolean[rows][columns];
		String returnValue = "";
		boolean walkway = false;
		Node walkwayNode = null;
		while (!queue.isEmpty()) {
//			System.out.println("here");
			Node n = queue.remove();
			
			if (n.s.equals("$")) {
				//call method here to guide the wolverine
//				System.out.println("here");
				if (!outcoordinate) {
					arr = guide(n, arr);
				}
				
				if (outcoordinate) {
					coor = guideCoor(n, arr, coor);
				}
				returnValue = "$";
				break;
			}
					
			int row = n.row;
			int col = n.col;
			visited[row][col] = true;
			if (n.s.equals("|") && !walkway) {
				walkwayNode = n;
				walkway = true;
			}
			
//			if (n.s.equals(".") || n.s.equals("W")) {
				//check up node
				if (row > 0) {
					if (!arr[row-1][col].equals("@") && !visited[row-1][col]) {
						Node up = new Node(row-1, col, arr[row-1][col]);
						up.prev = n;
						queue.add(up);
					}
				}
				
				// check down node
				if (row < rows-1) {
					if (!arr[row+1][col].equals("@")  && !visited[row+1][col]) {
						Node down = new Node(row+1, col, arr[row+1][col]);
						down.prev = n;
						queue.add(down);
					}
				}
				//check right node
				if (col < columns-1) {
//					System.out.println("here");
					if (!arr[row][col+1].equals("@")  && !visited[row][col+1]) {
						Node right = new Node(row, col+1, arr[row][col+1]);
						right.prev = n;
						queue.add(right);
					}
				}
				//check left node
				if (col > 0) {
					if (!arr[row][col-1].equals("@")  && !visited[row][col-1]) {
						Node left = new Node(row, col-1, arr[row][col-1]);
						left.prev = n;
						queue.add(left);
					}
				}
			}
			
//		}
		if (!returnValue.equals("$") && walkway) {
			if (!outcoordinate) {
				arr = guide(walkwayNode, arr);
			}
			if (outcoordinate) {
				coor = guideCoor(walkwayNode, arr, coor);
			}
			returnValue = "|";
					
		}
		return returnValue;
	}
	public static String[][] guide(Node n, String[][] arr) {
			String[][] str = arr;
			Node curr = n.prev;
			//work backwards from the "$" to the "W" to mark the path
			while (true) {
				if (str[curr.row][curr.col].equals("W")) {
					break;
				}
				str[curr.row][curr.col] = "+";
				curr = curr.prev;
			}
			return str;
		
		
		
	}
	//returns an arraylist of strings of the output format if outcoordinate is true
	public static ArrayList<String> guideCoor(Node n, String[][] arr, ArrayList<String> coor) {
		String[][] str = arr;
		Node curr = n.prev;
		while (true) {
			if (str[curr.row][curr.col].equals("W")) {
				break;
			}
			str[curr.row][curr.col] = "+";
			String s = "+ " + curr.row + " " + curr.col;
			coor.add(0, s);
			curr = curr.prev;
		}
		return coor;
	}
	

}
