import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Main {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	@Test
	void testSize() {
		Stack<Integer> temp = new Stack<Integer>();
		temp.add(5);
		temp.add(4); 
		temp.add(3);
		assertEquals(temp.remove(), 3);
		assertEquals(2, temp.size());
		
	}

}
