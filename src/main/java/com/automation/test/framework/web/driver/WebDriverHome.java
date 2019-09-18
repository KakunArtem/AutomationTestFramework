package com.automation.test.framework.web.driver;

import com.automation.test.framework.web.utils.Selectors;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverHome {
    private static final int WAIT_SECONDS = 40;
    private static final int POLLING_SECONDS = 1;

    private WebDriver driver;
    private final WebDriverFactory webDriverFactory;

//    public WebDriverHome(WebDriver driver){
//        this.driver = driver;
//        driver.manage().window().maximize();
//    }

    public WebDriverHome(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

    public void initDriver(String browserType, String browserVersion){
       this.driver =  webDriverFactory.initializeDriver(browserType, browserVersion);
       driver.manage()
             .window()
             .maximize();
    }

    public boolean driverIsRunning() {
        return driver != null;
    }

    private FluentWait<WebDriver> waiter() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_SECONDS))
                .ignoring(NoSuchElementException.class);
    }

    private Actions actions() {
        return new Actions(driver);
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void closeBrowser(){
        driver.close();
    }

    public void goToPage(String url) {
        driver.get(url);
    }

    public String getPageSource() {
        return driver.getPageSource().toLowerCase();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        }
    }

    public void takeScreenshot() {
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenShot =
                    new File("src\\main\\resources\\screenshots " + String.valueOf(System.currentTimeMillis()) + ".jpg");
            if (screenShot.exists()) {
                screenShot.delete();
            }
            FileUtils.copyFile(file, screenShot);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public WebElement waitForElementToBeClickable(Selectors selector) {
        return waiter().until(ExpectedConditions.elementToBeClickable(selector.getLocator()));
    }

    public WebElement findElement(Selectors selector) {
        try {
            return waiter().until(ExpectedConditions.presenceOfElementLocated(selector.getLocator()));
        } catch (Exception e) {
            takeScreenshot();
            throw e;
        }
    }

    public List<WebElement> findElements(Selectors selector) {
        try {
            return waiter().until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getLocator()));
        } catch (Exception e) {
            takeScreenshot();
            throw e;
        }
    }

    public void click(WebElement element, boolean clickButton) {
        if (clickButton) {
            element.click();
        } else {
            element.sendKeys(Keys.ENTER);
        }
    }

    public WebElement getMatchedElement(List<WebElement> elements, String match) {
        return elements
                .stream()
                .filter(n -> n.getText().toLowerCase().contains(match.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(match + " is missing in the list."));
    }


}
