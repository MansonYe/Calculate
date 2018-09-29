import java.util.Collections;
import java.util.Stack;

public class Transform {
    private Stack<String> CaluBack = new Stack<String>();// ��׺ʽջ
    private Stack<Character> Operate = new Stack<Character>();// �����ջ
    private int[] priority = new int[] { 0, 3, 2, 1, -1, 1, 0, 2 };
    //�ֱ��Ӧ( ) * + , - . /
    
    private boolean isOpera(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }
    
    private boolean isOperaS(String c) {
        return c == "+" || c == "-" || c == "*" || c == "/" || c == "(" || c == ")";
    }
    
    private boolean isDigit(String strNum){
        return strNum.matches("[0-9]{1,}");
    }
    
    public boolean compare(char cur, char peek) {// �����peek���ȼ�����cur������true��Ĭ�϶���peek���ȼ�Ҫ��
        return priority[(peek) - 40] >= priority[(cur) - 40];
    }
    
    public String[] getPostfixStack() {
    	String[] CaluBacktest = new String[7];
    	String Temp;
    	int i = 0;
    	
    	Collections.reverse(CaluBack);
    	
    	
    	while(!CaluBack.isEmpty()) {
    		Temp = CaluBack.pop().trim();
    		if(!Temp.isEmpty()) {
    			CaluBacktest[i] = Temp;

        		i++;
    		}
    	}
    	
    	return CaluBacktest;
    }
    
    public void prepare(String expression) {
        Operate.push(',');// ���������ջ��Ԫ�ض��ţ��˷������ȼ����
        
        char[] arr = expression.toCharArray();
        int location = 0;// ��ǰ�ַ���λ��
        int count = 0;// �ϴ����������������������������ַ��ĳ��ȱ��ڻ���֮�����ֵ
        char currentOp, topOp;// ��ǰ��������ջ��������
        
        for (int i = 0; i < arr.length; i++) {
            currentOp = arr[i];
            
            if (isOpera(currentOp)) {//�����ǰ�ַ��������
                if (count > 0) {
                    CaluBack.push(new String(arr, location, count));// ȡ���������֮�������
                }
                topOp = Operate.peek();
                if (currentOp == ')') {// �����������������ջ�е�Ԫ���Ƴ�����׺ʽջ��ֱ������������
                    while (Operate.peek() != '(') {
                        CaluBack.push(String.valueOf(Operate.pop()));
                    }
                    Operate.pop();
                } else {
                    while (currentOp != '(' && topOp != ',' && compare(currentOp, topOp)) {
                        CaluBack.push(String.valueOf(Operate.pop()));
                        topOp = Operate.peek();
                    }
                    Operate.push(currentOp);
                }
                count = 0;
                location = i + 1;
            } 
            else {//�������Լ�
                count++;
            }
        }
        if (count > 1 || (count == 1 && !isOpera(arr[location]))) {// ���һ���ַ��������Ż��������������������׺ʽջ��
            CaluBack.push(new String(arr, location, count));
        }

        while (Operate.peek() != ',') {
            CaluBack.push(String.valueOf(Operate.pop()));// ��������ջ�е�ʣ���Ԫ����ӵ���׺ʽջ��
        }
    }

}