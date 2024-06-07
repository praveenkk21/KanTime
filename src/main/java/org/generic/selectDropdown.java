package org.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class selectDropdown {
    private final WebDriver driver;
    public selectDropdown(WebDriver driver){
        this.driver=driver;
    }
    public void selector(WebElement DDL,String Value){
        Select sel=new Select(DDL);
        sel.selectByVisibleText(Value);
    }
}
