import java.util.Collections;
import java.util.Stack;

public class Transform {
    private Stack<String> CaluBack = new Stack<String>();// 后缀式栈
    private Stack<Character> Operate = new Stack<Character>();// 运算符栈
    private int[] priority = new int[] { 0, 3, 2, 1, -1, 1, 0, 2 };
    //分别对应( ) * + , - . /
    
    private boolean isOpera(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }
    
    private boolean isOperaS(String c) {
        return c == "+" || c == "-" || c == "*" || c == "/" || c == "(" || c == ")";
    }
    
    private boolean isDigit(String strNum){
        return strNum.matches("[0-9]{1,}");
    }
    
    public boolean compare(char cur, char peek) {// 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
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
        Operate.push(',');// 运算符放入栈底元素逗号，此符号优先级最低
        
        char[] arr = expression.toCharArray();
        int location = 0;// 当前字符的位置
        int count = 0;// 上次算术运算符到本次算术运算符的字符的长度便于或者之间的数值
        char currentOp, topOp;// 当前操作符和栈顶操作符
        
        for (int i = 0; i < arr.length; i++) {
            currentOp = arr[i];
            
            if (isOpera(currentOp)) {//如果当前字符是运算符
                if (count > 0) {
                    CaluBack.push(new String(arr, location, count));// 取两个运算符之间的数字
                }
                topOp = Operate.peek();
                if (currentOp == ')') {// 遇到反括号则将运算符栈中的元素移除到后缀式栈中直到遇到左括号
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
            else {//否则间距自加
                count++;
            }
        }
        if (count > 1 || (count == 1 && !isOpera(arr[location]))) {// 最后一个字符不是括号或者其他运算符的则加入后缀式栈中
            CaluBack.push(new String(arr, location, count));
        }

        while (Operate.peek() != ',') {
            CaluBack.push(String.valueOf(Operate.pop()));// 将操作符栈中的剩余的元素添加到后缀式栈中
        }
    }

}