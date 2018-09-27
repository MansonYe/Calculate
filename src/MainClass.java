
public class MainClass {
    public void Run(int Rance, int Number) {
    	CreateClass Create = new CreateClass();
    	CountClass Count = new CountClass();
    	ReadClass Reader = new ReadClass();
    	
    	Reader.ReadFile();
    	
    	char[] CaluBack;//暂存后缀式
    	String Calu;//保存中缀式
    	String Result;//保存结果
    	
    	do {
    		CaluBack = Create.CaluCreate(Rance);//创建后缀式，并保存（字符数组）
        	Create.EquationConstruct();//转换为中缀式
        	
        	
    		
        	if(Count.CaluCount(CaluBack)) //根据后缀式计算结果，返回值表示计算结果是否符合要求
        	{	
        		Result = Count.getResult();//保存结果（字符串）
        		Calu = Create.getCalu();//保存中缀式（字符串）
        		
        		/*
        		请在这里补充Result和Calu的写入函数的调用
        		谢谢张鸿[呲牙]
        		*/
        		
        		//测试部分
        		//Create.CreateTest();
            	//Count.CountTest();
            	//System.out.println("");
            	//测试部分
            	
        	}
        	else {//不符合要求，则Number自加，以便重做
        		Number++;
        
        		//测试部分
        		//System.out.println("fail\n");
        		//测试部分
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