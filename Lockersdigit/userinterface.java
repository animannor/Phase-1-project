package Lockersdigit;


// import java.io.File; Would have added this package if i was to create actual files

import java.io.IOException;

import java.util.*;
public class userinterface {

		
public static int inputchoice ()

	{
		Scanner insc = new Scanner(System.in);
		boolean ChoiceState = true; 
			int choice = 0;
		
		   while(ChoiceState) 
		      { 
			   lockmanagement.displayMenu();
				try { choice = insc.nextInt(); 
				} catch (InputMismatchException e)
				   {
					  System.out.println("Please enter a number in the range of 1 to 5 ");
					  
				   }
				if (choice > 0 & choice < 6)
				{
					ChoiceState = false;
													 
				}
				
					      
             }
		   return choice;
	}
		
 public static char confirmiput (String input)
   {
	 Scanner confirmsc = new Scanner(System.in);
	 String choice1; 
	 int inputcount = 0 ;
	 char choice='o';
	 
	 System.out.println("Please enter y for yes or n for no, if you will like to  " + input );
	 choice1 = confirmsc.next();
	 
	 while(inputcount<=1)
	   {
		 if(choice1.charAt(0) =='y' ||choice1.charAt(0) =='n' )
			 
		 {
			 choice=choice1.charAt(0); 
			 inputcount=2;
		 }
	     
		 else 
		  {
	        System.out.println("Wrong entry, Please enter y for yes or n for no, if you will like to  " + input );
	         choice1 = confirmsc.next();
	         inputcount++;
		  }
		 
	   }
		
	 return choice;
	 
   }
   
 

	public static void main(String[] args) 
	 {
				
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<String>> filedata = new ArrayList<>();
		ArrayList<String> filepath = new ArrayList<>();
		int factor;     
		lockmanagement.displayWelcome();
		char mainloop = 'y';
		
		while(mainloop=='y')
		{
		
		factor = inputchoice();
			 
			      switch(factor) {
			case 1:
				// Display exiting file in database
				
				if (filepath==null )
				{
					System.out.println("There are no files in the database " );
				}
				else 
				{
					LockersdigitService.Printlist(filedata);
				}				
				
							
			break;
			
			case 2: 
				// Receives inputs and adds files to database
				char addloopstate = 'y';
				while (addloopstate=='y')
				{
				filepath=lockmanagement.addfile();
				filedata.add(filepath);
				
				// would added created an actual file in memory with 
				//File myFile = new File(fileName);
				//myFile.createNewFile(); if i had to. Per this codes i decided not 
				//create actual files.
				
				System.out.println("New file successfully added to database");
				addloopstate= confirmiput("add another file");
				}
				
		        break;
				
			 case 3:
				 
				 // Search File database
				 ArrayList<Integer>  dmatchlist = new ArrayList<>();
				 char d;
				 char deletestate ='y';
				 int t;
				 String deleteinfo;
				 while(deletestate=='y')
				 {
				 System.out.println("Enter folder or file name you want to search with :");
					deleteinfo=sc.next();
				 dmatchlist= LockersdigitService.searchmatch(filedata, deleteinfo);
				 
				 if (dmatchlist== null) 
				     {
					 System.out.println(" The file doesnot not exit.");
				     }
				 else
				 {
				 for (t=0;t<=dmatchlist.size();t++)				 
				    {
					System.out.println(lockmanagement.printarray(filedata.get(t))); 
					 d= confirmiput(" delete this file");
					  if (d=='y')
					  {
						  filedata.remove(dmatchlist.get(t));
						  
						  System.out.println("File successfully deleted");
					  }
				     }
				  }
				 deletestate=confirmiput(" do more deletion");
			        }
			      
		           
				break;
				
			case 4 :
				
				// Search file database using input
				ArrayList<Integer>  Smatchlist = new ArrayList<>();
				Smatchlist= null;
				int f,y;
				char seachstate = 'y';
				String searchinfo;
				while (seachstate =='y')
				{
				System.out.println("Enter folder or file name you want to search with :");
				searchinfo=sc.next();
				Smatchlist=LockersdigitService.searchmatch(filedata, searchinfo);
				
	            if(Smatchlist== null)
				   {
					 System.out.println("No match found");
				   }
				 else
				 {
					y=Smatchlist.size();
					 for(f=0;f<=y;f++)
					 {
						 System.out.println(lockmanagement.printarray(filedata.get(f))); 
					 }
				 }
				 seachstate=confirmiput("perform another search");
				}
				 		        				
				break;
			case 5:
			{
				System.out.println("Thank you for choosing us. You are now logged out :");
				System.exit(0);
			}
				break;
			
            }
			      
			      mainloop=confirmiput("go back to menu");
			      
	        }
		System.out.println("Thank you for choosing us. You are now logged out :");
		System.exit(0);
	}
		
	}


