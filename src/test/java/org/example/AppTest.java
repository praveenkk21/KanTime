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

import static org.example.customLibrary.*;
import static org.example.customLibrary.jsonParse;

@Test
public class AppTest
{
    WebDriver driver;
    String instance_code,zephyr_environments_connection_string;
    Connection connection;

    @BeforeTest
    public void msDbConnect()
    {
        connection = new customLibrary().dbConnect();
    }

    @Test(priority=0)
    public void browserOpen() throws SQLException {
        instance_code= jsonParse("instance_code");
        zephyr_environments_connection_string= jsonParse("zephyr_environments_connection_string");
        driver = driver(configFetch(connection,"url"));
    }

    @AfterTest
    public void browserClose() throws SQLException {
        //driver.close();
        connection.close();
    }
    @Test(priority=1)
    public void enterLogin() throws SQLException {
        elementInteractionId(driver,"txt_username", configFetch(connection,"login_id"));
    }

    @Test(priority=1)
    public void enterPassword() throws SQLException {
        elementInteractionId(driver,"txt_password", configFetch(connection,"password"));
    }

    @Test(priority=2)
    public void clickLogin()
    {
        elementInteractionId(driver,"btn_login");
    }

    @Test(priority=3)
    public void enterIntakeAddPage()
    {
        elementInteractionXpath(driver,"//*[@class='MainMenuItemStyleInner_Training' and @id='1']");
        elementInteractionXpath(driver,"//*[@id='td_0']");
    }

    @Test(priority=4)
    public void enterIntakeDetails() throws SQLException, InterruptedException {
        dropdownSelector(driver, "MainContent_drp_Branch", configFetch(connection,"location"));
        dropdownSelector(driver, "MainContent_ddl_LOB", configFetch(connection,"lob"));
        elementInteractionId(driver, "MainContent_txtFirstname", configFetch(connection,"first_name"));
        elementInteractionId(driver, "MainContent_txtLastname", configFetch(connection,"last_name"));
        elementInteractionId(driver, "MainContent_txtDOB", configFetch(connection,"dob"));
        Thread.sleep(2000);
        dropdownSelector(driver, "MainContent_ddlPayer", configFetch(connection,"payer"));
        Thread.sleep(2000);
        elementInteractionId(driver, "MainContent_chkLongTermCare");
        if (elementIsClickable(driver, "btn_admitasnew")) {
            elementInteractionId(driver, "btn_admitasnew");
        } else {
            elementInteractionId(driver, "MainContent_btn_checkduplicate");
            elementInteractionId(driver, "btn_admitasnew");
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


