package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class displayvlauefromTable {
    @Test
    public void tableValueDisplay(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/selenium");
        WebElement val=driver.findElement(By.xpath("//table"));
        ArrayList<WebElement> col= (ArrayList<WebElement>) val.findElements(By.xpath("//*/tr"));
        for(int i=0;i< col.size();i++){
            System.out.println(col.get(i).getText());
        }
    }
}
