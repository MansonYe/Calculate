import java.util.Stack;

public class CreateClass {

	private String[] CaluBack = new String[7];
	private String Calu = "";
	
	private boolean isDigit(String strNum){
        return strNum.matches("[0-9]{1,}");
    }
	
	public String[] CaluCreate(int Rance) {	//����һ���沨��ʽ����ʽ
		String[] SingCollection = {"+", "-", "*", "/", "#"};
		int n = 0;
		int c = 0;
		int i=0;
		
		do {
			if( ((int)(Math.random()*2) != 1) && (n-1 > c) ) {
			//�������׺ʽ������������ɴ������������������ң�
				CaluBack[i++] = SingCollection[(int)(Math.random()*(5 - c/2))];
				c++;
			}
			else if(n < 4){
			//����4�������˾Ͳ�����������
				CaluBack[i++] = (int)(Math.random()*Rance) + "";
				n++;
			}
			
		}while(n+c < CaluBack.length);
		
		return CaluBack;
	}
	
	public String EquationConstruct() {	//��׺ʽת��׺ʽ
		Stack<String> CaluMid = new Stack<String>();
		int loop1;
		String s1, s2;
		
		for(loop1=0; loop1<CaluBack.length; loop1++) {//ע�Ͳο�����CountClass
			if(isDigit(CaluBack[loop1])) {
				CaluMid.push(CaluBack[loop1] + "");
			}
			
			else { 
				s1 = CaluMid.pop();
				s2 = CaluMid.pop();
				
				switch(CaluBack[loop1]) {
				case "+": 
					CaluMid.push(s2 + " + " + s1); 
					break;
					
				case "-": 
					CaluMid.push(s2 + " - " + s1); 
					break;
					
				case "*": 
					CaluMid.push(s2 + " * " + s1); 
					break;
					
				case "/": 
					CaluMid.push(s2 + " / " + s1); 
					break;
					
				case "#": 
					CaluMid.push(s2); 
					break;
					
				default: 
					break;
				}
				
				if(loop1 != CaluBack.length - 1 && CaluBack[loop1] != "#") {
					CaluMid.push("(" + CaluMid.pop() + ")");
				}
			}	
		}
		
		Calu = CaluMid.pop();
		return Calu;
	}
	
	public void CreateTest() {	//����
		for(int i=0; i<CaluBack.length; i++)
			System.out.print(CaluBack[i]);
		System.out.println("\n" + Calu);
	}
	
	public String getCalu() {
		return Calu;
	}
	
	public String[] getCaluBack() {
		return CaluBack;
	}
	
}