package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By fromCity = By.id("srcinput");
    By toCity = By.id("destinput");
    By datePicker = By.xpath("//div[contains(@class,'dateInputWrapper') and contains(@class,'dateHighlight')]");
    By searchBtn = By.xpath("//button[contains(@class,'primaryButton') and contains(@class,'searchButtonWrapper')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFromCity() {
    	WebElement from = driver.findElement(fromCity);
        from.clear();
        from.sendKeys("Kochi");

        // Wait for Kochi suggestion
        WebElement kochiOption = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@class,'item') or contains(@class,'sc-')][contains(.,'Kochi')]")
            )
        );

        // Use JS click to avoid dropdown closing
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", kochiOption);
    

    }

    public void enterToCity() {

        WebElement to = driver.findElement(toCity);
        to.sendKeys("Bangalore");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement bangaloreOption = wait.until(
        	    ExpectedConditions.elementToBeClickable(
        	        By.xpath("//*[contains(@class,'item') or contains(@class,'sc-')][contains(.,'Bangalore')]")
        	    )
        	);

        	((JavascriptExecutor)driver).executeScript("arguments[0].click();", bangaloreOption);
    }

    

    public void selectDate() {
    	driver.findElement(datePicker).click();

        
    	driver.findElement(datePicker).click();

        // Now click '31' inside the calendar
        WebElement date = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'calendarDate')]//span[text()='31']")
            )
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", date);
    }

    public void clickSearch() {
    	 wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }
    }

