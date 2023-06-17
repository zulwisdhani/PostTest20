package com.juaracoding;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class TestCatatanKeuangan {
    AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Xiaomi 12T");
        dc.setCapability("udid", "MZAMA65DXSCESCA6");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("appWaitActivity","com.rookie.catatankeuangan.feature.main.MainActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, dc);

    }

    @Test(priority = 1)
    public void testOutcome(){
        MobileElement FabMenu = driver.findElementById("com.chad.financialrecord:id/fabMenu");
        FabMenu.click();
        delay(2);
        MobileElement etAmount = driver.findElementById("com.chad.financialrecord:id/etAmount");
        etAmount.sendKeys("20000");
        MobileElement etNote = driver.findElementById("com.chad.financialrecord:id/etNote");
        etNote.sendKeys("Makanan");
        MobileElement btSave = driver.findElementById("com.chad.financialrecord:id/btSave");
        btSave.click();
        delay(2);
        MobileElement result = driver.findElementById("com.chad.financialrecord:id/tvExpense");
        String actualResult =  result.getText();
        String expectResult = "20.000";
        Assert.assertEquals(actualResult,expectResult);
    }

    @Test(priority = 2)
    public void TestIncome(){
        MobileElement fabMenu = driver.findElementById("com.chad.financialrecord:id/fabMenu");
        fabMenu.click();
        delay(2);
        MobileElement btnIncome = driver.findElementById("com.chad.financialrecord:id/btnIncome");
        btnIncome.click();
        MobileElement etAmount = driver.findElementById("com.chad.financialrecord:id/etAmount");
        etAmount.sendKeys("10000000");
        MobileElement etNote = driver.findElementById("com.chad.financialrecord:id/etNote");
        etNote.sendKeys("Gaji");
        MobileElement btSave = driver.findElementById("com.chad.financialrecord:id/btSave");
        btSave.click();
        delay(2);
        MobileElement result = driver.findElementById("com.chad.financialrecord:id/tvIncome");
        String actualResult =  result.getText();
        String expectResult = "10.000.000";
        Assert.assertEquals(actualResult,expectResult);
    }
    static void delay(long sec){
        try {
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
