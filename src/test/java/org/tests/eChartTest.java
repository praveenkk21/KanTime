package org.tests;

import org.eChart.*;
import org.generic.customLibrary;
import org.generic.exceldriven;
import org.generic.listners;
import org.login.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import static org.generic.customLibrary.*;

@Listeners(listners.class)
@Test
public class eChartTest {
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

    @Test(enabled = false) //,groups = {"dont run"}
    @Parameters("browser")
    public void browserOpen(String browser) throws SQLException, MalformedURLException, URISyntaxException {
        instance_code = jsonParse("instance_code");
        zephyr_environments_connection_string = jsonParse("zephyr_environments_connection_string");
        switch (browser) {
            case "edge":
                driver = Edgedriver(configFetch(connection, "url"));
                break;
            case "remote":
                driver = remoteDriver((configFetch(connection, "url")), "chrome");
                break;
            case "remoteFire":
                driver = remoteDriver((configFetch(connection, "url")), "firefox");
                break;
            case "remoteEdge":
                driver = remoteDriver((configFetch(connection, "url")), "MicrosoftEdge");
                break;
            default:
                driver = Chromedriver(configFetch(connection, "url"));
                break;
        }

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

    @Test(priority = 1, groups = {"echart"})
    public void goToEmTab() throws InterruptedException {
        episodeManagement em = new episodeManagement(driver);
        Thread.sleep(5000);
        em.clinicalClick();
        em.emClick();
    }

    @Test(priority = 2, groups = {"echart"})
    public void seachClient() throws IOException, InterruptedException {
        clientSearch sc = new clientSearch(driver);
        exc.setExcelFile("resources/data.xlsx", "eChartMaster");
        String first_name = exc.getCellData(1, 0);
        String last_name = exc.getCellData(1, 1);
        String pat_id = exc.getCellData(1, 2);
        sc.searchClick(last_name + ", " + first_name + " (" + pat_id + ")");
    }

    @Test(priority = 3, groups = {"echart"})
    public void dateSearch() {
        dateSet ds = new dateSet(driver);
        ds.date(exc.getCellData(1, 3));
        ds.displayClick();
    }

    @Test(priority = 4, groups = {"echart"})
    public void eChartOpen() {
        eChartSearch ec = new eChartSearch(driver);
        String parent_window = driver.getWindowHandle();
        ec.eChartLinkClick(exc.getCellData(1, 4));
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> s = windows.iterator();
        String eChart_popup = null;
        if (s.hasNext()) {
            s.next();
            eChart_popup = s.next();
            if (!parent_window.equals(eChart_popup)) {
                driver.switchTo().window(eChart_popup);
            }
            System.out.println(driver.getTitle());
            Assert.assertTrue(driver.getTitle().contains("Visit Chart"));
        }
    }

    @Test(priority = 5, groups = {"echart"})
    public void startDocumentation() throws InterruptedException {
        startDocument sd = new startDocument(driver);
        sd.clickCheckInLink();
        sd.selectPlaceOfService();
        sd.clickSaveAndContinue();
    }

    @Test(priority = 6,groups = {"echart"})
    public void eChartStatusCheck() throws InterruptedException {
        eChartStatus es = new eChartStatus(driver);
        eChartStatus = es.geteChartStatus();
        chartDocument cd = new chartDocument(driver);
        cd.setStatus(eChartStatus);
        System.out.println(eChartStatus);
        Thread.sleep(5000);
        switch (eChartStatus){
            case "Approved" -> {
                cd.clickUnApprove();
                Thread.sleep(5000);
                cd.clickSentForCorrection();
                Thread.sleep(5000);
            }
            case "Submitted" -> {
                cd.clickSentForCorrection();
                Thread.sleep(5000);
            }
        }
    }

    @Test(priority = 7,groups = {"echart"})
    public void doOpeneChartDocument( ) throws InterruptedException {
        chartDocument cd = new chartDocument(driver);
        cd.setStatus("open");
        Thread.sleep(2000);
        cd.clickSubmit1();
        cd.clickCheckout();
        cd.clickSubmit2();
        Thread.sleep(2000);
        eChartStatus es = new eChartStatus(driver);
        Assert.assertEquals(es.geteChartStatus(), "Submitted");
        cd.clickApprove();
        Thread.sleep(2000);
        Assert.assertEquals(es.geteChartStatus(), "Approved");
        }
    }
