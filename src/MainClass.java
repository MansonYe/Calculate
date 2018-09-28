import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {
    public void Run(int Rance, int Number) {
    	CreateClass Create = new CreateClass();
    	CountClass Count = new CountClass();
    	ReadClass Reader = new ReadClass();
    	FileOutputStream outputStream1 = null;
    	PrintWriter printWriter1 = null;
    	FileOutputStream outputStream2 = null;
    	PrintWriter printWriter2 = null;
    	int i = 1;
    	
    	char[] CaluBack;//暂存后缀式
    	String Calu;//保存中缀式
    	String Result;//保存结果
    	
    	try {
    	outputStream1 = new FileOutputStream("Exercises.txt");
    	printWriter1 = new PrintWriter(outputStream1);
    	outputStream2 = new FileOutputStream("Answers.txt");
    	printWriter2 = new PrintWriter(outputStream2);
    	 
    	do {
    		CaluBack = Create.CaluCreate(Rance);//创建后缀式，并保存（字符数组）
        	Create.EquationConstruct();//转换为中缀式
    		
        	if(Count.CaluCount(CaluBack)) //根据后缀式计算结果，返回值表示计算结果是否符合要求
        	{	
        		Result = Count.getResult();//保存结果（字符串）
        		Calu = Create.getCalu();//保存中缀式（字符串）
        		
        		
        		printWriter1.println(i + ". " + Calu);
        		
        		printWriter2.println(i + ". " + Result);
        		
        		i++;
        		/*
        		请在这里补充Result和Calu的写入函数的调用
        		谢谢张鸿[呲牙]
        		*/
        		
        		//测试部分
        		Create.CreateTest();
            	Count.CountTest();
            	System.out.println("");
            	//测试部分
            	
        	}
        	else {//不符合要求，则Number自加，以便重做
        		Number++;
        
        		//测试部分
        		System.out.println("fail\n");
        		//测试部分
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
    	/*
    	Create.CaluCreate(Rance);
    	Create.EquationConstruct();
    	
    	Count.CaluCount(Create.getCaluBack());
    	
    	Create.CreateTest();
    	Count.CountTest();
    	*/
    	
        }
	
	public static void main(String[] args) {
        MainClass mainclass = new MainClass();
        int Rance = 10;
        int Number = 10;
        mainclass.Run(Rance, Number);
    }
}