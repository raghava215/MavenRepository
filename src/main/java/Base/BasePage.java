package Base;


import java.io.File;
import java.util.List;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverManager;

public class BasePage  {

	public  WebDriver driver = null;
	DriverManager dr= new DriverManager();
	  public JavascriptExecutor executor;
	 
	  WebElement element;
	  
	  public BasePage() {
		  executor = (JavascriptExecutor) driver;
	    if (driver == null) {
	      try
	      {
//	        String browser = DriverManager.getFileDetails().getProperty("browser");
//	        System.out.println("Opening up " + browser + " Driver");
	        driver = DriverManager.getDriver("Sample.properties");
	        driver.manage().window().maximize();
	      }
	      catch (Exception e) {
	        throw new RuntimeException("Not able to initialize a driver", e);
	      }
	    }
	  }
//	  public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//
//	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//
//	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//	        File DestFile=new File(fileWithPath);
//
//	        FileUtils.copyFile(SrcFile, DestFile);	            
//
//	    }
//	  
	  public void openApp(String url) //laters
	  {
		driver.get(url);
	    //System.out.println("App page opened");
	  }
	  
	  public void WaitForElementTobeFound(By Element,long TIMEOUT) {
	    WebDriverWait w = new WebDriverWait(driver, TIMEOUT);
	    w.until(ExpectedConditions.presenceOfElementLocated(Element));
	  }
	  
	  
	  public void ClickElement(By Element) {
		  
	    driver.findElement(Element).click();
	  }
	  
	  public void SendText(By Element, String str,Long TIMEOUT)
	  {
		 WaitForElementTobeFound(Element, TIMEOUT);
	    driver.findElement(Element).sendKeys(str);
	  }
	  
//	  public void SendTextByName(String name, String str)
//	  {
//		  WaitForElementTobeFoundByName(name);
//		  driver.findElement(By.name(name)).clear();
//	    driver.findElement(By.name(name)).sendKeys(str);
//	  }
//	  public void SendTextByName(String name, Keys key)
//	  {
//		  WaitForElementTobeFoundByName(name);
//	    driver.findElement(By.name(name)).sendKeys(key);
//	  }
//	  
//	  public void SendTextByID(String ID, String str) {
//	    driver.findElement(By.xpath(ID)).sendKeys(str);
//	  }
	  public void SimpleWait()
	  {
		  //System.out.println("wait started");
		  try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //System.out.println("wait ended");
	  }
	  
	  public void RefreshPage() {
	    driver.navigate().refresh();
	  }
	  
	  public void MaximizeTheWindow() {
	    driver.manage().window().maximize();
	  }
	  
	  public void ClearText(String xpath) {
		    driver.findElement(By.xpath(xpath)).clear();
		  }
	  
	  public WebElement ReturnWebElementByXpath(String xpath)
	  {
		  System.out.println(xpath);
		  System.out.println("ans "+driver.findElement(By.xpath(xpath)).getSize());
		  return driver.findElement(By.xpath(xpath));
	  }
	  
	  public List<WebElement> FindElementsByTag(WebElement element,String tag)
	  {
		  System.out.println(element.toString()+"  "+tag);
		  List<WebElement> rows=element.findElements(By.tagName(tag));
		  
		  System.out.println("num elements"+rows.size());
		  return rows;
	  }
	  public List<WebElement> FindElementsByxpath(String xpath)
	  {
		  List<WebElement> rows=driver.findElements(By.xpath(xpath));
		  return rows;
	  }
	  public String GetTextByXpath(String xpath)
	  {
		  return driver.findElement(By.xpath(xpath)).getText().trim();
		   
	  }
	  
	  public void WaitForElementTobeClickableByXpath(String xpath) {
		    WebDriverWait w = new WebDriverWait(driver, 60L);
		    w.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		  }
	  
	  public boolean IsCheckedStatusByXpath(String xpath) {
		  return driver.findElement(By.xpath(xpath)).isSelected();
		  }
	  
	  public void ClickElementByWebElement(WebElement element)
	  {
		  element.click();
	  }
	  
	  public void javaScriptExecutorClick(WebElement element)
	  {
		  executor.executeScript("arguments[0].click();", element);
	  }
	  
	  public String findText(By Element,Long TIMEOUT)
	  {
		WaitForElementTobeFound(Element, TIMEOUT);
		  return driver.findElement(Element).getText();
		  
	  }
	  public String getPageTitle()
	  {
		  
		  return driver.getTitle();
	  }
	  
	  
	  
	   public void quitDriver()
	   {
		   driver.quit();
	   }
	  
	  public static void main(String[] args) {}
	
}
