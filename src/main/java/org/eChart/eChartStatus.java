package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class eChartStatus {
    private final WebDriver driver;
    private final By eChartStatus=By.xpath("//*[@id=\"spn_VisitChartStatus\"]");
    public eChartStatus(WebDriver driver){
        this.driver=driver;
    }
    public String geteChartStatus(){
        WebElement cs=driver.findElement(eChartStatus);
        if(cs.isDisplayed() && cs.isEnabled())
        {
            return cs.getText();
        }
        return "";
    }
}
