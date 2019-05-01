package Utils;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.FileProperties;

public class DriverManager  {	
	      FileProperties fP=new FileProperties();
	     static WebDriver driver;

	  public static  WebDriver getDriver(String FileName) 
	  {
		  FileProperties fP=new FileProperties();
		  
		  
	    String browser;
		try {
			browser = fP.getFileDetails(FileName).getProperty("browser");
		
	    if (browser.equalsIgnoreCase("firefox"))
	    {
	       driver=  getfirfoxdriver();
	    }
	    if (browser.equalsIgnoreCase("chrome"))
	    {
	      driver= getChromeDriver();
	    }
	    if (browser.equalsIgnoreCase("Edge"))
	    {
	      driver= getedgedriver();
	    }
	    if (browser.equalsIgnoreCase("IE"))
	    {
	      driver= getIEDrvier();
	    }
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return driver;
	  }
	  
	 private static  WebDriver getChromeDriver() 
	  { 
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\libs\\chromedriver.exe");
	    return new ChromeDriver();
	  }
	  
	  private static  WebDriver getfirfoxdriver() 
	  { 
		  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\libs\\geckodriver.exe");
	    return new FirefoxDriver();
	  }
	  
	  private static WebDriver getedgedriver() 
	  { 
		  System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\libs\\MicrosoftWebDriver.exe");
	    return new EdgeDriver();
	  }
	
	  private static  WebDriver getIEDrvier() 
	  { 
		  System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\libs\\IEDriverServer.exe");
	    return new InternetExplorerDriver();
	  }
	
	

	public static void main(String[] args) {		
		
//		new DriverManager().getDriver("Sample.properties").get("https://www.guru99.com/cross-browser-testing-using-selenium.html");
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\libs\\chromedriver.exe");
		   WebDriver d = new ChromeDriver();
		   WebDriverWait w = new WebDriverWait(d, 30);
		   d.get("https://bi-dev-acc-reporting-dashboard-web-app-ne01.azurewebsites.net/");
		   d.manage().window().maximize();
		   w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"okta-signin-username\"]")));
		   d.findElement(By.xpath("//*[@id=\"okta-signin-username\"]")).sendKeys("BI-HYP-UITEST1");
		   d.findElement(By.xpath("//*[@id=\"okta-signin-password\"]")).sendKeys("XT78Va61");
		   d.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
		   w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-tab-content-0-0\"]//button/i")));
		   System.out.println("Page loaded successfully");
		   

	}

}
