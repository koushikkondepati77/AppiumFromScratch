package org.koushik.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.koushik.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViews extends IOSActions {
    IOSDriver driver;


    public AlertViews(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
    private WebElement textEntryMenu;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopup;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH[c] 'A message'")
    private WebElement confirmMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement submit;




    public void fillTextBox(String text){
        textEntryMenu.click();
        textBox.sendKeys(text);
        acceptPopup.click();
    }





}
