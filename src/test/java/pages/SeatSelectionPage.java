package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeatSelectionPage {

    WebDriver driver;
    WebDriverWait wait;

    //By availableSeat = By.xpath("//span[@role='button' and contains(@aria-label,'Seat number L7')]"); 
    By availableSeat = By.xpath("//span[@role='button' and contains(@aria-label,'Seat number L4')]");
    By boardingPoint = By.xpath("//button[contains(@aria-label,'Select boarding')]");
    //By continueBtn = By.id("continue_btn");
    By pickup = By.xpath("//input[@name='bp_0']/following-sibling::label");
    By drop = By.xpath("//input[@name='dp_0']/following-sibling::label");
    By continueBtn = By.xpath("//div[contains(@class,'priceFooterContainer')]//button[@aria-label='Fill passenger details']");


    public SeatSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pickSeat() {
        driver.findElement(availableSeat).click();
    }

    public void chooseBoardingPoint1() {
    	 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // boarding/dropping popup container wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(@class,'bpdp') or contains(@class,'boarding')]")
        ));

        // locate the button AFTER popup appears
        WebElement btn = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(@aria-label,'Select boarding')]")
            )
        );

        // scroll & JS click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btn);
        js.executeScript("arguments[0].click();", btn);
    }

    //public void clickContinue() {
    //	JavascriptExecutor js = (JavascriptExecutor) driver;
    //	js.executeScript("arguments[0].click();", continueBtn);
    //}
    
    public void pickup1(String name) {

        // 1. Wait for boarding popup to load
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(
                //By.xpath("//label[@for='bp-point-0']")
       // ));
    	WebElement bp = driver.findElement(
    	        By.xpath("//div[@class='name___d51a5f' and normalize-space()='" + name + "']/ancestor::div[@role='radio']")
    	    );

    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript("arguments[0].scrollIntoView(true);", bp);
    	    js.executeScript(
    	        "var r = arguments[0].getBoundingClientRect();" +
    	        "document.elementFromPoint(r.left + (r.width/2), r.top + (r.height/2)).click();",
    	        bp
    	    );
    }

    // Select Dropping Point
    public void chooseDroppingPoint(String name) {

       
    	WebElement dp = driver.findElement(
    	        By.xpath("//div[@class='name___d51a5f' and normalize-space()='" + name + "']/ancestor::div[@role='radio']")
    	    );

    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript("arguments[0].scrollIntoView(true);", dp);
    	    js.executeScript(
    	        "var r = arguments[0].getBoundingClientRect();" +
    	        "document.elementFromPoint(r.left + (r.width/2), r.top + (r.height/2)).click();",
    	        dp
    	    );
    }
    public void clickContinue() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	WebElement contBtn = wait.until(
    	    ExpectedConditions.elementToBeClickable(continueBtn)
    	);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", contBtn);
    }
}
