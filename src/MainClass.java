
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class MainClass {
	
    private void Build(int Rance, int Number) {
    	CreateClass Create = new CreateClass();
    	CountClass Count = new CountClass();
    	
    	String[] CaluBack;//�ݴ��׺ʽ
    	String Calu;//������׺ʽ
    	String Result;//������
    	
    	do {
    		CaluBack = Create.CaluCreate(Rance);//������׺ʽ�������棨�ַ����飩
        	Create.EquationConstruct();//ת��Ϊ��׺ʽ
    		
        	if(Count.CaluCount(CaluBack)) //���ݺ�׺ʽ������������ֵ��ʾ�������Ƿ����Ҫ��
        	{	
        		Result = Count.getResult();//���������ַ�����
        		Calu = Create.getCalu();//������׺ʽ���ַ�����
        		
        		/**************/
        		
	        	Create.CreateTest();    Count.CountTest();    System.out.println("");
        		//testing
        	}
        	else {//������Ҫ����Number�Լӣ��Ա�����
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
		   
		   readerE = new BufferedReader(new FileReader(fileE));//reader���ļ�����
		   readerA = new BufferedReader(new FileReader(fileA));
		   
		   String LineE = "";
		   String LineA = "";
		   
		   LineE = readerE.readLine();//do first
		   LineA = readerA.readLine();
		   
		   while(LineE != null){
			   System.out.print(LineE + " = ");
			   
			   String temp = (Anum++) + ". " + input.nextLine();
			   if(LineA.equals(temp)) {//����𰸣����ж϶Դ�
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