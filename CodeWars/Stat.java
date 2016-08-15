import java.util.Arrays;


public class Stat {
	private static String strFormat(int number){
		int h,m,s;
		StringBuilder sb = new StringBuilder();
		h = number/3600;
		m = (number - h*3600)/60;
		s = number - h*3600 - m*60;
		if(h/10==0)sb.append("0");
		sb.append(h).append("|");
		if(m/10==0)sb.append("0");
		sb.append(m).append("|");
		if(s/10==0)sb.append("0");
		sb.append(s);
		return sb.toString();
	}
	
	private static int[] sort(int[] arr){
		int tmp,min;
		for (int i=0; i<arr.length; i++) {
			min = arr[i];
			for (int j=i; j<arr.length; j++) {
				if (min>arr[i]) {
					tmp = arr[i];
					arr[i] = min;
					min = tmp;					
				}
			}
		}
	}
	
	public static String stat(String strg) {
		if(strg.trim().length()==0){
			return "";
		}
		StringBuilder result= new StringBuilder();
		String [] scores = strg.split(", ");
		String[] score;
		int len = scores.length;
		int[] intScores = new int[len];
		int sum = 0,min=0,max=0;
		String range,average,median;
		for(int i = 0; i <len; i++){
			score = scores[i].split("[|]");
			intScores[i] = Integer.parseInt(score[0].trim())*3600+
							Integer.parseInt(score[1])*60+
							Integer.parseInt(score[2]);
			
			sum+=intScores[i];
		}
		Arrays.sort(intScores);
		range = strFormat(intScores[len-1]-intScores[0]);
		average = strFormat(sum/intScores.length);
		if(len % 2 !=0){
			median = strFormat(intScores[len/2]);
		}else {
			median = strFormat((intScores[len/2]+intScores[len/2+1])/2);
		}
		
		result.append("Range: ").append(range).
				append(" Average: ").append(average).
				append(" Median: ").append(median);
		return result.toString();
	}
	
	public static void main(String[] args) {
		String str = stat("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41");
		System.out.println(str);
	}
}
