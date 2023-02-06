package Lockersdigit;

import java.util.*;

public class lockmanagement {
	
 static Scanner sc = new Scanner(System.in);
	
public static String printarray(ArrayList<String> data)
{
	
   String printout= String.join("\\", data);
	
	return printout;
}



public static ArrayList <String> addfile() 
{
	char cfolder = 'y';
	String svar;
	ArrayList<String> inputarray = new ArrayList<>();
	 
	inputarray.add("C:");
			
	
	while (cfolder =='y')
	{
		System.out.println("Current dir  "+ printarray(inputarray) );
		
		cfolder = userinterface.confirmiput("create or enter folder name");
		if (cfolder =='y')
		{
			System.out.println("enter folder name" );
			svar=sc.next() ;
			inputarray.add(svar);
		}
		else
		{
			System.out.println("enter file name" );
			svar=sc.next() ;
			inputarray.add(svar);
			cfolder='n';
		}
}
	
	System.out.println(printarray(inputarray));
	return inputarray;
}



public static void displayMenu()
{		
System.out.println();	
System.out.println();	
System.out.println();	
System.out.println();
System.out.println();
System.out.println();
System.out.println("Choose one of the options, enter the number tallying to your choice");
System.out.println("1. List exiting file");
System.out.println("2. Add a file");
System.out.println("3. Delete a file");
System.out.println("4. Search for a file");
System.out.println("5.Logout");
System.out.println();
System.out.println();
System.out.println("Please enter Choice: ");

}


public static void displayWelcome()
{
System.out.println("Welcome ADMIN");
System.out.println("Locker's File Management System");
System.out.println("Created by: Emmanuel Anim-Annor");
}
}