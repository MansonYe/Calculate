import java.util.Stack;

public class CreateClass {

	private char[] CaluBack = new char[7];
	private String Calu = "";
	
	public char[] CaluCreate(int Rance) {	//创建一个逆波兰式的算式
		char[] SingCollection = {'+', '-', '*', '/'};
		int n = 0;
		int c = 0;
		int i=0;
		
		do {
			if( ((int)(Math.random()*2) != 1) && (n-1 > c) ) {
			//随机但后缀式中算符数量不可大于数字数量（从左到右）
				CaluBack[i++] = SingCollection[(int)(Math.random()*4)];
				c++;
			}
			else if(n < 4){
			//生成4个数字了就不再生成数字
				CaluBack[i++] = (char)( ((int)(Math.random()*Rance)) + 48);
				n++;
			}
			
		}while(n+c < CaluBack.length);
		
		return CaluBack;
	}
	
	public String EquationConstruct() {	//后缀式转中缀式
		Stack<String> CaluMid = new Stack<String>();
		int loop1;
		String s1, s2;
		
		for(loop1=0; loop1<CaluBack.length; loop1++) {//注释参考隔壁CountClass
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
	
	public void CreateTest() {	//测试
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