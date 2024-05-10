package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class clientSearch {
    private WebDriver driver;
    By searchClick= By.id("txtautoClient");

    public clientSearch(WebDriver driver)
    {
        this.driver=driver;
    }

    public void searchClick(String name)
    {
        driver.findElement(searchClick).sendKeys(name, Keys.DOWN,Keys.ENTER);
    }


}
