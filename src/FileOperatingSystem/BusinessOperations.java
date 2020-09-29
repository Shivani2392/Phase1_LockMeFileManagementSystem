package FileOperatingSystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class BusinessOperations  {
	/**
	 * This method is used to show the business operation choices like add,search,delete files from root directory for the user
	 * and according to the user selected option call that functionality by calling other methods.
	 * @throws IOException 
	 * @throws BusinessException
	 */
	
	public  void businessoperationoption() throws BusinessException, IOException  
	{
		  System.out.println("PLEASE SELECT BUSINESSOPERATION: ");
		  
		  System.out.println("1-Add File"+"\n2-Delete File"+""+"\n3-Search File"+"\n4-Back to MainMenu");
		  
		  Scanner s=new Scanner(System.in);
		  
		  while(!s.hasNextInt())
		      {
			  
			  //validate whether user has entered right input type which is asked in options or not
		    	System.out.println("That's not a number,Please select option in the form of number");
		    	s.next();
		    	businessoperationoption();
		      
		       }
		  int userbusinessoperation=Integer.parseInt(s.next());
		  
		  
		  switch(userbusinessoperation)
		    {
		      case 1:System.out.println("You entered for option 1-Add File");
		              adduserepecifiedFile();
		             break;
		      case 2:System.out.println("You entered for option 2-Delete File");
		               DeleteUserSpecifiedFile();
		             break;
		      case 3:System.out.println("You entered for option 3-Search File");
		               SearchOperation();
		             break;
		      case 4:System.out.println("You entered for option 4-Back to MainMenu");
		             MainPageMenu mp1=new MainPageMenu();
			         mp1.menuSelectionText();
			         mp1.askingForUserInput();
			         mp1.gettingAndprocessingTheInput();
		             break;
		     default:System.out.println("invalid menu item, please try again");
		             businessoperationoption();
		             break;		         
		     }
		  s.close();	
	  }
	
	//1.Function for adding the files specified by the user
	private  void adduserepecifiedFile() throws IOException, BusinessException
	    {
		   System.out.print("Enter The File Name For ADDING It:  ");
		
	    // Scanner for user input for the filename which user want to add
		
	       Scanner userinputforfilename = new Scanner( System.in ); 
           String userspecifiedfilenametoadd=userinputforfilename.nextLine();
           
           
        	   
        	   if(userspecifiedfilenametoadd.equalsIgnoreCase(userspecifiedfilenametoadd))
               {
                 //Creating（or adding) file to the existing directory
          	   
                 File file=new File("RootDirectory\\"+userspecifiedfilenametoadd+ ".txt");               
                 if (file.createNewFile())
                 {
        		       System.out.println("File is added!");
        		       
        		       System.out.println("Do you want to add another file.\nPlease press Y to add or N to return to previous menu :");
        		       //Scanner sc1 = new Scanner( System.in ); 
                     String answer=UserInputScannerClass.askuserforinput();
                     answer = answer.toLowerCase();
  					if(answer.equals("y")) 
  					{
  						adduserepecifiedFile(); 
        		        }
  					else if(answer.equals("n")) 
  					{
  						businessoperationoption();
        		        }
  					else
  					{
  						System.err.println("ERROR: Innvalid selection. Select Y or N..");
  						adduserepecifiedFile();
  						//adduserepecifiedFile();------->yha se wapas kaise jaye y or no option pr ?
  						
  					}
        		    }
                  else
                  {
                  	System.out.println("File is already exists!!! Please enter different file name");
                  	adduserepecifiedFile();
        		    }	
  	        }
        	   
          
           userinputforfilename.close();
	    }
	private void DeleteUserSpecifiedFile() throws IOException,NoSuchFileException,BusinessException
	{   
		File dir = new File("RootDirectory");
	
     	//for(String fileName : dir.list())
   	    // System.out.println(fileName);
		
     	System.out.println("Enterfile name for delete it: ");
     	String fname=UserInputScannerClass.askuserforinput();
     	exists(dir, fname);
     	
	}
	//Method for searching the user specified file
	private void SearchOperation() throws BusinessException, IOException
	{
		
		boolean fsearch=false;
		File f = new File("RootDirectory");
		
		//ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));//------>along with path
		//System.out.println(files);
		
		//Taking file list from the directory/folder into arraylist
		
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));//---->f.list() will return only list of files
		//System.out.println(names);
		System.out.println("Enter file name for search: ");
		
		 String filetosearch1 = UserInputScannerClass.askuserforinput(); 
		 String filetosearch=filetosearch1+".txt";
		 
		 filetosearch.equalsIgnoreCase(filetosearch);
		{
		
		 if(names.isEmpty())
		    {
			 
			 System.out.println(f.getName()+"Directory is empty there is no file");
			 
		    }
		 
		if(names.contains(filetosearch))
		    {
			 fsearch=true;
			 System.out.println("Your file is searched!! ");
			 System.out.println("Do you want to Search another file.\nPlease press Y to search or N to return to previous menu :");
		       //Scanner sc1 = new Scanner( System.in ); 
             String answer=UserInputScannerClass.askuserforinput();
             answer = answer.toLowerCase();
				if(answer.equals("y")) 
				{
					SearchOperation(); 
		        }
				else
					if(answer.equals("n")) 
				   {
					businessoperationoption();
		           }
				   else
				   {
					System.err.println("ERROR: Innvalid selection. Select Y or N..");
					SearchOperation(); 
					//adduserepecifiedFile();------->yha se wapas kaise jaye y or no option pr ?
			       }
			 
		      }
		 else 
			  if(fsearch == false)
	          {
	    	    System.out.println("File" +" "+ filetosearch +" "+ " does not exists, please check the name and enter again");
	    	    SearchOperation(); 
	          }
		
	     }
	}
	
	
	
	// DeleteUserSpecifiedFile() will call exists() method to check case sensitivity of filename entered by user to delete
	
	private  boolean exists(File dir, String filename) throws NoSuchFileException, IOException, BusinessException
	{
		boolean bFileExists = false;
		filename = filename + ".txt";
	    String[] files = dir.list();
	    
	    for(String file : files)
	    {
	        if(file.equals(filename))
	        {
	        	bFileExists = true;
	            System.out.println("File exist");
	               
	            	Files.delete(Paths.get("RootDirectory\\"+filename));
	            	System.out.println(filename+"is Deleted Successfully!!");
	            	 System.out.println("Do you want to delete another file.\nPlease press Y to delete or N to return to previous menu :");
	      		       //Scanner sc1 = new Scanner( System.in ); 
	                   String ans=UserInputScannerClass.askuserforinput();
	                   ans = ans.toLowerCase();
						if(ans.equals("y")) 
						{
							DeleteUserSpecifiedFile(); 
	      		        }
						else if(ans.equals("n")) 
						{
							businessoperationoption();
	      		        }
						else
						{
							System.err.println("ERROR: Innvalid selection. Select Y or N..");
							DeleteUserSpecifiedFile();
														
						}
				 
	        }  
	        
	    }
	    
	    if(bFileExists == false)
	    {
	    	System.out.println("File " + filename+ " does not exists, please check the name and enter again");
	    	//throw new BusinessException("File Not Found ");
	        DeleteUserSpecifiedFile();
	    }
	    
		return false;
	   
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
