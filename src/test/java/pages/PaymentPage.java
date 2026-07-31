package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PaymentPage {

    WebDriver driver;

    By payBtn = By.xpath("//div[@role='radio' and @aria-label='Pay through QR code']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void isPaymentPageLoaded() {
        try {
            //return driver.findElement(payBtn).isDisplayed();
        
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	JavascriptExecutor js = (JavascriptExecutor) driver;

        	WebElement radio = wait.until(ExpectedConditions.visibilityOfElementLocated(payBtn));
        	js.executeScript("arguments[0].click();", radio);
        } catch (Exception e) {
        	System.out.println("Payment page radio button not clickable yet: " + e.getMessage());
        }
    }
}
