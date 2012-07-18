package com.mdo.problems;

import java.util.Scanner;

public class UVAProblem {
	
	/*
	 * <link>http://acm.uva.es/p/v1/100.html</link>
	 */
	public static void threenPlusOne(int min, int max) {
		int total = 0;
		
		// calculate between min to max
		for(int i = min; i <= max; i++) {
			int count = 0;
			int n = i;
			// calculate 3n+1
			while (true) {
				count++;
				if (n == 1) break;
				
				if ((n%2) != 0) {
					n = 3*n+1;
				} else {
					n <<= 2;
				}
			}
			// set the total
			if (total < count) total = count;
		}

		// print
		System.out.println(min + " " + max + " " + total);
	}
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String line = in.nextLine();
			String[] parts = line.split(" ");
			threenPlusOne(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
		}
		/*threenPlusOne(1,10);
		threenPlusOne(100,200);
		threenPlusOne(201,210);
		threenPlusOne(900,1000);*/
	}
}
