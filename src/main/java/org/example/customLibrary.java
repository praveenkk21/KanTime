package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public static String jsonParse(String stringValue) {
        String value = null;
        try {
            JsonObject obj = (JsonObject) new JsonParser().parse(new FileReader("resources/config.json"));
            JsonObject jsonObj = (JsonObject) obj;
            value = String.valueOf(jsonObj.get(stringValue));
            //System.out.println("Name: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    public String jsonParseForSQL(String value, String columnName) {
        String valueFromMethod = null;
        try {
            JsonObject obj = (JsonObject) new JsonParser().parse(value);
            // Parse JSON using Gson));
            JsonObject jsonObj = (JsonObject) obj;
            valueFromMethod = String.valueOf(jsonObj.get(columnName));
            System.out.println(columnName+": " + valueFromMethod);
            return valueFromMethod;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valueFromMethod;
    }
        public Connection dbConnect() {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String url = "jdbc:sqlserver://192.168.1.122:1433;databaseName=ZephyrUIPath;encrypt=false;";
            String username = "medicaresqluser";
            String password = "kantime_123";

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, username, password);
                // Use connection...
                return connection;
                //connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
}
