package workingOn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Demo {

    public static WebDriver driver;
    public static String url = "https://www.walmart.com";

    public void scrollToBottomPage(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

 public void scrollUp(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrolldown(String num){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+ num+");");

    }

    public void scrollDown(String num) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0," + num + ");");
    }



    @BeforeMethod
    public static void toTheFooter() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "../walmart/external/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        Thread.sleep(3000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,4000);");
    }

    @Test @Ignore
    public void click() throws InterruptedException {
        toTheFooter();
        driver.findElement(By.cssSelector("a[data-section-title*='Footer - Grocery Pickup & Delivery']")).click();
        Thread.sleep(3000);
        boolean exist = driver.findElement(By.cssSelector("div[class*='imgContainer']")).isDisplayed();

        if (exist == true) {
            driver.findElement(By.cssSelector("svg[display*='block']")).click();
        }
        driver.findElement(By.className(".ToolTip__toolTip___VdX7u")).clear();

        //      driver.findElement(By.className("Search__searchField___3eXaL")).
//        Thread.sleep(3000);
//        boolean shows = driver.findElement(By.className(".ToolTip__toolTip___VdX7u")).isDisplayed();
//        if (shows == true){
//            driver.findElement(By.className(".ToolTip__toolTip___VdX7u")).clear();
//        }
////        driver.findElement(By.className(".ToolTip__toolTip___VdX7u")).
//

    }


    public void hoverAndClick(WebDriver driver1, WebElement elementHover, WebElement elementClick) {
        Actions selecrMenu = new Actions(driver1);
        selecrMenu.moveToElement(elementHover).click(elementClick).build().perform();

    }

    @Test @Ignore
    public void benefit() throws InterruptedException {
      //  toTheFooter();
        driver.findElement(By.xpath("//a[normalize-space()='Walmart+']")).click();
        WebElement hove = driver.findElement(By.xpath("//a[contains(text(),'Benefits')]"));
        WebElement click = driver.findElement(By.xpath("//span[normalize-space()='All benefits']"));
        Thread.sleep(2000);
        hoverAndClick(driver,hove,click);
    }

    @Test
    public void billPay() throws InterruptedException {
//        toTheFooter();
        driver.findElement(By.xpath("//a[normalize-space()='MoneyCenter']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li:nth-child(3) h2:nth-child(1) a:nth-child(1)")).click();


        WebElement hove = driver.findElement(By.cssSelector("li.display-inline-block:nth-child(4) > h2:nth-child(1) > a:nth-child(1)"));
//        WebElement click = driver.findElement(By.cssSelector("li[class='MainNavButton expander active'] a:nth-child(1)"));
//            // //li[@class='MainNavButton expander']
//        // li[class='MainNavButton expander active'] a:nth-child(1)
//        hoverAndClick(driver,hove,click);
    }
    @Test
    public void weyTat() throws InterruptedException {
//        toTheFooter();
        driver.findElement(By.xpath("//a[normalize-space()='MoneyCenter']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li h2 button")).click();
        WebElement hover = driver.findElement(By.cssSelector("li.display-inline-block:nth-child(4) > h2:nth-child(1) > a:nth-child(1)"));
//        WebElement click = driver.findElement(By.cssSelector("li[class='MainNavButton expander active'] a:nth-child(1)"));
        //li h2 button
    }

    public void moveAway(int x, int y){
        Actions move = new Actions(driver);
        move.moveByOffset(x,y).tick();
    }
    @Test
    public void sort() throws InterruptedException {
//        toTheFooter();
        driver.findElement(By.xpath("//a[normalize-space()='MoneyCenter']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("li:nth-child(3) h2:nth-child(1) a:nth-child(1)")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[normalize-space()='Walmart gift cards']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Top Brands']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"search-util-bar-brand-1\"]")).click();
        Thread.sleep(3000);
//        scrollDown("100");
        scrollToBottomPage();
        scrolldown("0");


    }

}
