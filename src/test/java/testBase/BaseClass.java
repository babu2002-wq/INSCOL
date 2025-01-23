package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import PageObjects.SignIn;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseClass {
	
public static WebDriver driver;

      @BeforeClass
      @Parameters({"os","browser"})
      public void setup(String os,String bro) throws IOException {
    	  
    	  switch(bro.toLowerCase()) {
    	  case "chrome": driver=new ChromeDriver();break;
    	  case "edge":driver=new EdgeDriver();break;
    	  case "firefox":driver=new FirefoxDriver();break;
    	  default:System.out.println("Invalid browser");return;
    	  }
    	  
    	  driver.manage().deleteAllCookies();
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	  driver.get("https://erpindia.inscol.com/auth/sign-in");
    	  driver.manage().window().maximize();
      }
      
      
      @AfterClass
      public void teardown() {
    	  driver.quit();
      }
      
      
      
      public String captureScreen(String tname) throws IOException {
    	  String time=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	  TakesScreenshot takescreen=(TakesScreenshot) driver;
    	  File sourcefile=takescreen.getScreenshotAs(OutputType.FILE);
    	  String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_"+ time + ".png";
    	  File targetFile=new File(targetFilePath);
    	  sourcefile.renameTo(targetFile);
    	  return targetFilePath;
      }
      
      
            
	
	

}
