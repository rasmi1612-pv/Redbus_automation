package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    WebDriver driver;

    By acFilter = By.xpath("//div[contains(@class,'label___') and starts-with(normalize-space(),'AC (')]");
    By firstBusViewSeats = By.xpath("//li[contains(@aria-label,'Ambady Roadways')]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyACFilter() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	WebElement acFilter = wait.until(ExpectedConditions.elementToBeClickable(
    	        By.xpath("//div[contains(@class,'label___') and starts-with(normalize-space(),'AC (')]")
    	));

    	acFilter.click();
    }

    public void clickFirstBusSeats() {
        driver.findElement(firstBusViewSeats).click();
    }
}
