package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.time.Duration;

public class customLibrary
{
    public static WebDriver Chromedriver(String url)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        return driver;
    }

    public static WebDriver Edgedriver(String url)
    {
        EdgeOptions optionsedge = new EdgeOptions();
        optionsedge.addArguments("--headless");
        WebDriver driver = new EdgeDriver(optionsedge);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        return driver;
    }

    public static WebDriver remoteDriver(String url2) throws MalformedURLException {
        DesiredCapabilities dc=new DesiredCapabilities();
        WebDriver driver = new RemoteWebDriver(new URL("http"),dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url2);
        return driver;
    }

    public static void dropdownSelector(WebDriver driver, String idName, String visibleText ) throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.id(idName)));
        dropdown.selectByVisibleText(visibleText);
    }

    public static void elementInteractionXpath(WebDriver driver,String idName, String name)
    {
        driver.findElement(By.xpath(idName)).sendKeys(name);
    }

    public static void elementInteractionXpath(WebDriver driver,String idName)
    {
        driver.findElement(By.xpath(idName)).click();
    }
    public static void elementInteractionId(WebDriver driver,String idName, String name)
    {
        driver.findElement(By.id(idName)).sendKeys(name);
    }

    public static void elementInteractionId(WebDriver driver,String idName)
    {
        driver.findElement(By.id(idName)).click();
    }

    public static boolean elementIsClickable(WebDriver driver,String idName)
    {
        WebElement element= driver.findElement(By.id(idName));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
            return true;
        }
        return false;
    }

    public static String jsonParse(String stringValue) {
        String value = null;
        try {
            JsonObject obj = (JsonObject) new JsonParser().parse(new FileReader("resources/config.json"));
            JsonObject jsonObj = (JsonObject) obj;
            value = String.valueOf(jsonObj.get(stringValue));
            //System.out.println("Name: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    public String jsonParseForSQL(String value, String columnName) {
        String valueFromMethod = null;
        try {
            JsonObject obj = (JsonObject) new JsonParser().parse(value);
            // Parse JSON using Gson));
            JsonObject jsonObj = (JsonObject) obj;
            valueFromMethod = String.valueOf(jsonObj.get(columnName));
            System.out.println(columnName+": " + valueFromMethod);
            return valueFromMethod;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valueFromMethod;
    }
    public Connection dbConnect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String mssql=replaceDoubleQuotes(jsonParse("zephyr_environments_connection_string"));
        String url = convertToJdbcConnectionString(mssql);
        System.out.println(url);
        String username = convertToJdbcConnectionCred(mssql,"userid");
        String password = convertToJdbcConnectionCred(mssql,"password");
        System.out.println(username);
        System.out.println(password);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            // Use connection...
            return connection;
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static String configFetch(Connection connection,String columnNameofTable) throws SQLException {
        System.out.println(connection);
        String query = "select * from ProcessMaster";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        String login_id = null;
        if (resultSet.next()) {
            String columnName = resultSet.getMetaData().getColumnName(12);
            Object columnValue = resultSet.getObject(12);
            login_id = new customLibrary().jsonParseForSQL(String.valueOf(columnValue), columnNameofTable);
            //connection.close();
            return (replaceDoubleQuotes(login_id));
        }
        return login_id;
    }

    public static String replaceDoubleQuotes(String value)
    {
        return  value.replace("\"", "");
    }

    public static String convertToJdbcConnectionCred(String inputConnectionString, String cred) {
        String[] parts = inputConnectionString.split(";");
        String userid = "";
        String password = "";

        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "User ID":
                        userid = value;
                        break;
                    case "Password":
                        password = value;
                        break;
                    default:
                        break;
                }
            }
        }
        if(cred.equals("userid")) {
            return userid;
        }
        else
        {
            return password;
        }
    }

    public static String convertToJdbcConnectionString(String inputConnectionString) {
        String[] parts = inputConnectionString.split(";");
        String dataSource = "";
        String initialCatalog = "";

        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "Data Source":
                        dataSource = value;
                        break;
                    case "Initial Catalog":
                        initialCatalog = value;
                        break;
                    default:
                        break;
                }
            }
        }

        if (!dataSource.isEmpty() && !initialCatalog.isEmpty()) {
            return "jdbc:sqlserver://" + dataSource + ":1433;databaseName=" + initialCatalog + ";encrypt=false;";
        } else {
            return "Invalid input connection string";
        }
    }

}

