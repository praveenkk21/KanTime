package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class listners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println(result.getName() +" test is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("The name of the testcase is success :"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("The name of the testcase is failure :"+result.getName());
        String methodName= result.getName().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = null;
        try {
            driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        takeScreenShot(methodName, driver);
    }

    public void takeScreenShot(String methodName, WebDriver driver) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE_dd_HHmmss_yyyy");
        String formattedDate = sdf.format(today.getTime()).toLowerCase();
        System.out.println(formattedDate);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/"+methodName+"_"+formattedDate+".png"));
            System.out.println("***Placed screen shot in screenshots ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("The name of the testcase is started :"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}
