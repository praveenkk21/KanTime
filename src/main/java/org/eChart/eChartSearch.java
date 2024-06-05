package org.eChart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class eChartSearch {
    private WebDriver driver;
    public eChartSearch(WebDriver driver){
        this.driver=driver;
    }

    public void eChartLinkClick(String cgtaskID){
        //System.out.println(cgtaskID);
        double d = Double.parseDouble(cgtaskID);
        int i = (int) d;
        //System.out.println(i);
        By eChartLinkClick= By.xpath("//*[contains(@id,'td_Schedule_EchartLink_ "+i+"')]/a");
        driver.findElement(eChartLinkClick).click();
    }


}
