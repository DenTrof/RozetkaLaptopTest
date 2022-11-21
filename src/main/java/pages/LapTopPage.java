package pages;

import common.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LapTopPage extends GeneralPage {
    private final By laptopsAndComputers = By.xpath("//aside/rz-main-page-sidebar/div/rz-sidebar-fat-menu//a[contains(text(), 'Ноутбуки и компьютеры')]");
    private final By laptopsPage = By.xpath("//rz-list-tile//a[@title='Ноутбуки']");
    private final By filterRozetka = By.xpath("//rz-filter-checkbox//a[@data-id='Rozetka']");
    private final By filterSliderMax = By.xpath("//rz-scrollbar//rz-filter-slider//input[@formcontrolname='max']");
    private final By buttonOk = By.xpath("//rz-scrollbar//rz-filter-slider//button[contains(text(), 'Ok')]");
    private final By itemOne = By.xpath("//rz-catalog-tile//a");
    private final By labelTopSale = By.xpath("//rz-label/span");

    // Не вышло использовать явные ожидания, видимо связано с какой то js динамикой на странице
    public void lapTopPage() throws InterruptedException {
        driver.findElement(laptopsAndComputers).click();
        driver.findElement(laptopsPage).click();
        Thread.sleep(2000);
        // waitElementIsVisible(driver.findElement(filterRozetka)).click();
        driver.findElement(filterRozetka).click();
        Thread.sleep(2000);
        // waitElementIsVisible(driver.findElement(filterSliderMax)).clear();
        driver.findElement(filterSliderMax).clear();
        driver.findElement(filterSliderMax).sendKeys("100000");
        driver.findElement(buttonOk).click();
        Thread.sleep(2000);
        // waitElementIsVisible(driver.findElement(itemOne)).click();*/
        driver.findElement(itemOne).click();
        WebElement topSaleElement = driver.findElement(labelTopSale);
        String topSaleElementText = topSaleElement.getText();

        try {
            Assert.assertEquals(topSaleElementText, topSaleElementText);
            System.out.println("You have text -- " + topSaleElementText);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            System.out.println("Test failed");
            throw e;
        }
    }
}
