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
    	
    	char[] CaluBack;//�ݴ��׺ʽ
    	String Calu;//������׺ʽ
    	String Result;//������
    	
    	try {
    	outputStream1 = new FileOutputStream("Exercises.txt");
    	printWriter1 = new PrintWriter(outputStream1);
    	outputStream2 = new FileOutputStream("Answers.txt");
    	printWriter2 = new PrintWriter(outputStream2);
    	 
    	do {
    		CaluBack = Create.CaluCreate(Rance);//������׺ʽ�������棨�ַ����飩
        	Create.EquationConstruct();//ת��Ϊ��׺ʽ
    		
        	if(Count.CaluCount(CaluBack)) //���ݺ�׺ʽ������������ֵ��ʾ�������Ƿ����Ҫ��
        	{	
        		Result = Count.getResult();//���������ַ�����
        		Calu = Create.getCalu();//������׺ʽ���ַ�����
        		
        		
        		printWriter1.println(i + ". " + Calu);
        		
        		printWriter2.println(i + ". " + Result);
        		
        		i++;
        		/*
        		�������ﲹ��Result��Calu��д�뺯���ĵ���
        		лл�ź�[����]
        		*/
        		
        		//���Բ���
        		Create.CreateTest();
            	Count.CountTest();
            	System.out.println("");
            	//���Բ���
            	
        	}
        	else {//������Ҫ����Number�Լӣ��Ա�����
        		Number++;
        
        		//���Բ���
        		System.out.println("fail\n");
        		//���Բ���
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