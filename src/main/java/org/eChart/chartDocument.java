package org.eChart;

import org.openqa.selenium.WebDriver;

public class chartDocument {
    private final WebDriver driver;
    private String status;
    public chartDocument(WebDriver driver){
        this.driver=driver;
    }

    public void setStatus(String status){
        this.status=status;
    }

   // public void

}
