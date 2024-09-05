package org.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class dataParameterTestNg {

    private WebDriver driver;

    @BeforeTest
    public void driveLogin(){
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--headless");
        driver=new ChromeDriver(co);
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider="username&password")
    public void login(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebElement logout=driver.findElement(By.id("logout_sidebar_link"));
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        logout.click();
    }

    @DataProvider(name="username&password")
    public Object[][] name(){
        String password="secret_sauce";
        return new Object[][]{
                {"problem_user",password},
                {"standard_user",password},
                {"visual_user",password}
        };
    }

    @AfterTest
    public void quit() {
        driver.quit();

    }
}
