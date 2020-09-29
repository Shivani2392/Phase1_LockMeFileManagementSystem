package FileOperatingSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CurrentFileListDisplay
{
	
	public void sortAndDisplay() throws BusinessException, IOException
	{
		File f = new File("RootDirectory");
		
		List<String> names = new ArrayList<String>(Arrays.asList(f.list()));//---->f.list() will return only list of files
		//System.out.println(names);
		 if(names.isEmpty())
		    {
			 
			 System.out.println(f.getName()+"Directory is empty there is no file");
			 
		    }
		 else
		 {

		   Collections.sort(names);
		
		   display(names);
		   System.out.println("||FOR FURTHER PROCESS CHECK AVAILABLE OPTIONS|| ");
	       MainPageMenu mainpagemenu=new MainPageMenu();
	       mainpagemenu.menuSelectionText();
	       mainpagemenu.askingForUserInput();
	       mainpagemenu.gettingAndprocessingTheInput();
		 }
	    
	}

	private void display(List<String> names) {
		System.out.println("BELOW IS THE LIST OF CURRENT FILES IN EXISTING DIRECTORY: ");
		for(String sName : names)
		{
			System.out.println(sName);
		}
	}
		
}