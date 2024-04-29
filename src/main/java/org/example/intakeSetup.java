package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class intakeSetup {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='MainMenuItemStyleInner_Training' and @id='1']")
    WebElement referralClick;

    @FindBy(xpath = "//*[@id='td_0']")
    WebElement intakeClick;

    public intakeSetup(WebDriver driver) {
     this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void referralClick(){
        referralClick.click();
    }

    public void intakeClick(){
        intakeClick.click();
    }
}
