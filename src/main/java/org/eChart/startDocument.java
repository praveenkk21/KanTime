package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class startDocument {

    private final WebDriver driver;
    private final By checkInLink=By.xpath("//*[@id='StartDoc_hyperCheckin']");
    private final By placeOfService=By.id("Chk_StartDocClinicianToConfirmPlaceOfService");
    private final By saveAndContinue=By.id("btn_StartDocumentationSave");

    public startDocument(WebDriver driver){
        this.driver=driver;
    }

    public void clickCheckInLink(){
        driver.findElement(checkInLink).click();
    }

    public void selectPlaceOfService(){
        driver.findElement(placeOfService).click();
    }
    public void clickSaveAndContinue() throws InterruptedException {
        driver.findElement(saveAndContinue).click();
        Thread.sleep(3000);
    }
}
