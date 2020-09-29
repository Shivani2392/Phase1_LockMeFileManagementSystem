package FileOperatingSystem;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPageMenu  {
		
	// The method to show the welcome screen
	public void welcomeScreenText()
	{
		System.out.println("***Welcome To Locker Pvt.Ltd***");
		System.out.println("PRODUCT NAME : LockedMeFileManagementSystem");
		System.out.println("DEVELOPER    : Shivani Maski");
		System.out.println("VERSION      : v1.0");
	}

	// The method to show the menu option on screen
	public void menuSelectionText()
	{
		System.out.println();
		System.out.println("Below are the list of available options : ");
		System.out.println("1-Display Current File Name List in ascending order");
		System.out.println("2-Business Operations");
		System.out.println("3-Close Application");
	}

	// The method to show the menu option on screen
	public void askingForUserInput()
	{
		System.out.println();
		System.out.println("Please select Number (1 or 2 or 3) for performing the operation. Waiting for your input...");
	}
	
	/**
	 * This method is used for first getting the user input using Scanner method and then processing the input
	 * It also handles the exception or invalid input by user.
	 * @throws IOException 
	 */
	public void gettingAndprocessingTheInput() throws BusinessException, IOException 
	{
		// Asking for the input
        Scanner sc =new Scanner(System.in);
	    if(sc.hasNextInt() == false)
	    {
	    	System.err.println("ERROR: Invalid selection. Please select 1 or 2 or 3 option");
	    	menuSelectionText();
	    	askingForUserInput();
	    	gettingAndprocessingTheInput();
	    }
        
		/*
		 * while(!sc.hasNextInt()) {
		 * 
		 * sc.next(); welcomeSrceen(); }
		 */        
        
	    
	    int inputfromuser = Integer.parseInt(sc.next());
   
        switch(inputfromuser) 
        {
		 		case 1	:	System.out.println("You selected Option 1 CurrentFileNames in ascending order");
		 					CurrentFileListDisplay obj = new CurrentFileListDisplay();
		 					obj.sortAndDisplay();
		 					break;
		
		 		case 2	:	System.out.println("You selected Option 2 BusinessOperations:");
		 		            BusinessOperations b=new BusinessOperations();
		 					b.businessoperationoption();
		 					break;
		 		
		 		case 3	:	System.out.println("You selected Option 3-Close Application");
		 					System.out.println("Exiting the application. See you again. Bye bye");
		 					System.exit(0);
		 		
		 		default	:	System.out.println("invalid menu item, please enter a valid option number");
		 		            askingForUserInput();
		 		            gettingAndprocessingTheInput();
		 					break;
	    }
        
       sc.close();
        
	}
	


}
	
