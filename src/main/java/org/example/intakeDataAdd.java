package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class intakeDataAdd {
    WebDriver driver;
    By locationName=By.id("MainContent_drp_Branch");
    By lobName=By.id("MainContent_ddl_LOB");
    By payerName=By.id("MainContent_ddlPayer");
    By intakeFirstName=By.id("MainContent_txtFirstname");
    By intakeLastName=By.id("MainContent_txtLastname");
    By dob=By.id("MainContent_txtDOB");
    By term=By.id("MainContent_chkLongTermCare");
    By duplicateCheck=By.id("MainContent_btn_checkduplicate");
    By admitClick=By.id("btn_admitasnew");

    public intakeDataAdd(WebDriver driver) {
        this.driver = driver;
    }

    public void selectLocationBy(String location)
    {
        Select dropdown = new Select(driver.findElement(locationName));
        dropdown.selectByVisibleText(location);
    }

    public void selectLobBy(String lob)
    {
        Select dropdown = new Select(driver.findElement(lobName));
        dropdown.selectByVisibleText(lob);
    }
    public void selectPayerBy(String payer)
    {
        Select dropdown = new Select(driver.findElement(payerName));
        dropdown.selectByVisibleText(payer);
    }
    public void intakeFirstName(String firstName)
    {
        driver.findElement(intakeFirstName).sendKeys(firstName);
    }

    public void IntakeLastName(String lastName)
    {
        driver.findElement(intakeLastName).sendKeys(lastName);
    }

    public void enterDOB(String enterDob)
    {
        driver.findElement(dob).sendKeys(enterDob);
    }
    public void clickTerm()
    {
        driver.findElement(term).click();
    }
    public void duplicateCheck()
    {
        driver.findElement(duplicateCheck).click();
    }
    public void admitClick()
    {
        driver.findElement(admitClick).click();
    }

}
