
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class MainClass {

    private void Build(int Range, int Number) {
    	CreateClass Create = new CreateClass();
    	CountClass Count = new CountClass();
    	
    	FileOutputStream outputStream1 = null;
    	PrintWriter printWriter1 = null;
    	FileOutputStream outputStream2 = null;
    	PrintWriter printWriter2 = null;
    	int i = 1;
    	
    	String[] CaluBack;//暂存后缀式
    	String Calu;//保存中缀式
    	String Result;//保存结果
    	
    	try {
        	outputStream1 = new FileOutputStream("Exercises.txt");
        	printWriter1 = new PrintWriter(outputStream1);
        	outputStream2 = new FileOutputStream("Answers.txt");
        	printWriter2 = new PrintWriter(outputStream2);
        	 
        	do {
        		CaluBack = Create.CaluCreate(Range);//创建后缀式，并保存（字符数组）
            	Create.EquationConstruct();//转换为中缀式
        		
            	if(Count.CaluCount(CaluBack)) //根据后缀式计算结果，返回值表示计算结果是否符合要求
            	{	
            		Result = Count.getResult();//保存结果（字符串）
            		Calu = Create.getCalu();//保存中缀式（字符串）
            		
            		printWriter1.println(i + ". " + Calu);
            		
            		printWriter2.println(i + ". " + Result);
            		
            		i++;
            		
            	}
            	else {//不符合要求，则Number自加，以便重做
            		Number++;
            	}
            	
        	}while(--Number != 0);
        	
    	
    	} catch (IOException e) {
			System.out.println("Sorry, there has been a problem opening or writing to the file!");
		} finally {
			if(printWriter1 != null) {
				 printWriter1.close();
			}
			if(printWriter2 != null) {
				 printWriter2.close();
			}
		}
    	
    }
	
    private void Judge() {
    	File fileE = new File("Exercises.txt");
		File fileA = new File("Answers.txt");
		BufferedReader readerE = null;
		BufferedReader readerA = null;
		Scanner input = new Scanner(System.in);
		int Tnum = 0;
		int Fnum = 0;
		int Anum = 1;
		String True = "";
    	String False = "";
	   
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
		   if(True != "")
 			   True = True.substring(0, (True.length()-2) );
 		   if(False != "")
			   False = False.substring(0, (False.length()-2) );
 		   System.out.println("\nCorrect:  " + Tnum + " (" + True + ")");
 		   System.out.println("Wrong:  " + Fnum + " (" + False + ")");
		   
		   
		} catch(IOException e) { e.printStackTrace(); } 
		
		input.close();
    }
    
    private void Compare(String ExeFileAddress, String AnsFileAddress) {//比较answer文档和正确答案
    	File fileE = new File(ExeFileAddress);
		File fileA = new File(AnsFileAddress);
		BufferedReader readerE = null;
		BufferedReader readerA = null;
		Transform caltest = new Transform();
		CountClass Count = new CountClass();
		int Anum = 0;
		int Tnum = 0;
		int Fnum = 0;
    	String True = "";
    	String False = "";
		
    	String[] CaluBack = new String[7];//后缀式
    	String Result;
		
    	
    	try {
 		   
    		readerE = new BufferedReader(new FileReader(fileE));//reader打开文件内容
    		readerA = new BufferedReader(new FileReader(fileA));
 		   
    		String LineE = "";
    		String LineA = "";
 		   
    		LineE = readerE.readLine();//do first
    		LineA = readerA.readLine();
 		   
    		
    		while(LineE != null){ 
    			Anum++;
    			LineE = LineE.substring((Anum+"").length()+2);
    			caltest.prepare(LineE);//中缀转后缀
    			CaluBack = caltest.getPostfixStack();
 			 
 			 
    			Count.CaluCount(CaluBack);
    			Result = Count.getResult();
 			 
    			if(LineA.equals(Anum + ". " + Result)) {//读入答案，并判断对错
 				   True += Anum + ", ";
 				   Tnum++;
 			   }
 			   else {
 				   False += Anum + ", ";
 				   Fnum++;
 			   }
 			 
 			 	LineE = readerE.readLine();//do again
 			 	LineA = readerA.readLine();
 			  
 			 
    		}
 		   
 		   readerE.close();
 		   readerA.close();
 		   if(True != "")
 			   True = True.substring(0, (True.length()-2) );
 		   if(False != "")
			   False = False.substring(0, (False.length()-2) );
 		   System.out.println("\nCorrect:  " + Tnum + " (" + True + ")");
 		   System.out.println("Wrong:  " + Fnum + " (" + False + ")");
 		   
 		} catch(IOException e) { e.printStackTrace(); } 
		
    }
    
	public static void main(String[] args) {
		
	
        MainClass mainclass = new MainClass();
        
        String ExeFileAddress = null;
        String AnsFileAddress = null;
        
        int Range = 0;
        int Number = 1;
        int i = 0;
        Scanner input = new Scanner(System.in);
        
        do {
        	switch(args[i]) {
        	case "-r":
        		Range = Integer.parseInt(args[i+1]);
        		break;
        	case "-n":
        		Number = Integer.parseInt(args[i+1]);
        		break;
        	case "-e":
        		ExeFileAddress = args[i+1];
        		break;
        	case "-a":
        		AnsFileAddress = args[i+1];
        		break;
        	default:
        		break;
        	}
        	i++;
        }while(i < args.length);
        
        if(ExeFileAddress != null && AnsFileAddress != null) {
        	mainclass.Compare(ExeFileAddress, AnsFileAddress);
        }
        else {
        	if(Range == 0) {
            	System.out.println("Range have not input, please input again:");
            	Range = input.nextInt();
            }
            
            System.out.println("Start with: Range = " + Range + ", Number = " + Number);
            
            mainclass.Build(Range, Number);
            mainclass.Judge();

        }
        input.close();
        
        System.out.println("\n/---end---/");
        
    }
}