package pageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.Driver;


import java.util.List;

public class AbstractClass {

    WebDriver driver;
    WebDriverWait wait;

    public AbstractClass(){
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver,10);
    }

    public void clickFunction(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }


    public void sendKeysFunction(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(value); //sendKeysElement=>e-mail  XXXX  value=my e-mail
    }


    public void selectElementFromDropdown(WebElement dropdown, String element) {
        Select slc = new Select(dropdown);
        slc.selectByVisibleText(element);
    }


    public void Assertion(WebElement actual, String expected) { //sistemin verdiği, sistemden beklediğimiz
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(), expected);
        System.out.println("My Message: " + actual.getText());
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

}
