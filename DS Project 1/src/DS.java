import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DS {
	private int rows;
	private int columns;
	private int mazes;
	private String[][] matrix;
	public DS(int rows, int columns, int mazes, String[][]matrix) {
		this.rows = rows;
		this.columns = columns;
		this.mazes = mazes;
		this.matrix = matrix;
	}
////	@@@@
//	W..@
//	....
//	@..@
//	|.@@
//	W...
//	...@
//	@@..
//	$...
//	@@@@
	
//	5 4 2
//	@ 0 0
//	@ 0 1
//	@ 0 2
//	@ 0 3
//	W 1 0
//	@ 1 3
//	@ 3 0
//	@ 3 3
//	| 4 0
//	@ 4 2
//	@ 4 3
//	W 0 0
//	@ 1 3
//	@ 2 0
//	@ 2 1
//	$ 3 0
	
//	4 4 1
//	.W..
//	..@@
//	.@..
//	..$.
}
