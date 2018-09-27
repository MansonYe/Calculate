
public class CountClass {

	private String Result = "#";
	
	public boolean CaluCount(char[] CaluBack) {
		int loop1 = 0;//循环后缀式
		int loop2 = 0;//模仿栈
		int mole = 0;//分子
		int deno = 0;//分母
		
		Elem[] num = new Elem[4];
		while(loop2 < 4)
			num[loop2++] = new Elem();
		loop2 = 0;
		
		for(loop1 = 0; loop1 < CaluBack.length; loop1++) {
			if( CaluBack[loop1] >= '0' && CaluBack[loop1] <= '9') {
			//判断是否为数字，目前只做了个位数判断，后期视情况修改
				num[loop2].setMole( ((int)CaluBack[loop1]-48) * num[loop2].getDeno());
				loop2++;
				//利用num[loop2]模仿栈，把数字放入栈中
			}
			else {//是算符的话，根据情况作计算
				switch(CaluBack[loop1]) {
				case '+': 
					mole = num[loop2-2].getMole() * num[loop2-1].getDeno() + num[loop2-1].getMole() * num[loop2-2].getDeno();
					deno = num[loop2-2].getDeno() * num[loop2-1].getDeno();
					num[loop2-1] = new Elem();
					num[loop2-2].setDeno(deno);
					num[loop2-2].setMole(mole);
					loop2--;
					break;
					
				case '-':
					mole = num[loop2-2].getMole() * num[loop2-1].getDeno() - num[loop2-1].getMole() * num[loop2-2].getDeno();
					deno = num[loop2-2].getDeno() * num[loop2-1].getDeno();
					num[loop2-1] = new Elem();
					num[loop2-2].setDeno(deno);
					num[loop2-2].setMole(mole);
					loop2--;
					break;
					
				case '*': 
					mole = num[loop2-2].getMole() * num[loop2-1].getMole();
					deno = num[loop2-2].getDeno() * num[loop2-1].getDeno();
					num[loop2-1] = new Elem();
					num[loop2-2].setDeno(deno);
					num[loop2-2].setMole(mole);
					loop2--;
					break;
					
				case '/': 
					mole = num[loop2-2].getMole() * num[loop2-1].getDeno();
					deno = num[loop2-2].getDeno() * num[loop2-1].getMole();
					num[loop2-1] = new Elem();
					num[loop2-2].setDeno(deno);
					num[loop2-2].setMole(mole);
					loop2--;
					break;
					
				default: 
					break;
				}//end switch
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
		mole = mole % deno;
		Result = "";
		
		if(mole == 0)
			Result = Integer + ""; 
		else if(Integer == 0)
			Result = mole + "/" + deno;
		else	
			Result = Integer + "'" + mole + "/" + deno;
	}

	public String getResult() {
		return Result;
	}
	
	public void CountTest() {
		System.out.println(Result);
	}
	
}
