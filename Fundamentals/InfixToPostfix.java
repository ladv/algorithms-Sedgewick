package demo;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		Stack<Character> opers = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		char symb;
		int counter = 0;
		for(int i = 0; i < str.length(); i++){
			symb = str.charAt(i);
			if(symb == '(')continue;
			if(symb == '+'||symb == '-'||symb == '*'||symb == '/'){
				opers.push(symb);
			}else if(symb == ')'){
				sb.append(opers.pop());
				counter++;
			}else{
				sb.append(symb);
			}
		}

		if(counter != 0){
			sb.append(opers.pop());
			counter--;
		}
		System.out.println("postfix " + sb.toString());
	}
}
