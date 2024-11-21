package org.koushik.pageObjects.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.koushik.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver){
        super(driver); //calls parent class constructor
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    //driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"))

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;

    @AndroidFindBy(id="android:id/text1")
    private WebElement countryDropDownBtn;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    public void setNameField(String name){
        nameField.sendKeys(name);
    }

    public void setGender(String gender){
        if(gender.contains("female")){
            femaleOption.click();
        } else{
            maleOption.click();
        }
    }

    public void setCountrySelection(String countryName){
        countryDropDownBtn.click();
        scrollToText(countryName);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();

    }

    public ProductsCatalogue submitForm(){
        shopButton.click();
        return new ProductsCatalogue(driver);
    }
}
