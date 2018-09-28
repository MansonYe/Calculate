
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class MainClass {
	
    private void Build(int Rance, int Number) {
    	CreateClass Create = new CreateClass();
    	CountClass Count = new CountClass();
    	
    	String[] CaluBack;//暂存后缀式
    	String Calu;//保存中缀式
    	String Result;//保存结果
    	
    	do {
    		CaluBack = Create.CaluCreate(Rance);//创建后缀式，并保存（字符数组）
        	Create.EquationConstruct();//转换为中缀式
    		
        	if(Count.CaluCount(CaluBack)) //根据后缀式计算结果，返回值表示计算结果是否符合要求
        	{	
        		Result = Count.getResult();//保存结果（字符串）
        		Calu = Create.getCalu();//保存中缀式（字符串）
        		
        		/**************/
        		
	        	Create.CreateTest();    Count.CountTest();    System.out.println("");
        		//testing
        	}
        	else {//不符合要求，则Number自加，以便重做
        		Number++;
        	}
        	
    	}while(--Number != 0);
    	
    }
	
    private void Judge() {
    	File fileE = new File("ExercisesTest.txt");
		File fileA = new File("AnswerTest.txt");
		BufferedReader readerE = null;
		BufferedReader readerA = null;
		Scanner input = new Scanner(System.in);
		int Tnum = 0;
		int Fnum = 0;
		int Anum = 1;
		// TestAnswer = {"10", "6'1/4", "5'1/3", "21"};
	   
		try {
		   
		   readerE = new BufferedReader(new FileReader(fileE));//reader打开文件内容
		   readerA = new BufferedReader(new FileReader(fileA));
		   
		   String LineE = "";
		   String LineA = "";
		   
		   LineE = readerE.readLine();//do first
		   LineA = readerA.readLine();
		   
		   while(LineE != null){
			   System.out.print(LineE + " = ");
			   
			   String temp = (Anum++) + ". " + input.nextLine();
			   if(LineA.equals(temp)) {//读入答案，并判断对错
				   System.out.println("True");
				   Tnum++;
			   }
			   else {
				   System.out.println("False");
				   Fnum++;
			   }
			   
			   LineE = readerE.readLine();//do again
			   LineA = readerA.readLine();
		   }
		   
		   readerE.close();
		   readerA.close();
		   
		   System.out.println("\nTrue: " + Tnum + "  False: " + Fnum);
		   
	   } catch(IOException e) { e.printStackTrace(); } 
		
    }
    
	public static void main(String[] args) {
        MainClass mainclass = new MainClass();
        int Rance = 20;
        int Number = 10;
        
        mainclass.Build(Rance, Number);
        //mainclass.Judge();
        
        System.out.println("\n/---end---/");
    }
}