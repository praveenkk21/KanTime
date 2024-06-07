package org.eChart;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class chartDocument {
    private final WebDriver driver;
    private final By submit1=By.id("btn_SubmitClinicalCharting");
    private final By submit2=By.id("btn_SubmitDoc_SubmitQA");
    private final By sentForCorrection=By.id("Btn_SendBackToClinician");
    private final By sentForCorrectionPopUp=By.id("div_SendForCorrection");
    private final By approve=By.id("btn_ApproveClinicalCharting");
    public final By checkout= By.xpath("//*[@id=\"SubmitDoc_hyperCheckOut\"]");
    public final By unApprove=By.id("Btn_UnApprove");
    public final By unApprovePopUp= By.id("div_UnapproveChart");
    private String status;
    public chartDocument(WebDriver driver){
        this.driver=driver;
    }

    public void setStatus(String status){
        this.status=status;
    }

   public void clickSubmit1(){
        WebElement s1=driver.findElement(submit1);
        if(s1.isDisplayed() && s1.isEnabled())
            s1.click();
   }

   public void clickCheckout(){
       WebElement co=driver.findElement(checkout);
       if(co.isDisplayed() && co.isEnabled())
           co.click();
   }
    public void clickSubmit2(){
        WebElement s2=driver.findElement(submit2);
        if(s2.isDisplayed() && s2.isEnabled())
            s2.click();
    }
    public void clickSentForCorrection(){
        WebElement s3=driver.findElement(sentForCorrection);
        if(s3.isDisplayed() && s3.isEnabled())
            s3.click();
        WebElement sp=driver.findElement(sentForCorrectionPopUp);
        if(sp.isEnabled()&&sp.isDisplayed()) {
            driver.findElement(By.id("txtarea_SendforCorrectionNotes")).sendKeys("Send for correcftion text");
            driver.findElement(By.id("btn_SendForCorrectionNote")).click();
        }
    }

    public void clickApprove(){
        driver.findElement(approve).click();
        driver.switchTo().alert().accept();
    }

    public void clickUnApprove(){
        WebElement ua=driver.findElement(unApprove);
        if(ua.isDisplayed() && ua.isEnabled())
            ua.click();
        WebElement uap=driver.findElement(unApprovePopUp);
        if(uap.isEnabled()&&uap.isDisplayed()) {
            driver.findElement(By.id("txt_UnapprovalNotes")).sendKeys("Unapprove text");
            driver.findElement(By.id("chkUnapprovalNotes")).click();
            driver.findElement(By.id("Button5")).click();
        }
    }

}
