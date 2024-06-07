package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class startDocument {

    private final WebDriver driver;
    private final By checkInLink=By.xpath("//*[@id='StartDoc_hyperCheckin']");
    private final By placeOfService=By.id("Chk_StartDocClinicianToConfirmPlaceOfService");
    private final By saveAndContinue=By.id("btn_StartDocumentationSave");

    public startDocument(WebDriver driver){
        this.driver=driver;
    }

    public void clickCheckInLink(){
        WebElement c=driver.findElement(checkInLink);
        if(c.isDisplayed() && c.isEnabled())
            c.click();
    }

    public void selectPlaceOfService(){
        WebElement p=driver.findElement(placeOfService);
        if(p.isDisplayed() && p.isEnabled())
            p.click();
    }
    public void clickSaveAndContinue() throws InterruptedException {
        WebElement sac=driver.findElement(saveAndContinue);
        if(sac.isDisplayed() && sac.isEnabled())
            sac.click();
        Thread.sleep(3000);
    }
}
