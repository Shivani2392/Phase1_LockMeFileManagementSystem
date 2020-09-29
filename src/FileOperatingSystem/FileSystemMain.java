package FileOperatingSystem;

import java.lang.Exception;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;

public class FileSystemMain 
{
	// Main entry method of program
	public static void main(String[] args) 
	{
		MainPageMenu mp = new MainPageMenu();
			
		try
		{
			// Showing the welcome screen
			mp.welcomeScreenText();
			
			// Showing the Options to user
			mp.menuSelectionText();
			
			// Showing the text to ask user for the input
			mp.askingForUserInput();
			
			// Call to get the input and process the input
			mp.gettingAndprocessingTheInput();
		} catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
		catch(BusinessException ex)
		{
			System.err.println(ex.getMessage());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	

	
}
