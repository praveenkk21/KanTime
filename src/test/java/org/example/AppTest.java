package org.example;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

/**
 * Unit test for simple App.
 */

@Test
public class AppTest
{
    WebDriver driver;

    @BeforeTest
    public void browserOpen() {
        driver = customLibrary.driver("https://working.kantimehealth.net/identity/v2/Accounts/Authorize?product=hh");
    }

    @AfterTest
    public void browserClose() {
        //driver.close();
    }
    @Test(priority=0)
    public void enterLogin()
    {
        customLibrary.elementInteractionId(driver,"txt_username","white@CKT.com");
    }

    @Test(priority=1)
    public void enterPassword()
    {
        customLibrary.elementInteractionId(driver,"txt_password","Test@1234");
    }

    @Test(priority=2)
    public void clickLogin()
    {
        customLibrary.elementInteractionId(driver,"btn_login");
    }

    @Test(priority=3)
    public void enterIntakeAddPage()
    {
        customLibrary.elementInteractionXpath(driver,"//*[@class='MainMenuItemStyleInner_Training' and @id='1']");
        customLibrary.elementInteractionXpath(driver,"//*[@id='td_0']");
    }

    @Test(priority=4)
    public void enterIntakeDetails() {
        customLibrary.dropdownSelector(driver, "MainContent_drp_Branch", "Test_Branch_Kafka_1");
        customLibrary.dropdownSelector(driver, "MainContent_ddl_LOB", "Kafka_LOB_One");
        customLibrary.elementInteractionId(driver, "MainContent_txtFirstname", "praveen");
        customLibrary.elementInteractionId(driver, "MainContent_txtLastname", "kumar");
        customLibrary.elementInteractionId(driver, "MainContent_txtDOB", "01/01/1950");
        customLibrary.dropdownSelector(driver, "MainContent_ddlPayer", "Billing_Test_CDA");
        customLibrary.elementInteractionId(driver, "MainContent_chkLongTermCare");
        if (customLibrary.elementIsClickable(driver, "btn_admitasnew")) {
            customLibrary.elementInteractionId(driver, "btn_admitasnew");
        } else {
            customLibrary.elementInteractionId(driver, "MainContent_btn_checkduplicate");
            customLibrary.elementInteractionId(driver, "btn_admitasnew");
        }
    }
}

