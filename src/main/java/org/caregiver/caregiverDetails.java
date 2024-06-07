package org.caregiver;
import org.generic.selectDropdown;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class caregiverDetails {
    private final WebDriver driver;
    private final By checkStaff=By.id("ChkStaff");
    private final By checkClinician=By.id("ChkClinician");
    private final By firstName=By.id("MainContent_txt_FirstName");
    private final By lastName=By.id("MainContent_txt_LastName");
    private final By selectLocation=By.id("ctl00_MainContent_ddlLocation_Input");
    private final By selectLocationAll=By.id("ctl00_MainContent_ddlLocation_i0_chk_Locations");
    private final By selectDisciplines=By.id("MainContent_drp_Discipline");
    private final By selectStatus=By.id("MainContent_drplst_CG_Status");
    private final By selectPayrollLocation=By.id("MainContent_ddl_PayrollLocation");
    private final By selectDesignation=By.id("MainContent_ddlDesignation");
    private final By clickSave=By.id("MainContent_btn_SaveCaregiver");
    private final By selectMaleGender=By.id("MainContent_rdo_cargmale");
    public caregiverDetails(WebDriver driver){
        this.driver=driver;
    }

    public String enterDetails() throws InterruptedException {
        driver.findElement(checkStaff).click();
        driver.findElement(checkClinician).click();
        driver.findElement(firstName).sendKeys("praveen");
        driver.findElement(lastName).sendKeys("kumar");
        driver.findElement(selectLocation).click();
        driver.findElement(selectLocationAll).click();
        selectDropdown dropdowns= new selectDropdown(driver);
        dropdowns.selector(driver.findElement(selectDisciplines),"AIDE");
        dropdowns.selector(driver.findElement(selectStatus), "Active");
        dropdowns.selector(driver.findElement(selectPayrollLocation),"KanTime");
        dropdowns.selector(driver.findElement(selectDesignation),"Admin");
        driver.findElement(selectMaleGender).click();
        driver.findElement(clickSave).click();
        Thread.sleep(2000);
        if(driver.findElement(By.id("DivValidations")).isDisplayed() &&
                driver.findElement(By.id("DivValidations")).isEnabled())
            driver.findElement(By.id("Btn_Continue")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String op= alert.getText();
        alert.accept();
        return op;
    }

    public String pageVerification(){
        return driver.getTitle();
    }
}
