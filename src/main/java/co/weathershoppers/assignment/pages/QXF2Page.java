package co.weathershoppers.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static co.weathershoppers.assignment.constants.URLConstants.QXF2_LINK;
import static co.weathershoppers.assignment.utils.AssertUtils.verifyURLEquals;
import static co.weathershoppers.assignment.utils.ElementActions.goBack;

public class QXF2Page {
    public QXF2Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void verifyURL(){
        verifyURLEquals(QXF2_LINK);
    }

    public void goBackToPreviousPage(){
        goBack();
    }
}
