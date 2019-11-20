package week1;

import java.util.Scanner;

public class encryption_yajin4 {

	public static String encryption(String s) {
		String tmp = s.trim();
		int len = tmp.length();

		int row, col;

		double root = Math.sqrt(len);
		if (root - (int) root == 0) {
			row = (int) root;
			col = (int) root;
		} else if((int)root*((int)root+1) <len){
			row = (int)root+1;
			col=row;
		}else {
			row = (int) root;
			col = row + 1;
		}
		
		System.out.println("row : " + row + ", col : " + col);

		String[] arr = new String[row];

		for (int i = 0; i < row; i++) {
			if (tmp.length() <= col)
				arr[i] = tmp;
			else {
				arr[i] = tmp.substring(0,col);
				tmp = tmp.substring(col);
			}
			 System.out.println(arr[i]);
		}

		String result = "";

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (arr[j].length() >= i+1) {
					// System.out.print(arr[j].charAt(i));
					result=result.concat(Character.toString(arr[j].charAt(i)));
				}
			}
			result=result.concat(" ");
		}
		// System.out.println("°á°ú : "+result);

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String result = encryption(s);

		System.out.println(result);
		scan.close();
	}

}
