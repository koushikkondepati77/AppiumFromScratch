package org.koushik;


import io.appium.java_client.AppiumBy;
import org.koushik.pageObjects.android.CartPage;
import org.koushik.pageObjects.android.ProductsCatalogue;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ECommerceTC04 extends AndroidBaseTest {

   //Handling hybrid app [ switching btw native to web ]
    @Test
    public void FillForm() throws InterruptedException {

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        formPage.setNameField("koushik kondepati");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
        ProductsCatalogue productsCatalogue = formPage.submitForm();

        productsCatalogue.addItemToCartByIndex(0);
        productsCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = productsCatalogue.goToCartPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

        double totalSum = cartPage.getProductsSum();
        double totalAmountDisplayed = cartPage.getTotalAmountDisplayed();

        Assert.assertEquals(totalSum, totalAmountDisplayed);
        cartPage.acceptTermsConditions();
        cartPage.submitOrder();

//        Set<String> contexts = driver.getContextHandles();
//        for(String contextName:contexts){
//            System.out.println(contextName);
//        }
//
//        driver.context("WEBVIEW_com.androidsample.generalstore");
//        driver.findElement(By.name("q")).sendKeys("koushik kondepati");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.context("NATIVE_APP");


    }


}
