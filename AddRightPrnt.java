package demo;

import java.util.Scanner;
import java.util.Stack;

public class AddRightPrnt {
	
	public static void main(String[] args) {
		Stack<Integer> numbers = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter expression");
		String str = sc.next().trim();
		char symb = 0;
		int num, i = str.length()-1, counter=0;
		StringBuilder sb = new StringBuilder();
		do{
			if(i>=0){
				symb = str.charAt(i);
				sb.insert(0,symb);
				i--;
			}
			if(symb == ')'){
				counter++;
				continue;
			}
			if(symb != '+'&&symb != '-'&&symb != '*'&&symb != '/'){
				num = Character.getNumericValue(symb);
				if(numbers.isEmpty()){
					numbers.push(num);
				}else {
					sb.insert(0,'(');
					numbers.pop();
					counter--;
				}
			}
		}while(counter !=0);
		
		if(numbers.isEmpty()){
			System.out.println("stack 'numbers' is empty");
			System.out.println(sb);
		}
		else {
			System.out.println("stack 'numbers' is not empty");
			System.out.println(sb);
		}
	}
}
