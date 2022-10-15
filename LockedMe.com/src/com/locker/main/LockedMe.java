package com.locker.main;

import java.io.IOException;
import java.util.Scanner;

public class LockedMe {
 	
	public static void main(String[] args)  {
		
		try 
		{
			Features f1=new Features();
			Scanner sc=new Scanner(System.in);
			int ch=0;
			do 
			{
				System.out.println("==================================================================");
				System.out.println("||\t Welcome to Company Lockers-LockedMe.com\t\t||");
				System.out.println("||\t Developer Name : Akshay Hinge. \t\t\t||");
				System.out.println("==================================================================");
				System.out.println("\t-> 1.Display All Files");
				System.out.println("\t-> 2.Add File To the Application");
				System.out.println("\t-> 3.Delete any File from the Application");
				System.out.println("\t-> 4.Search any File from the Application");
				System.out.println("\t-> 5.Exit");
				System.out.println("==================================================================\n");
			             
				System.out.println("Enter your Choice.");
				ch=Integer.parseInt(sc.nextLine());
	
			switch(ch)
			{
				case 1:f1.Display_files(); 
					break;	
				case 2:f1.Add_files(); 
				 	break;	
				case 3:f1.Delete_files();  
					break;	
				case 4:f1.Search_files(); 
					break;	
				case 5:System.out.println("Appliction close Succesfully");
					System.exit(0); 
					break;	
				default :System.out.println("Please Enter valid Number.");
			}//Switch
			
		}while(ch<5);
		}//try
		catch(NumberFormatException e) {System.out.println("Please Enter a valid Number");}
	}//Main End
}
