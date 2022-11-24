package pages;

import common.CommonAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.ConfigConstants.TimeOutVariable.WAIT_ELEMENT_TIME;

public class GeneralPage {
    protected WebDriver driver = CommonAction.createDriver();

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_ELEMENT_TIME).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}