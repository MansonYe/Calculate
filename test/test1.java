import static org.junit.Assert.*;

import org.junit.Test;

public class test1 extends MainClass{

	@Test
	public void test() {
		System.out.println("test");
		MainClass testMain = new MainClass();
		String[] testString = {"-n", "100", "-r", "10"};
		testMain.main(testString);
		//fail("ипн╢й╣ож");
	}

}
