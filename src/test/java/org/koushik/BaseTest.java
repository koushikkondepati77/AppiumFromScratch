package org.koushik;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.koushik.pageObjects.android.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {

    public AndroidDriver driver;
    public FormPage formPage;

    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("koushiPixel3a");
        //options.setChromedriverExecutable("C:\\Users\\koush\\Downloads\\chromedriver_win32");
        //options.setApp("C:\\Users\\koush\\IdeaProjects\\AppiumQuickDemo\\src\\test\\java\\resourses\\ApiDemos-debug.apk");
        options.setApp("C:\\Users\\koush\\IdeaProjects\\AppiumQuickDemo\\src\\test\\java\\resourses\\General-Store.apk");

        //from java 20 and above version "URL class" is deprecated, so to avoid any errors we have to use URI("**").toURL()
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        formPage = new FormPage(driver);
        Thread.sleep(2000);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
