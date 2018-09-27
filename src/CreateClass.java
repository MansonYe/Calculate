import java.util.Stack;

public class CreateClass {

	private char[] CaluBack = new char[7];
	private String Calu = "";
	
	public char[] CaluCreate(int Rance) {	//����һ���沨��ʽ����ʽ
		char[] SingCollection = {'+', '-', '*', '/'};
		int n = 0;
		int c = 0;
		int i=0;
		
		do {
			if( ((int)(Math.random()*2) != 1) && (n-1 > c) ) {
			//�������׺ʽ������������ɴ������������������ң�
				CaluBack[i++] = SingCollection[(int)(Math.random()*4)];
				c++;
			}
			else if(n < 4){
			//����4�������˾Ͳ�����������
				CaluBack[i++] = (char)( ((int)(Math.random()*Rance)) + 48);
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
			if( CaluBack[loop1] >= '0' && CaluBack[loop1] <= '9') {
				CaluMid.push(CaluBack[loop1] + "");
			}
			
			else { 
				s1 = CaluMid.pop();
				s2 = CaluMid.pop();
				
				switch(CaluBack[loop1]) {
				case '+': 
					CaluMid.push(s2 + "+" + s1); 
					break;
					
				case '-': 
					CaluMid.push(s2 + "-" + s1); 
					break;
					
				case '*': 
					CaluMid.push(s2 + "*" + s1); 
					break;
					
				case '/': 
					CaluMid.push(s2 + "/" + s1); 
					break;
					
				default: 
					break;
				}
				
				if(loop1 != CaluBack.length - 1) {
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
	
	public char[] getCaluBack() {
		return CaluBack;
	}
	
}