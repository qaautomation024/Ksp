package com.testScripts;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericmethods.Base;
import com.genericmethods.eventlist;
import com.objectRepo.HomePage;
@Listeners(eventlist.class)

public class HomeTest extends Base {

	@Test(priority = 1)
	public void newHotelManagment() throws InterruptedException, AWTException {
		loadPropertiesFile();

		if (prop == null) {
			throw new NullPointerException("Properties file not loaded successfully.");
		}
		HomePage page = new HomePage(driver);
		 JavascriptExecutor js = (JavascriptExecutor) driver;

//		page.getSearch().click();
//		Thread.sleep(3000);
//		page.getSearch().sendKeys(prop.getProperty("search"));
//		page.getAssetBlueBeetle().click();

		Thread.sleep(3000);
		page.getVOD().click();
		
		Long loadTime = (Long) js.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Page load time from Home to VOD screen: " + loadTime + " milliseconds");
		Thread.sleep(5000);
		
//		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		 
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		
		String[] rails = { "Action Movies",
				           "Thriller", 
				           "Horror", 
				           "Scifi & Fantasy", 
				           "Crime & Thriller",
				           "Must Watch Movies"
				         };
		
		
		for (String rail : rails) {
			By railLocator = By.xpath("//*[contains(text(), '" + rail + "')]");
			
			 try {
			WebElement railElement = wait.until(ExpectedConditions.visibilityOfElementLocated(railLocator));
			Thread.sleep(3000);
			
			js.executeScript("arguments[0].scrollIntoView();", railElement);
			Thread.sleep(5000);
			
		//page.getActionGotoNextSlide().click();
			//Thread.sleep(5000);
			//WebElement railElement1 = driver.findElement(railLocator);
			Assert.assertTrue(railElement.isDisplayed(), rail + " rail is not displayed.");
			System.out.println(rail + " rail is displayed.");
		} catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println(rail + " rail is not found.");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println(rail + " rail is not visible within the timeout period.");
        }
		}
		
		js.executeScript("window.scrollTo(0, 0);");
		
		WebElement ele = page.getAssetBlueBeetle();
		int width = ele.getSize().getWidth();
		int height = ele.getSize().getHeight();

		// Calculate the aspect ratio
		double aspectRatio = (double) width / height;

		// Print the results
		System.out.println("Video Width: " + width);
		System.out.println("Video Height: " + height);
		System.out.println("Aspect Ratio: " + aspectRatio);

		// to click on assets
		long vodToAssetStartTime = System.currentTimeMillis();
		page.getAssetBlueBeetle().click();
		 long vodToAssetEndTime = System.currentTimeMillis();
		 System.out.println("Page load time from VOD screen to Asset: " + (vodToAssetEndTime - vodToAssetStartTime)  / 1000.0 + " milliseconds");
		Thread.sleep(2000);
		page.getAddMylist().click();
		Thread.sleep(2000);
		page.getAddMylist().click();
		Thread.sleep(2000);
		page.getShare().click();
		Thread.sleep(3000);
		page.getClosesharebtn().click();
		Thread.sleep(3000);
		long vodToplayerscreentStartTime = System.currentTimeMillis();
		page.getPlaybtn().click();
		long assetToPlayerEndTime = System.currentTimeMillis();
        System.out.println("Page load time from Asset to Player screen: " + (assetToPlayerEndTime - vodToplayerscreentStartTime)  / 1000.0 + " milliseconds");
		Thread.sleep(4000);

		WebElement doubleclick = page.getPlayerdoubleclick();
		Actions act = new Actions(driver);
		act.doubleClick(doubleclick).perform();
		

		Thread.sleep(3000);
		/*page.getBackward().click();
		Thread.sleep(4000);
		page.getBackward().click();
		Thread.sleep(3000);
		page.getForward().click();
		Thread.sleep(2000);
		page.getForward().click();
		Thread.sleep(4000);
		act.click().perform();
		Thread.sleep(5000);
		act.click().perform();
		Thread.sleep(10000);   */
		
		//mute/unmutes
		Thread.sleep(4000);
		act.moveToElement(page.getMuteUnmute()).click();
		Thread.sleep(3000);
		act.moveToElement(page.getSettings()).click();
		Thread.sleep(5000);
		act.moveToElement(page.getPictureinPicture()).click();
		//page.getPictureinPicture().click();
		Thread.sleep(3000);
//		act.sendKeys("\u0020").perform();
//		Thread.sleep(5000);
		
				
		act.doubleClick(doubleclick).perform();
		//back button on player screen
		Thread.sleep(2000);
		page.getBackbtnplayerscreen().click();
		System.out.println("Navigated to CD page successfully! from player screen");
		//back button from the CD page
		Thread.sleep(2000);
		page.getBackbtnplayerscreen().click();
		Thread.sleep(2000);
		
		page.getOriginalNextslide().click();
		Thread.sleep(2000);
		page.getOriginalNextslide().click();
		Thread.sleep(2000);
		page.getActionGotoNextSlide().click();
		Thread.sleep(2000);
		page.getActionGotoNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailsecNextSlide().click();
		Thread.sleep(2000);
		page.getSmallrailsecNextSlide().click();
		Thread.sleep(2000);
			
		WebElement nextslidebtn = page.getBannerNextSlide();
		int maxClick = 5;
		for(int i=0; i<maxClick; i++)
		{
			nextslidebtn.click();
			Thread.sleep(2000);
		}
		
//		page.getSearch().click();
//		Thread.sleep(3000);
//		page.getSearch().sendKeys(prop.getProperty("search"));
//		page.getAssetBlueBeetle().click();
		
		//driver.navigate().refresh(); 
		Thread.sleep(3000);
					
	}

}
