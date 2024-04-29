package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;
    By passwordField=org.openqa.selenium.By.id("txt_password");
    By usernameField =org.openqa.selenium.By.id("txt_username");
    By loginClick=By.id("btn_login");

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsernameBy(String name) {
        driver.findElement(usernameField).sendKeys(name);
    }

    public void enterPasswordBy(String name) {
        driver.findElement(passwordField).sendKeys(name);
    }

    public void loginClickBy() {
        driver.findElement(loginClick).click();
    }

}
