package com.dsalgo.problems.other;

import java.util.ArrayList;
import java.util.List;

public class StringProblems {

	private static boolean[] used;
	
	private static StringBuilder out = new StringBuilder();
	private final static String in="abcd";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		used= new boolean[in.length()];
		//permute();
		System.out.println("status ="+isPalindrome("1aba1"));
		int res = strToInt("123");
		intToStr(res);

		List<String> strings = stringPermutation("abc", "", new ArrayList<String>());
		strings.size();
	}

	private static void permutation(String prefix, String str){
        int n = str.length();
        if (n == 0) 
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), 
            str.substring(0, i) + str.substring(i+1));
        }
    }
	
	public static void permute(){
		
		if( out.length() == in.length() ){
			System.out.println( out );
			return; 
		}
		
		for( int i = 0; i < in.length(); ++i )
		{ if( used[i] ) continue;
		out.append( in.charAt(i) );
		used[i] = true;
		permute();
		used[i] = false;
		out.setLength( out.length() - 1 );
		}
	}

	public static List<String> stringPermutation(String str, String ans, List<String> res)
	{

		// If string is empty
		if (str.length() == 0) {

			res.add(ans);
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) +
					str.substring(i + 1);

			// Recurvise call
			stringPermutation(ros, ans + ch, res);
		}
		return res;
	}


	public static int strToInt(String str) {
		int i = 0, num = 0;
		boolean isNeg = false;
		int len = str.length();
		if (str.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}

		while (i < len) {
			num *= 10;
			num += (str.charAt(i++) - '0');
		}
		if (isNeg)
			num = -num;
		return num;
	}
	
	public static String intToStr(int num) {
		final int MAX_DIGITS =10;
		int i = 0;
		boolean isNeg = false;
		/* Buffer big enough for largest int and - sign */char[] temp = new char[MAX_DIGITS + 1];
		/* Check to see if the number is negative */
		if (num < 0) {
			num = -num;
			isNeg = true;
		}
		/* Fill buffer with digit characters in reverse order */
		do {
			temp[i++] = (char) ((num % 10) + '0');
			num /= 10;
		} while (num != 0);
		StringBuilder b = new StringBuilder();
		if (isNeg)
			b.append('-');
		while (i > 0) {
			b.append(temp[--i]);
		}
		return b.toString();
	}

	static boolean isPalindrome(String str){
		
		int len = str.length();
		int j = len-1;
		for(int i=0;i<len/2;i++){
			if(str.charAt(i)!=str.charAt(j)){
				return false;
			}
			--j;

		}
		return true;
	}
	
	// The method that prints all possible strings of length k.  It is
    //  mainly a wrapper over recursive function printAllKLengthRec()
    static void printAllKLength(char set[], int k) {
        int n = set.length;        
        printAllKLengthRec(set, "", n, k);
    }
 
    // The main recursive method to print all possible strings of length k
    static void printAllKLengthRec(char set[], String prefix, int n, int k) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
 
        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + set[i]; 
             
            // k is decreased, because we have added a new character
            printAllKLengthRec(set, newPrefix, n, k - 1); 
        }
    }
}
