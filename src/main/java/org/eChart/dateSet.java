package org.eChart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dateSet {

    @FindBy (id = "txt_ScheduleStartDate")
    WebElement startDate;

    @FindBy (id = "txt_ScheduleEndDate")
    WebElement endDate;

    @FindBy(xpath = "//*[@value=\"Display\" and @class=\"NormalButton\"]")
    WebElement displayClick;

    private WebDriver driver;
    public dateSet(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void date(String date)
    {
        System.out.println(date);
        startDate.clear();
        startDate.sendKeys(date);
        endDate.clear();
        endDate.sendKeys(date);
    }

    public void  displayClick(){
        displayClick.click();
    }

}
