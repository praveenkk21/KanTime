package org.tests;

import org.caregiver.*;
import org.generic.customLibrary;
import org.generic.exceldriven;
import org.login.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.generic.customLibrary.Chromedriver;
import static org.generic.customLibrary.configFetch;

public class caregiverTest {
    WebDriver driver;
    String instance_code, zephyr_environments_connection_string;
    Connection connection;
    exceldriven exc;
    String eChartStatus;

    @BeforeTest
    public void msDbConnect() throws SQLException {
        connection = new customLibrary().dbConnect();
        driver = Chromedriver(configFetch(connection, "url"));

    }

    @AfterTest
    public void browserClose() throws SQLException {
        driver.close();
        driver.quit();
        connection.close();
    }

    @Test(priority = 0, groups = {"login", "echart", "caregiver"})
    public void credentialsEntry() throws SQLException, InterruptedException, IOException {
        loginPage credentialsEntryLogin = new loginPage(driver);
        exc = new exceldriven();
        exc.setExcelFile("resources/data.xlsx", "Login");
        exc.setCellValue(1, 2, " ", "resources/data.xlsx");
        credentialsEntryLogin.enterUsernameBy(exc.getCellData(1, 0));
        credentialsEntryLogin.enterPasswordBy(exc.getCellData(1, 1));
        credentialsEntryLogin.loginClickBy();
        Thread.sleep(3000);
        WebElement title = credentialsEntryLogin.titleCheck();
        boolean titleDisplayedOrEnabled = title.isDisplayed() || title.isEnabled();
        String cellValue;
        if (titleDisplayedOrEnabled) {
            cellValue = "Success";
        } else {
            cellValue = "Failed";
        }
        exc.setCellValue(1, 2, cellValue, "resources/data.xlsx");
        Assert.assertTrue(title.isDisplayed() || title.isEnabled(), "Home/Dashboard page landed successfully");
    }

    @Test(priority = 1)
    public void openCaregiverPage() throws InterruptedException {
        addCaregiver ad=new addCaregiver(driver);
        ad.goToCaregiveAddPage();
        caregiverDetails ed=new caregiverDetails(driver);
        String op=ed.enterDetails();
        Assert.assertEquals(op,"Staff added successfully!");
        String pg=ed.pageVerification();
        Assert.assertTrue(pg.contains("Clinician Profile"));
    }
}
