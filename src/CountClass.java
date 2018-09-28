
public class CountClass {

	private String Result = "";
	
	private boolean isDigit(String strNum){
        return strNum.matches("[0-9]{1,}");
    }
	
	public boolean CaluCount(String[] CaluBack) {
		int loop1 = 0;//循环后缀式
		int loop2 = 0;//模仿栈
		int mole = 0;//分子
		int deno = 0;//分母
		int d1, d2, m1, m2;
		
		Elem[] num = new Elem[4];
		while(loop2 < 4)
			num[loop2++] = new Elem();
		loop2 = 0;
		
		for(loop1 = 0; loop1 < CaluBack.length; loop1++) {
			if( isDigit(CaluBack[loop1]) ) {
			//判断是否为数字，目前只做了个位数判断，后期视情况修改
				num[loop2].setMole( Integer.parseInt(CaluBack[loop1]) * num[loop2].getDeno() );
				loop2++;
				//利用num[loop2]模仿栈，把数字放入栈中((int)-48)
			}
			else {//是算符的话，根据情况作计算
				
				m1 = num[loop2-2].getMole();//取出伪栈中2个数据进行计算
				m2 = num[loop2-1].getMole();
				d1 = num[loop2-2].getDeno();
				d2 = num[loop2-1].getDeno();
				
				switch(CaluBack[loop1]) {
				case "+": 
					mole = m1 * d2 + m2 * d1;    deno = d1 * d2;    break;
					
				case "-":
					mole = m1 * d2 - m2 * d1;    deno = d1 * d2;
					if(mole < 0)//防止计算过程中出现负数
						return false;
					break;
					
				case "*": 
					mole = m1 * m2;    deno = d1 * d2;    break;
					
				case "/": 
					mole = m1 * d2;    deno = d1 * m2;    break;
					
				case "#": 
					mole = m1;    deno = d1;    break;
					
				default: 
					break;
				}
				
				num[loop2-2].setDeno(deno);//计算结果入栈
				num[loop2-2].setMole(mole);
				
				num[loop2-1] = new Elem();//清空出栈元素位置
				loop2--;
				
			}//end else
		}//end for
		
		
		if(num[0].getDeno() <= 0 || num[0].getMole() < 0) {//如果结果不符合要求返回false
			return false;
		}
		else {	
			ResultConstruct(num[0]);//符合要求则将假分数转换为真分数
		}
		return true;
	}
	
	private void ResultConstruct(Elem elem) {//将假分数转换为真分数，并存入Result
		int mole = elem.getMole();
		int deno = elem.getDeno();
		int Integer = mole/deno;
		
		int a = mole;//a, b and c are used to count divisor
		int b = deno;
		int c = 0;
		
		mole = mole % deno;
		Result = "";
		
		if(mole == 0)
			Result = Integer + ""; 
		
		else { 
			while(a % b != 0) {
				c = a % b;
				a = b;
				b = c;
			}
				mole /= b;
				deno /= b;
			
			if(Integer == 0)
				Result = mole + "/" + deno;
			else	
				Result = Integer + "'" + mole + "/" + deno;
		}
	}

	public String getResult() {
		return Result;
	}
	
	public void CountTest() {
		System.out.println(Result);
	}
	
}
