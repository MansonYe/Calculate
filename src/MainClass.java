
public class MainClass {
    public void Run(int Rance, int Number) {
    	CreateClass Create = new CreateClass();
    	CountClass Count = new CountClass();
    	ReadClass Reader = new ReadClass();
    	
    	Reader.ReadFile();
    	
    	char[] CaluBack;//�ݴ��׺ʽ
    	String Calu;//������׺ʽ
    	String Result;//������
    	
    	do {
    		CaluBack = Create.CaluCreate(Rance);//������׺ʽ�������棨�ַ����飩
        	Create.EquationConstruct();//ת��Ϊ��׺ʽ
        	
        	
    		
        	if(Count.CaluCount(CaluBack)) //���ݺ�׺ʽ������������ֵ��ʾ�������Ƿ����Ҫ��
        	{	
        		Result = Count.getResult();//���������ַ�����
        		Calu = Create.getCalu();//������׺ʽ���ַ�����
        		
        		/*
        		�������ﲹ��Result��Calu��д�뺯���ĵ���
        		лл�ź�[����]
        		*/
        		
        		//���Բ���
        		//Create.CreateTest();
            	//Count.CountTest();
            	//System.out.println("");
            	//���Բ���
            	
        	}
        	else {//������Ҫ����Number�Լӣ��Ա�����
        		Number++;
        
        		//���Բ���
        		//System.out.println("fail\n");
        		//���Բ���
        	}
        	
    	}while(--Number != 0);
    	
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