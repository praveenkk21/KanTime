package org.caregiver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addCaregiver {
    private final WebDriver driver;
    private final By staffLink=By.xpath("//*[@id=\"32\"]");
    private final By addLink=By.xpath("//*[contains(@id,'td_') and contains (@onclick,'createcaregiver')]");
    public addCaregiver(WebDriver driver){
        this.driver=driver;
    }
    public void goToCaregiveAddPage(){
        driver.findElement(staffLink).click();
        driver.findElement(addLink).click();
    }
}
