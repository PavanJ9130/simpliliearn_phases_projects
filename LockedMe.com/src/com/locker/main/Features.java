package com.locker.main;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.*;

public class Features {
	public static String FilePath="F:\\Simpli learn\\phase 1\\LockedMe.com\\LockedMe Files"; 
	
	public static void Display_files() 
	{
		File[] f = new File(FilePath).listFiles();
		try 
		{
			if(f.length==0) 
			{
				System.out.println("!files Not found ");	
			}
			else 
			{
				for(var a:f)	
				 if(a.isFile()) 
				 	System.out.println(a.getName());		
			}
		}
		catch(NumberFormatException ex) 
		{
			System.out.println("Please Enter a valid Number! ");
		}
		catch(Exception ex)
		{
			System.out.println("Some Error occurred");
		}
	}//Display_files()
	
	public static void Add_files()  {
		try
		{

			Scanner sc=new Scanner(System.in);
			boolean flag=true;
			
			System.out.println("Set a File Name :");
			String File_Name=sc.nextLine();
			
			
			File[] found = new File(FilePath).listFiles();
			FileWriter f=new FileWriter(FilePath+"\\"+File_Name+".txt");
			BufferedWriter bw= new BufferedWriter(f);
				for(int j=0;j<found.length;j++) {
				if(found[j].getPath().equals(FilePath+"\\"+File_Name+".txt"))
				{
					System.out.println("File is already exists!");
					flag=false;
				}
				}//for
				if(flag)
				{
					System.out.println("How many Lines you want to enter in a file :");
					int Lines=Integer.parseInt(sc.nextLine());
				for (int i = 1; i <= Lines; i++) 
				{
					System.out.println("Enter a "+ i + " Line :");
					bw.write(sc.next()+"\n");
				}
					bw.close();		    
					System.out.println("File Created succesfully.");
				}
				
		}//try
		catch(NumberFormatException ex) 
		{
			System.out.println("Please Enter valid Number");
		}
		catch(Exception ex) 
		{
			System.out.println("Some Error Occurred");
		}
		
		
	}//Add_Files()
	public static void Delete_files() {
		
		File[] f = new File(FilePath).listFiles();
		Scanner sc=new Scanner(System.in);
		try 
		{
		System.out.println("1.Delete All Files.");
		System.out.println("2.Delete Specific File.");
		System.out.println("Enter Your Choice");
		int select=sc.nextInt();
		String File_Name;
		switch(select) 
		{
			case 1:
			{
				if(f.length==0) 
				{
				System.out.println("!files Not found ");	
				}
				else 
				{
				for(var a:f)	
				 if(a.isFile()) 
				 	a.delete();		
				}
				System.out.println("All Files deleted.");
				break;
			}
			case 2:
			{
				System.out.println("Enter a File Name which you want to Delete.");
				File_Name =sc.next();
				File file=new File(FilePath+"\\"+File_Name+".txt");
		
				if(file.exists()) 
				{
					if(file.isFile()) 
					{
						file.delete();	
						System.out.println(File_Name +" File Deleted Succesfully.");
					}
				}
			
				else 
				{
					System.out.println(File_Name+" File Not Found!");
					
				}
				break;
			}
			default :{System.out.println("Choose the right option");}
			sc.close();
		}//Switch
		}//try
		catch(NumberFormatException ex) 
		{
			System.out.println("Please Enter a valid Number! ");
		}
		catch (InputMismatchException e) {
		    System.out.print("Please Enter a valid Number!");
		}
		catch(Exception ex)
		{
			System.out.println("Some Error occurred.");
		}
		
	}//Delete_files()
	public static void Search_files() 
	{
		
		
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a File Name to be Search.");
			String File_Name =sc.nextLine();
			File file=new File(FilePath+"\\"+File_Name+".txt");
			String[] File_ext=File_Name.split("[.]");
				if(File_ext[0]==File_Name) 
				{
					if(file.exists()) 
					{
							System.out.println(file.getName());
							System.out.println(File_Name +" File Found Succesfully.");						
					}
					else 
					{
						System.out.println(File_Name+" File Not Found!");
						
					}
				}else 
				{
					if(File_ext[1].equals("txt")) 
					{
						Search_files(File_Name);
					}
					else 
					{
						System.out.println("File Not Found");
						}
				}
					
		}//try
		catch(NumberFormatException ex) 
		{
			System.out.println("Please Enter a valid Number! ");
		}
		catch (InputMismatchException e) {
		    System.out.print("Please Enter a valid Number!");
		}
		catch(Exception ex)
		{
			System.out.println("Some Error occurred.");
		}
	}//Search_File() 

	public static void Search_files(String File_Name) {

		try {
		File file=new File(FilePath+"\\"+File_Name);
		if(file.exists()) 
		{
			if(file.isFile()) 
			{	
				System.out.println(file.getName());
				System.out.println(File_Name+" File Found Succesfully.");
				
		
			}
		}
		else 
		{
			System.out.println(File_Name+" File Not Found!");
			
		}
		}//try
		catch(Exception e)
		{System.out.println("Some Error occurred");}
		
	}//Search_File()

	
}//Main 

