package org.koushik;

import io.appium.java_client.AppiumBy;
import org.koushik.pageObjects.ios.AlertViews;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest{

    @Test
    public void IOSBasicsTest(){
        //Xpath, classname, IOS, iosClasschain, IOSPredicateString, accessibilityId, id
        //xpath is very slow in IOS compared to android
        //xpath - xml language
        //iosClassChain is 80% looks like xpath syntax and also faster than xpath

        AlertViews alertViews = homePage.selectAlertViews();
        alertViews.fillTextBox("koushik kondepati");




        }

}
