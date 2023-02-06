package Lockersdigit;
import java.util.*;

public class LockersdigitService {

	
public static ArrayList<Integer> searchmatch(ArrayList<ArrayList<String>> sdata, String searchdata)
	
	{
	 
	ArrayList<ArrayList<String>> temp4 = new ArrayList<ArrayList<String>>();
	 ArrayList<Integer>  matchlist= new ArrayList<>();
	 String seardata = searchdata;
	 temp4=sdata;
	  int b,d,j,n;
	
	  try {
	 b=temp4.size();
	 
	 for(d=0;d<=b;d++)
	 {
		 
			j=temp4.get(d).size();
		     for(n=0;n<=j;j++)
		 {
			 if(temp4.get(d).get(n).equals(seardata))
			 {
				 matchlist.add(d);
				 break;
			 }
		 }
		
	 }
	 }catch (Exception e) 
		{
		 System.out.println(seardata+ "    Not found in database");
		 matchlist=null;  
		}
	 
	return matchlist;
	 }


	 
	 
public static void  Printlist(ArrayList<ArrayList<String>> pdata)
	
	 // Prints out files using lockmanagement.printarray()
	{
		
		ArrayList<ArrayList<String>> temp3 = new ArrayList<ArrayList<String>>();
		 temp3=pdata;
		 try { int arrlen= temp3.size();
		 int a;
		 for(a=0; a<=arrlen;a++)
			System.out.println(lockmanagement.printarray(temp3.get(a)));
		 }catch (Exception e) 
			{
			 System.out.println( "There are no files currently in database");
			   
			}
	}
	
	
	
public static ArrayList<ArrayList<String>> asendsort(ArrayList<ArrayList<String>> data)
	{
		// This function sorts the array list in ascending order.
		
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
	    ArrayList<ArrayList<String>> outputdata1 = new ArrayList<ArrayList<String>>();
	    
		ArrayList<String> compval = new ArrayList<>();
		temp=data;
		int len=temp.size();
		
		while(len > 0)
		{
			if (len>2)
			{
				compval= highascend(temp);
				 outputdata1.add(compval);
                 temp.remove(compval);
			}
		     
			else if (len==1) 
			{
				compval=comparefunc(temp.get(0),temp.get(1));
				outputdata1.add(compval);
				temp.remove(compval);
			}
			else 
			{
				
				outputdata1.add(temp.get(0));
		    }
			len=temp.size();
		}
		return outputdata1;
	}
	
	
public static ArrayList<String> highascend(ArrayList<ArrayList<String>> data)
	{
	 	
		ArrayList<ArrayList<String>> inputdata = new ArrayList<>();	
		ArrayList<String>  outputdata = new ArrayList<>();
		
		inputdata=data;
		int k=inputdata.size();
		int i;
		
		outputdata= comparefunc(inputdata.get(0),inputdata.get(1));
		
     	for (i=2; i<k; i++)
		{
			outputdata= comparefunc(inputdata.get(i),inputdata.get(i+1));
		}
		
		return outputdata;
		
	}		
	
	
	
	
public static ArrayList<String>  comparefunc( ArrayList<String> A, ArrayList<String> B)
	{
		
		ArrayList<String> Avar = new ArrayList<>();
		ArrayList<String> Bvar = new ArrayList<>();
		ArrayList<String> Rvar = new ArrayList<>();
		
		Avar =A;
		Bvar =B; 
		int k = Math.min(Avar.size(), Bvar.size());
		int i , compoutput;
		
		    for (i=0; i<=k;i++ ) 
	           {
			      compoutput=Avar.get(i).compareTo(Bvar.get(i));
		           if (compoutput > 0)            
                      {
			           Rvar= Bvar;
                       break;
                       }
			
                   else if (compoutput == 0)
                      {
            	       Rvar= Bvar;
                      }
                   else
                      {
            	      Rvar= Avar;
            	      break;
                      }
			   }
		    
			return Rvar;
            }
}

	
	
	
	
	
	
	
	
	
	
	
	
		
		
	


