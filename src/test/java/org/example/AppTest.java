package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;
import java.time.Duration;

import static org.example.customLibrary.jsonParse;

@Test
public class AppTest
{
    WebDriver driver;
    String instance_code,zephyr_environments_connection_string;

    @BeforeTest
    public void browserOpen() {
        instance_code= jsonParse("instance_code");
        zephyr_environments_connection_string= jsonParse("zephyr_environments_connection_string");
        driver = customLibrary.driver("https://working.kantimehealth.net/identity/v2/Accounts/Authorize?product=hh");
    }

    @AfterTest
    public void browserClose() {
        //driver.close();
    }
    @Test(priority=0)
    public void enterLogin() throws SQLException {
        customLibrary.elementInteractionId(driver,"txt_username", customLibrary.configFetch("login_id"));
    }

    @Test(priority=1)
    public void enterPassword() throws SQLException {
        customLibrary.elementInteractionId(driver,"txt_password",customLibrary.configFetch("password"));
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
    public void enterIntakeDetails() throws SQLException, InterruptedException {
        customLibrary.dropdownSelector(driver, "MainContent_drp_Branch", customLibrary.configFetch("location"));
        customLibrary.dropdownSelector(driver, "MainContent_ddl_LOB", customLibrary.configFetch("lob"));
        customLibrary.elementInteractionId(driver, "MainContent_txtFirstname", customLibrary.configFetch("first_name"));
        customLibrary.elementInteractionId(driver, "MainContent_txtLastname", customLibrary.configFetch("last_name"));
        customLibrary.elementInteractionId(driver, "MainContent_txtDOB", customLibrary.configFetch("dob"));
        customLibrary.dropdownSelector(driver, "MainContent_ddlPayer", customLibrary.configFetch("payer"));
        customLibrary.elementInteractionId(driver, "MainContent_chkLongTermCare");
        if (customLibrary.elementIsClickable(driver, "btn_admitasnew")) {
            customLibrary.elementInteractionId(driver, "btn_admitasnew");
        } else {
            customLibrary.elementInteractionId(driver, "MainContent_btn_checkduplicate");
            customLibrary.elementInteractionId(driver, "btn_admitasnew");
        }

        Thread.sleep(5000);
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException ex) {
            System.out.println("No alert present");
        }
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("IntakeId")) {
            System.out.println("IntakeId is created");
        }
        else  System.out.println("IntakeId is not created");

    }

//    @Test
//    public void z()
//    {
//        String mssql=jsonParse("zephyr_environments_connection_string");
//        // "Data Source=192.168.1.122;Initial Catalog=ZephyrUIPath;Persist Security Info=True;User ID=medicaresqluser;Password=kantime_123"
//        String m1=mssql.replace("Data Source=","jdbc:sqlserver://");
//        String m2=m1.replace("Initial Catalog","databaseName");
//        System.out.println(m2);
//    }
}


