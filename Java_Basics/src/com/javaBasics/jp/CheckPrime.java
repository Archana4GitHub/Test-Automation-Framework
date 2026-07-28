package com.javaBasics.jp;

import java.util.Scanner;

public class CheckPrime {

	
    boolean isPrime = false;
	public int checkPrimeNumber(int num1) {
		int count=0;
		for(int i=2;i<=num1;i++)
		{
			if(num1%i==0)
			{
				count++;
				//isPrime = false;
				//break;
			}
			//			else {
			//				isPrime = true;
			//			}
		}
		System.out.println("Count in checkPrimeNumber: "+count);
		return count;
	}
	public boolean printCheckPrime(int counter) {
		System.out.println("Count in printCheckPrime: "+counter);
		if(counter==1) 
			return true;
		else
			return false;


	}

	public void printCheckingPrime(boolean flag,int num) {

		if(flag==true)
		{
			System.out.println(num + "is a Prime Number" );
		}
		else {
			System.out.println(num + "is not a Prime Number");
		}
	}


	public void printPrimeNumbers(int lowerRange,int upperRange) {
		for(int j=lowerRange;j<=upperRange; j++)
		{
		int counter=checkPrimeNumber(j);
			boolean isPrim = printCheckPrime(counter);
			if(isPrim)
			{
				System.out.println("Number is prime = "+j +"\n");
			}else {
				System.out.println("Number is not prime = "+j +"\n");
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckPrime cp=new CheckPrime();
		

		System.out.println("What do you want to do? \n Please choose from below options: \n 1. Check if Your Number is Prime or Not? \n  2. Print Prime Numbers " );
		Scanner sc= new Scanner(System.in);
		int option=sc.nextInt();

		switch(option){

		case 1: 
			System.out.println("Enter Your Number to Check Whether Prime or Not ?");
			int num=sc.nextInt();
			int isPrime_ct = cp.checkPrimeNumber(num);
			boolean flag=cp.printCheckPrime(isPrime_ct);
			cp.printCheckingPrime(flag,num);

			break;
		case 2:
			System.out.println("Enter the Range to find Prime Numbers:");
			int lowerRange=sc.nextInt();
			System.out.println("\n LowerRange= " + lowerRange);
			int upperRange=sc.nextInt();
			System.out.println("\n UpperRange= "  + upperRange);
			cp.printPrimeNumbers(lowerRange,upperRange);
			break;

		default:
			System.out.println("Please Enter Correct Option");

		}
		
		System.out.println(System.getProperty("java.version"));
















	}

}
