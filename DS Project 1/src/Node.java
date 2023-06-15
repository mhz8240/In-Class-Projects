
public class Node {
	public int row;
	public int col;
	public Node prev;
	public String s;
	public Node(int row, int col, String s) {
		this.row = row;
		this.col = col;
		prev = null;
		this.s = s;
	}
}
