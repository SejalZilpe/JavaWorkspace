package com.lnt.MavenTask;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Scanner sc =new Scanner(System.in);
       System.out.println("enter a string :");
       String str = sc.next();
       int length = getLength(str);
       System.out.println("the length of string is : "+length);
    }

	public static int getLength(String str) {
		
		char[] arr = str.toCharArray();
		int length=arr.length;
		return length;
	}
}
