package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import pageObjectModel.DialogContent;

import java.awt.*;

import java.util.concurrent.TimeUnit;

public class Steps_telefonvertrag {

    WebDriver driver;

    DialogContent dialogContent=new DialogContent();

    @Given("^Navigate to Telefon Vertrag home page$")
    public void navigateToTelefonVertragHomePage() {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://telefonvertrag.de/");
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @And("^Handel the cookies$")
    public void handelTheCookies() {
        dialogContent.findElementAndClickFunction("cookies");
    }

    @And("^Click the Kabel$")
    public void clickTheKabel() {
        dialogContent.findElementAndClickFunction("kabelBtn");
        dialogContent.waitForPage("Kabel");
    }

    @And("^Find the related information about tariffs$")
    public void findTheRelatedInformationAboutTariffs() {
        dialogContent.tarifDetailsClickAll("tarifDetails");
    }

    @And("^See the correct information about selected tariff$")
    public void seeTheCorrectInformationAboutSelectedTariff() {
        dialogContent.tarifDetailsClickAll("produktInfoBlatt");
    }

    @Then("^Write comment about a tariff$")
    public void writeCommentAboutATariff() {
    }

    @Then("^Add tariff to the cart$")
    public void addTariffToTheCart() {
    }

    @And("^Make an order after entering your information$")
    public void makeAnOrderAfterEnteringYourInformation() {
    }


}
