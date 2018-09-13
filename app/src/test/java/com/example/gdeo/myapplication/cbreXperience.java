package com.example.gdeo.myapplication;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;


public class cbreXperience {

//    WebDriver driver;
//    private RemoteWebDriver driver;
    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("deviceName", "FA81P1A00008");
        capabilities.setCapability("deviceName", "1bc97a44");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "8.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.cbre.xperience.uat");
        capabilities.setCapability("appActivity", "com.cbre.xperience.uat.MainActivity");
        capabilities.setCapability("noReset",true);

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.

//        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

//        AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.1:4723/wd/hub"),
//                capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }



    @Test
    public void testFirstAnonymousSurvey() {

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        List<WebElement> wele = driver.findElements(By.xpath("//android.widget.ImageView"));
//        wele.get(1).click();


//        Click the Happy emoticon

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Happy']")).click();

//        Click Helpdesk
        driver.findElement(By.xpath("//android.widget.TextView[@text='Helpdesk']")).click();

//        Turn ON the anonymous switch
        driver.findElement(By.xpath("//android.widget.Switch[@text='OFF']")).click();

//        Click Yes! on the 'Want to tell us more about it?' button
        driver.findElement(By.xpath("//android.widget.TextView[@text='Yes!']")).click();

//        Enter a comment in the 'What's on your mind' textbox'
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Anonymous survey");

//        CLick the 'Let us know!' button
        driver.findElement(By.xpath("//android.widget.TextView[@text='Let Us Know!']")).click();

//        Click the 'Continue' button
        driver.findElement(By.xpath("//android.widget.TextView[@text='Continue']")).click();

//        Click the menu to go to the Feedbacks list
        driver.findElement(By.xpath("//android.widget.TextView[@text='. ']")).click();

//        Verify that the submitted anonymous feedback is not displayed in the list
        Assert.assertFalse("Entered anonymous feedback not displayed - PASS", driver.findElement(By.xpath("//android.widget.TextView[@text='Anonymous survey']")).isDisplayed());
    }

    @Test
    public void testNonAnonymousSurvey() {

            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        List<WebElement> wele = driver.findElements(By.xpath("//android.widget.ImageView"));
//        wele.get(1).click();


//        Click the Happy emoticon

            driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Happy']")).click();

//        Click Helpdesk
            driver.findElement(By.xpath("//android.widget.TextView[@text='Helpdesk']")).click();

//        Click Yes! on the 'Want to tell us more about it?' button
            driver.findElement(By.xpath("//android.widget.TextView[@text='Yes!']")).click();

//        Enter a comment in the 'What's on your mind' textbox'
            driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Anonymous survey");

//        CLick the 'Let us know!' button
            driver.findElement(By.xpath("//android.widget.TextView[@text='Let Us Know!']")).click();

//        Click the 'Continue' button
            driver.findElement(By.xpath("//android.widget.TextView[@text='Continue']")).click();

//        Click the menu to go to the Feedbacks list
            driver.findElement(By.xpath("//android.widget.TextView[@text='. ']")).click();

//        Verify that the submitted anonymous feedback is not displayed in the list
            Assert.assertTrue("Entered anonymous feedback not displayed - PASS",driver.findElement(By.xpath("//android.widget.TextView[@text='Anonymous survey']")).isDisplayed());


//            If the above xpaths do not work, the following x, y coordinates can be used instead
//
//            TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
//            touchAction.tap(PointOption.point(18, 1588)).perform(); //Optiona
//            touchAction.tap(PointOption.point(422, 458)).perform(); //Excited
//    //        Thread.sleep(2000);
//            //Click on Help
//            touchAction.tap(PointOption.point(417, 989)).perform();    //Unhappy
//    //        Thread.sleep(2000);
//            //Click on Nope
//            touchAction.tap(PointOption.point(422, 1261)).perform();
//    //        Thread.sleep(2000);
//            //Click on Continue
//            touchAction.tap(PointOption.point(103, 1281)).perform();

    //        List<WebElement> wele = driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc='Angry']"));




        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }


    @After
    public void End() {
        driver.quit();
    }
}


