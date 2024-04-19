package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

/**
 * Unit test for simple App.
 */

@Test
public class AppTest
{
    WebDriver driver;
    String instance_code,zephyr_environments_connection_string;
    //@BeforeTest
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
    @Test
    public void configFetch() throws SQLException {
        instance_code=customLibrary.jsonParse("instance_code");
        zephyr_environments_connection_string=customLibrary.jsonParse("zephyr_environments_connection_string");
        Connection connected = new customLibrary().dbConnect();
        System.out.println(connected);
        String query = "select * from ZephyrUIPath..ProcessMaster";
        Statement statement = connected.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            String columnName = resultSet.getMetaData().getColumnName(12);
            Object columnValue = resultSet.getObject(12);
            String value_1=new customLibrary().jsonParseForSQL(String.valueOf(columnValue),"login_id");
            System.out.println(value_1);
        }
    }


}


