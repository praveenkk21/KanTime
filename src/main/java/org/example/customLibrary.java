package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class customLibrary
{
    public static WebDriver driver(String url)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        return driver;
    }
    public static void dropdownSelector(WebDriver driver, String idName, String visibleText )
    {
        Select dropdown = new Select(driver.findElement(By.id(idName)));
        dropdown.selectByVisibleText(visibleText);
    }

    public static void elementInteractionXpath(WebDriver driver,String idName, String name)
    {
        driver.findElement(By.xpath(idName)).sendKeys(name);
    }

    public static void elementInteractionXpath(WebDriver driver,String idName)
    {
        driver.findElement(By.xpath(idName)).click();
    }
    public static void elementInteractionId(WebDriver driver,String idName, String name)
    {
        driver.findElement(By.id(idName)).sendKeys(name);
    }

    public static void elementInteractionId(WebDriver driver,String idName)
    {
        driver.findElement(By.id(idName)).click();
    }

    public static boolean elementIsClickable(WebDriver driver,String idName)
    {
        WebElement element= driver.findElement(By.id(idName));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
            return true;
        }
        return false;
    }
}
