package org.koushik;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.koushik.pageObjects.ios.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IOSBaseTest {
    public IOSDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 13 Pro");
        options.setApp("/Users/Somedummypath/UIKitCatalog.app");
        options.setPlatformVersion("15.5");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        //from java 20 and above version "URL class" is deprecated, so to avoid any errors we have to use URI("**").toURL()
        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }




}
