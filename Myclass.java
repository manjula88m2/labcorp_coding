package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.List;
import java.time.*;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Myclass {

	@Test
	public void labcorpCoding() throws InterruptedException{

    	System.setProperty("webdriver.chrome.driver","C:\\Automation drivers\\geckodriver-v0.26.0-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.labcorp.com";
        
        driver.get(baseUrl);
        Thread.sleep(3000);
        ((JavascriptExecutor) driver)
        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.partialLinkText("Careers")).click();
        Thread.sleep(3000);
     
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        
        driver.findElement(By.xpath("//input[@placeholder='Enter a Keyword to Search']")).sendKeys("QA Test Automation Developer");
        driver.findElement(By.xpath("//input[@placeholder='Enter a Keyword to Search']")).submit();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"search-results-list\"]/ul/li[2]/a")).click();
        Thread.sleep(4000);
        String title = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/section[2]/h1")).getText();
        
        Assert.assertEquals(title, "Sr QA Analyst/Software-EE264");
        String jobLocation = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[1]/span[1]")).getText();
        String jobId = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[1]/span[2]")).getText();
        jobLocation = jobLocation.substring(jobLocation.indexOf("Burlington"));
        jobId = jobId.substring(jobId.indexOf("21"));
                
        String titleExpected = "Sr QA Analyst/Software-EE264";
        String jobIdExpected = "21-89963";
        String jobLocationExpected = "Burlington, North Carolina";
        String desc1Expected = "This Senior-level position requires hands-on experience with the workflow and operational processes and procedures of the Labcorp Lab System (LCLS) and Labcorp Worksheet System (LCWS).";
        String desc2Expected = "This position will require deep knowledge of both systems to support functional testing, lab and operational support and coordination with respective teams to help identify and resolve issues with software code.";
        String desc3Expected = "It requires the ability to identify, plan and execute testing activities to ensure high quality software and ensure compliance according to regulatory statues, policies and procedures.";
        
        Assert.assertEquals(title, titleExpected);
        Assert.assertEquals(jobId, jobIdExpected);
        Assert.assertEquals(jobLocation, jobLocationExpected);
        
        String desc1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[2]/ul/li[1]/span")).getText();
        Assert.assertEquals(desc1, desc1Expected);
        
        String desc2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[2]/ul/li[2]/span")).getText();
        Assert.assertEquals(desc2, desc2Expected);
  
        String desc3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[2]/ul/li[3]/span")).getText();
        Assert.assertEquals(desc3, desc3Expected);


        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/section[2]/div[2]/div/span/div/span/a")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"srccar\"]/adprm-sign-in-popover/div/div[3]/div[2]/div/div[1]/button")).click();
        Thread.sleep(1000);
        
        String textToCompare = "";

        textToCompare = driver.findElement(By.xpath("//*[@id=\"ae-main-content\"]/div/div/div[2]/div/div/div[1]/span[1]")).getText();
        Assert.assertEquals(textToCompare, titleExpected);

        textToCompare = driver.findElement(By.xpath("//*[@id=\"ae-main-content\"]/div/div/div[2]/div/div/div[1]/span[2]")).getText();
        Assert.assertEquals(textToCompare, "#" + jobIdExpected);

        textToCompare = driver.findElement(By.xpath("//*[@id=\"field3_right\"]/div[2]/ul/li[1]/span")).getText();
        Assert.assertEquals(textToCompare, desc1Expected);
        
        textToCompare = driver.findElement(By.xpath("//*[@id=\"field3_right\"]/div[2]/ul/li[2]/span")).getText();
        Assert.assertEquals(textToCompare, desc2Expected);
        
        textToCompare = driver.findElement(By.xpath("//*[@id=\"field3_right\"]/div[2]/ul/li[3]/span")).getText();
        Assert.assertEquals(textToCompare, desc3Expected);        
        
        driver.findElement(By.xpath("//*[@id=\"ae-main-content\"]/div/div/div[1]/button")).click();
        driver.quit();
}
}
