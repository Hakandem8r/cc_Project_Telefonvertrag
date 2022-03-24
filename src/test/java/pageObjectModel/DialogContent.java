package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;


public class DialogContent extends AbstractClass {

    WebElement myElement;
    List<WebElement> myElements;


    public DialogContent() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Akzeptiere alle']")
    private WebElement cookies;

    @FindBy(xpath = "(//a[text()='Kabel'])[2]")
    private WebElement kabelBtn;

    @FindBy(css = "div.breadcrumbs h1")
    private WebElement pageHeader;

    @FindAll({
            @FindBy(xpath = "//a[text()='Tarifdetails ansehen']")
    })
    private List<WebElement> tarifDetails;

    @FindBy(css = "button.close")
    private WebElement closeTarif;

    @FindAll({
            @FindBy(xpath = "//a[text()='Produktinformationsblatt']")
    })
    private List<WebElement> produktInfoBlatt;

    @FindAll({
            @FindBy(xpath = "//a[text()='Tarifpreis monatlich']")
    })
    private List<WebElement> tarifPreisRandom;

    @FindBy(xpath = "//a[text()='Tarife Bewertungen']")
    private WebElement tarifeBewertung;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    private WebElement name;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    private WebElement emailAddresse;

    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement kommentar;

    @FindBy(xpath = "//button[text()='Bewertung Senden']")
    private WebElement bewertungSenden;


   /* public void clickCookies(){
        clickFunction(cookies);
    }

    public void clickKabelBtn(){
        clickFunction(kabelBtn);
    }

    public void clickKommentar(){
        clickFunction(kommentar);
    } */


    public void findElementAndClickFunction(String ElementName) {
        switch (ElementName) {
            case "cookies":
                myElement = cookies;
                break;
            case "kabelBtn":
                myElement = kabelBtn;
                break;
        }
        clickFunction(myElement);
    }

    public void tarifList(){
        myElements=tarifDetails;
        for (WebElement el:myElements) {
            el.click();
            bekle(1000);
            closeTarif.click();
        }

    }















    public void tarifDetailsClickAll(String elements) {
        switch (elements) {
            case "tarifDetails":
                myElements = tarifDetails;
                myElement = closeTarif;
                clickOneByOne();
                break;


            case "produktInfoBlatt":
                myElements = produktInfoBlatt;
                productInfoClickAll();
                break;


        }

    }

    private void clickOneByOne() {
        for (WebElement e : myElements) {
            clickFunction(e);
            bekle(1000);
            clickFunction(myElement);

        }

    }

    public void bekle(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPage(String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(pageHeader, text));
        System.out.println(pageHeader.getText());
        System.out.println(text);
    }

    private void productInfoClickAll(){
        String currentWindow = driver.getWindowHandle();
        Set<String> windows;
        for (WebElement e:myElements){
            e.click();
            windows=driver.getWindowHandles();
            for (String handle:windows){
                if (!handle.equalsIgnoreCase(currentWindow)){
                    driver.switchTo().window(handle);
                    bekle(1000);
                    driver.close();
                    driver.switchTo().window(currentWindow);
                }
            }
        }
    }

}
