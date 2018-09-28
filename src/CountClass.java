
public class CountClass {

	private String Result = "";
	
	private boolean isDigit(String strNum){
        return strNum.matches("[0-9]{1,}");
    }
	
	public boolean CaluCount(String[] CaluBack) {
		int loop1 = 0;//ѭ����׺ʽ
		int loop2 = 0;//ģ��ջ
		int mole = 0;//����
		int deno = 0;//��ĸ
		int d1, d2, m1, m2;
		
		Elem[] num = new Elem[4];
		while(loop2 < 4)
			num[loop2++] = new Elem();
		loop2 = 0;
		
		for(loop1 = 0; loop1 < CaluBack.length; loop1++) {
			if( isDigit(CaluBack[loop1]) ) {
			//�ж��Ƿ�Ϊ���֣�Ŀǰֻ���˸�λ���жϣ�����������޸�
				num[loop2].setMole( Integer.parseInt(CaluBack[loop1]) * num[loop2].getDeno() );
				loop2++;
				//����num[loop2]ģ��ջ�������ַ���ջ��((int)-48)
			}
			else {//������Ļ����������������
				
				m1 = num[loop2-2].getMole();//ȡ��αջ��2�����ݽ��м���
				m2 = num[loop2-1].getMole();
				d1 = num[loop2-2].getDeno();
				d2 = num[loop2-1].getDeno();
				
				switch(CaluBack[loop1]) {
				case "+": 
					mole = m1 * d2 + m2 * d1;    deno = d1 * d2;    break;
					
				case "-":
					mole = m1 * d2 - m2 * d1;    deno = d1 * d2;
					if(mole < 0)//��ֹ��������г��ָ���
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
				
				num[loop2-2].setDeno(deno);//��������ջ
				num[loop2-2].setMole(mole);
				
				num[loop2-1] = new Elem();//��ճ�ջԪ��λ��
				loop2--;
				
			}//end else
		}//end for
		
		
		if(num[0].getDeno() <= 0 || num[0].getMole() < 0) {//������������Ҫ�󷵻�false
			return false;
		}
		else {	
			ResultConstruct(num[0]);//����Ҫ���򽫼ٷ���ת��Ϊ�����
		}
		return true;
	}
	
	private void ResultConstruct(Elem elem) {//���ٷ���ת��Ϊ�������������Result
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
