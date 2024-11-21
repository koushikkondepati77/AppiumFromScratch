package org.koushik.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.koushik.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsCatalogue extends AndroidActions {
    AndroidDriver driver;

    public ProductsCatalogue(AndroidDriver driver){
        super(driver); //calls parent class constructor
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'ADD TO CART']")
    private List<WebElement> addToCart;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;

    public void addItemToCartByIndex(int index){
        addToCart.get(index).click();
    }

    public CartPage goToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }


}
