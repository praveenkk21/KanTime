package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class eChartSearch {
    private WebDriver driver;
    public eChartSearch(WebDriver driver){
        this.driver=driver;
    }

    public void eChartLinkClick(int cgtaskID){
        By eChartLinkClick= By.xpath("//*[contains(@id,'td_Schedule_EchartLink_"+cgtaskID+")]/a");
        driver.findElement(eChartLinkClick).click();
    }

}
