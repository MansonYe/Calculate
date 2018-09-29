import static org.junit.Assert.*;

import org.junit.Test;

public class test1 extends MainClass{

	@Test
	public void test() {
		System.out.println("test");
		MainClass testMain = new MainClass();
		String[] test1 = {"-n", "5", "-r", "10"};
		String[] test2 = {"-a", "answersfile.txt", "-e", "exercisesfile.txt"};
		
		testMain.main(test1);
		
		testMain.main(test2);
		
		//fail("ипн╢й╣ож");
	}

}
