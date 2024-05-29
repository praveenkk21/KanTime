package org.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class displayvlauefromTable {
    @Test
    public void tableValueDisplay() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        Actions action = new Actions(driver);
//        action.moveToElement(element).click().perform();
        driver.get("https://www.tutorialspoint.com/how-to-get-text-from-each-cell-of-an-html-table-using-selenium");
        System.out.println("----------------------------------------------------");
        WebElement t = driver.findElement(By.xpath("//table"));
        List<WebElement> rws = t.findElements(By.xpath("//tr"));
        int rws_cnt = rws.size();
        for(int i = 0; i < rws_cnt; i++) {
            List<WebElement> cols = rws.get(i).findElements(By.tagName("td"));
            int cols_cnt = cols.size();
            for(int j = 0; j < cols_cnt; j++) {
                String c = cols.get(j).getText();
                System.out.println("The cell value is: " + c);
            }
            System.out.println(" ");
        }
    }
}
