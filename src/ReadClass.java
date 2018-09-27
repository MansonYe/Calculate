import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadClass {
	
	public void ReadFile() {
		File file = new File("test.txt");  
		BufferedReader reader = null;
	   
		try {
		   
		   reader = new BufferedReader(new FileReader(file));//reader打开文件内容
		   
		   String ReadLine = "";
		   
		   while(ReadLine != null){
			   ReadLine = reader.readLine();
			   System.out.println(ReadLine);
		   }
		   
		   reader.close();
		   
		   
	   } catch(IOException e) {
		   e.printStackTrace();
	   } finally {
		   if (reader != null) {
			   try {
				   reader.close();
			   } catch(IOException e1) {
				   
			   }
		   }
		   
	   }//end try, catch, finally
	   
	   
	}
    
}
