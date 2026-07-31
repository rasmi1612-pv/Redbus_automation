package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerPage {

    WebDriver driver;

    By phone = By.xpath("//input[contains(@class,'inputField') and @placeholder='Phone']");
    By email = By.xpath("//input[contains(@class,'input___') and @placeholder='Enter email id']");
    By stateDropdown = By.xpath("//i[contains(@class,'icon___') and contains(@class,'ciicon-arrow_drop_down')]");
    By stateOptionKerala = By.xpath("//div[contains(@class,'listItem')][.//div[text()='Kerala']]");
    By name = By.xpath("//input[@aria-label='Name *']");
    By age = By.xpath("//input[@autocomplete='off' and @type='number' and contains(@class,'input___')]");
    By gender = By.xpath("//div[contains(@class,'toggleGroup') and @aria-label='Male']");
    By insuranceReject = By.xpath("//label[contains(@class,'customRadio') and @for='insuranceRejectBtn']");
    
   By proceedToPay = By.xpath("//button[@aria-label='Continue booking']");

    public PassengerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPassengerDetails() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	WebElement phoneField = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(phone)
    	);
    	phoneField.sendKeys("9999900000");
    	WebElement emailField = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(email)
    	);
    	emailField.sendKeys("test@gmail.com");
        // driver.findElement(name).sendKeys("Test User");
     	
        //driver.findElement(email).sendKeys("test@gmail.com");
        
    }
    
    public void selectState() {
        // Click dropdown
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Correct XPath (Parent div is clickable)
        By stateDropdown = By.xpath("//label[text()='State of Residence *']/parent::div");

        // 2. Convert By -> WebElement
        WebElement dropdownEle = wait1.until(ExpectedConditions.visibilityOfElementLocated(stateDropdown));

        // 3. JS Click (WebElement ONLY)
        js.executeScript("arguments[0].click();", dropdownEle);

        // 4. Now select Kerala
        By stateOptionKerala = By.xpath("//div[contains(@class,'listItem')][.//div[text()='Kerala']]");
        WebElement keralaEle = wait1.until(ExpectedConditions.visibilityOfElementLocated(stateOptionKerala));

        // 5. JS Click for option
        js.executeScript("arguments[0].click();", keralaEle);

    }
    
    public void personaldata() {
    	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement namefield = wait2.until(
     	        ExpectedConditions.visibilityOfElementLocated(name)
     	);
     	namefield.sendKeys("name");
         //driver.findElement(gender).click();
         //driver.findElement(age).sendKeys("25");
     	WebElement ageField = wait2.until(
     	        ExpectedConditions.visibilityOfElementLocated(age)
     	);
     	ageField.sendKeys("25");
     	
     	WebElement male = wait2.until(ExpectedConditions.visibilityOfElementLocated(gender));
        js.executeScript("arguments[0].click();", male);
        

        WebElement container = driver.findElement(By.xpath("//div[@id='0_passengerDetailsContent']"));
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 1000;", container);
        
        
        
        WebElement insReject = wait2.until(ExpectedConditions.visibilityOfElementLocated(insuranceReject));
        js.executeScript("arguments[0].click();", insReject);
     	
    	
    }

    public void clickProceedToPay() {
    	WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement cont = wait3.until(ExpectedConditions.elementToBeClickable(proceedToPay));
    	js.executeScript("arguments[0].click();", cont);
    }
}
