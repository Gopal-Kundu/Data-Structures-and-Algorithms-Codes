//https://codeforces.com/contest/2289/problem/A

import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
		long[] testCases = new long[n];
		for(int i = 0; i < n; i++){
		    testCases[i] = sc.nextLong();
		}
		for(int i = 0; i < n; i++){
		    if(testCases[i] % 2 == 0 && testCases[i] % 4 != 0)
		        System.out.println("NO");
		    else System.out.println("YES");
		}
	}
}