package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileProperties {

	String userdir;
	
	  public  Properties getFileDetails(String FileName) throws IOException
	  {
		userdir=System.getProperty("user.dir"); 		
	    FileReader rd = new FileReader(userdir+"\\"+FileName);
	    Properties pr = new Properties();
	    pr.load(rd); 
	    return pr;
	  }
	  
	
	
//	  public static void main(String[] args) throws IOException {
//			// TODO Auto-generated method stub
//		 System.out.println(new FileProperties().getFileDetails("Sample.properties").getProperty("browser"));
//
//		}
//
//	

}
