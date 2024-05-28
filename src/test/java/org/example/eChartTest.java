package org.example;
import org.eChart.*;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import static org.example.customLibrary.*;

@Listeners(listners.class)
public class eChartTest {
    WebDriver driver;
    String instance_code,zephyr_environments_connection_string;
    Connection connection;
    exceldriven exc;

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

    @Test(enabled=false) //,groups = {"dont run"}
    @Parameters("browser")
    public void browserOpen(String browser) throws SQLException, MalformedURLException, URISyntaxException {
            instance_code = jsonParse("instance_code");
            zephyr_environments_connection_string = jsonParse("zephyr_environments_connection_string");
            switch (browser) {
                case "edge":
                    driver = Edgedriver(configFetch(connection, "url"));
                    break;
                case "remote":
                    driver = remoteDriver((configFetch(connection, "url")),"chrome");
                    break;
                case "remoteFire":
                    driver=remoteDriver((configFetch(connection, "url")),"firefox");
                    break;
                case "remoteEdge":
                    driver=remoteDriver((configFetch(connection, "url")),"MicrosoftEdge");
                    break;
                default:
                    driver = Chromedriver(configFetch(connection, "url"));
                    break;
            }

        }


        @Test(priority = 0,groups = {"login","echart"})
        public void credentialsEntry() throws SQLException, InterruptedException, IOException {
            loginPage credentialsEntryLogin = new loginPage(driver);
            exc = new exceldriven();
            exc.setExcelFile("resources/data.xlsx","Login");
            exc.setCellValue(1, 2, " ", "resources/data.xlsx");
            credentialsEntryLogin.enterUsernameBy(exc.getCellData(1,0));
            credentialsEntryLogin.enterPasswordBy(exc.getCellData(1,1));
            credentialsEntryLogin.loginClickBy();
            Thread.sleep(3000);
            WebElement title= credentialsEntryLogin.titleCheck();
            boolean titleDisplayedOrEnabled = title.isDisplayed() || title.isEnabled();
            String cellValue;
            if (titleDisplayedOrEnabled) {
                cellValue = "Success";
            } else {
                cellValue = "Failed";
            }
            exc.setCellValue(1, 2, cellValue, "resources/data.xlsx");
            Assert.assertTrue(title.isDisplayed() || title.isEnabled(),"Home/Dashboard page landed successfully");
        }

        @Test(priority = 1,groups = {"echart"})
        public void goToEmTab(){
            episodeManagement em=new episodeManagement(driver);
            em.clinicalClick();
            em.emClick();
        }

    @Test(priority = 2,groups = {"echart"})
    public void seachClient() throws IOException {
        clientSearch sc=new clientSearch(driver);
        exc.setExcelFile("resources/data.xlsx","eChartMaster");
        String first_name=exc.getCellData(1,0);
        String last_name=exc.getCellData(1,1);
        String pat_id=exc.getCellData(1,2);
        sc.searchClick(last_name+", "+first_name+" ("+pat_id+")");
    }

    @Test(priority = 3,groups = {"echart"})
    public void dateSearch(){
        dateSet ds=new dateSet(driver);
        ds.date(exc.getCellData(1,3));
        ds.displayClick();
    }

    @Test(priority = 3,groups = {"echart"})
    public void eChartOpen(){
        eChartSearch ec=new eChartSearch(driver);
        ec.eChartLinkClick(Integer.parseInt(exc.getCellData(1,4)));
    }

}
