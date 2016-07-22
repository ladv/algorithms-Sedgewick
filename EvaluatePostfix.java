package demo;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String str;
		Stack<Integer> vals = new Stack<Integer>();
		int num,res = 0,a,b,temp=0;
		char c;
		while(scan.hasNext()){
			str = scan.next();
			if(String.) 
			switch(c){
				case '+':
					res=vals.pop()+vals.pop();
					vals.push(res);
					temp=0;
				break;
				case '-':
					a=vals.pop();b=vals.pop();
					res=b-a;
					vals.push(res);
					temp=0;
				break;
				case '*':
					res=vals.pop()*vals.pop();
					vals.push(res);
					temp=0;
				break;
				case '/':
					a=vals.pop();b=vals.pop();
					res=b/a;
					vals.push(res);
					temp=0;
				break;
				case ' ':
					temp=0;
					break;
				default:
					num = Character.getNumericValue(c);
					if(temp!=0){
						temp = temp*10+num;
						vals.push(temp);
					}
					vals.push(num);
			}
		}
		System.out.println("result "+vals.pop());
	}
}
