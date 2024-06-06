package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class eChartStatus {
    private final WebDriver driver;
    private final By eChartStatus=By.xpath("//*[@id=\"spn_VisitChartStatus\"]");
    public eChartStatus(WebDriver driver){
        this.driver=driver;
    }
    public String geteChartStatus(){
        return driver.findElement(eChartStatus).getText();
    }
}
