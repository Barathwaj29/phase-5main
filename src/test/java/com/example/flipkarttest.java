package com.example;

import java.util.NoSuchElementException;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkarttest {
	WebDriver wd;
	@Parameters("browser")
	@BeforeTest
	public void config(String browser) {
		switch(browser) {
			case "chrome":WebDriverManager.chromedriver().setup();
			wd=new ChromeDriver();
			break;
			case "edge":WebDriverManager.edgedriver().setup();
			wd=new EdgeDriver();
			break;
		}
		wd.manage().window().maximize();
	}
	@Parameters("url1")
  @Test
  public void chrome(String url1) throws InterruptedException {
		wd.get(url1);
		
		Long loadtime=(Long)((JavascriptExecutor)wd).executeScript("return performance.timing.loadEventEnd-performance.timing.navigationStart;");
		System.out.println("Load time of the website is:"+loadtime);
		wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
		wd.findElement(By.className("_3704LK")).sendKeys("iPhone 13");
		wd.findElement(By.className("_3704LK")).submit();
		Thread.sleep(3000);
		//to verfify it reached the bottom of the page as well as scroll bar features working or not
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("\nNavigated to bottom of the page");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		System.out.println("\nScroll Feature available");
		Thread.sleep(2000);

		//identify image
		WebElement i=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img"));
		 // Javascript executor to check image
	      Boolean p = (Boolean) ((JavascriptExecutor)wd) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

	     //verify if status is true
	      if (p) {
	         System.out.println("Logo present");
	      } else {
	         System.out.println("Logo not present");
	      }
	      Thread.sleep(3000);
	      
	      wd.navigate().refresh();
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(wd)							
					 .withTimeout(30, TimeUnit.SECONDS) 			
					.pollingEvery(5, TimeUnit.SECONDS) 			
					.ignoring(NoSuchElementException.class);
			
			
			
			
			WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
			
				public WebElement apply(WebDriver wd ) {
				//	return driver.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._3_C9Hx > div > a:nth-child(1) > img"));
					
					WebElement element= wd.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div.go_DOp._2errNR > div > div > div > a"));
					String getTextOnPage= element.getText();
					
					if(getTextOnPage.equals("Login")) {
						System.out.println(getTextOnPage);
						System.out.println("Passed");
						return element;
					}
					else {
						System.out.println("Fluent Wait Fail!, Element Not Loaded Yet");
						return null;
					}
					
					
				}
			});
			}
		
		
		
		
		
	@Parameters("url2")
	@Test
	public void edge(String url2) throws InterruptedException {
		wd.get(url2);
		Long loadtime=(Long)((JavascriptExecutor)wd).executeScript("return performance.timing.loadEventEnd-performance.timing.navigationStart;");
		System.out.println("Load time of the website is:"+loadtime);
		wd.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
		wd.findElement(By.className("_3704LK")).sendKeys("iPhone 13");
		wd.findElement(By.className("_3704LK")).submit();
		Thread.sleep(3000);
		//to verfify it reached the bottom of the page as well as scroll bar features working or not
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("\nNavigated to bottom of the page");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		System.out.println("\nScroll Feature available");
		Thread.sleep(2000);

		//identify image
		WebElement i=wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img"));
		 // Javascript executor to check image
	      Boolean p = (Boolean) ((JavascriptExecutor)wd) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

	     //verify if status is true
	      if (p) {
	         System.out.println("Logo present");
	      } else {
	         System.out.println("Logo not present");
	      }
	      Thread.sleep(3000);
	      
	      wd.navigate().refresh();
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(wd)							
					 .withTimeout(30, TimeUnit.SECONDS) 			
					.pollingEvery(5, TimeUnit.SECONDS) 			
					.ignoring(NoSuchElementException.class);
			
			
			
			
			WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
			
				public WebElement apply(WebDriver wd ) {
				//	return driver.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._3_C9Hx > div > a:nth-child(1) > img"));
					
					WebElement element= wd.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div.go_DOp._2errNR > div > div > div > a"));
					String getTextOnPage= element.getText();
					
					if(getTextOnPage.equals("Login")) {
						System.out.println(getTextOnPage);
						System.out.println("Passed");
						return element;
					}
					else {
						System.out.println("Fluent Wait Fail!, Element Not Loaded Yet");
						return null;
					}
					
					
				}
			});
	}
}

