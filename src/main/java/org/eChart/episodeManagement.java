package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class episodeManagement {
    private WebDriver driver;
    By clinicalClick= By.xpath("//*[@id=66 and @class=\"MainMenuItemStyleInner_Training\"]");
    By emClick=By.xpath("//*[@id=\"td_7\"]");


    public episodeManagement(WebDriver driver)
    {
            this.driver=driver;
    }

    public void clinicalClick()
    {
        driver.findElement(clinicalClick).click();
    }

    public void emClick()
    {
        driver.findElement(emClick).click();
    }
}
