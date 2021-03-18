package workingOn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestAgain {

    public static WebDriver driver;
    public static String url = "https://www.walmart.com";

//    public static WebElement hove = driver.findElement(By.cssSelector("button[aria-label='more']"));
//    public static WebElement click = driver.findElement(By.cssSelector("li[class='MainNavButton expander active'] a:nth-child(1)"));


    public void hoverAndClick(WebDriver driver1, WebElement elementHover, WebElement elementClick) {
        Actions selecrMenu = new Actions(driver1);
        selecrMenu.moveToElement(elementHover).click(elementClick).build().perform();

    }


    public static void pageLoader() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","../walmart/external/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        Thread.sleep(3000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,6000);");
    }

    @Test
    public void billPay() throws InterruptedException {
        pageLoader();
        driver.findElement(By.xpath("//a[normalize-space()='MoneyCenter']")).click();
        Thread.sleep(3000);
        WebElement hove = driver.findElement(By.cssSelector("button[aria-label='more']"));
        WebElement click = driver.findElement(By.cssSelector("li[class='MainNavButton expander active'] a:nth-child(1)"));

        hoverAndClick(driver,hove,click);
    }


}
