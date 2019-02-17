package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static stepDefinition.PageObject.PageProvider.*;

public class SignInSteps {

    @Given("^User open web app (.*)$")
    public void openWebApp(String url) {
        getSignInPage().openPage(url);
    }

    @Then("^User verify Sign In page is displayed$")
    public void verifySignInPageIsDisplayd() {
        Support.waitForVisible(getSignInPage().tabSignInSignUp);
        assertTrue(getSignInPage().tabSignInSignUp.isDisplayed());
        assertTrue(getSignInPage().tabSignInWithApp.isDisplayed());
        assertTrue(getSignInPage().buttonContinue.isDisplayed());
        assertTrue(getSignInPage().labelTitle.isDisplayed());
    }

    @When("^User click Continue button$")
    public void clickContinueButton() {
        getSignInPage().buttonContinue.click();
    }

    @Then("^User verify email is submit successful$")
    public void verifyEmailIsSubmit() {
        getSignInPage().verifyEmailIsSubmit();
    }

    @Then("^User verify Continue button is (disabled|enabled)$")
    public void verifyContinueButton(String status) {
        getSignInPage().verifyElementStatus(getSignInPage().buttonContinue, Status.valueOf(status.toUpperCase()));
    }

    @Given("^User sign in to the Bitmark Web app$")
    public void signInWebApp() {
        this.openWebApp("https://webapp.test.bitmark.com/");
        this.enterEmail("bittractor@gmail.com");
        this.clickContinueButton();
        this.signInWithMagicLink();
    }

    @When("^User enter email (.*)$")
    public void enterEmail(String email) {
        getSignInPage().textboxEmail.sendKeys(email);

        getSignInPage().scenarioContext.put("email", email);
    }

    @When("^User click on the received sign-in magic link$")
    public void signInWithMagicLink() {
        getMailPage().openPage("https://gmail.com");
        // wait for receiving email
        Support.sleep(5);
        getMailPage().textboxEmailGmail.sendKeys(getSignInPage().scenarioContext.get("email"));
        getMailPage().buttonNextEmail.click();
        Support.waitForVisible(getMailPage().textboxPassword);
        getMailPage().textboxPassword.sendKeys("Password123@");
        getMailPage().buttonNextPassword.click();
        Support.waitForVisible(getMailPage().labelBitmarkMail);
        getMailPage().labelBitmarkMail.click();
        Support.waitForVisible(getMailPage().linkSignIn);
        Support.sleep(2);
        getSignInPage().openPage(getMailPage().linkSignIn.getText());
    }

    @Then("User is signed in Bitmark Web app")
    public void userIsSignedInWebApp() {
        Support.waitForVisible(getWebAppPage().linkYourProperties);
        assertTrue(getWebAppPage().linkYourProperties.isDisplayed());
        assertTrue(getWebAppPage().linkAddIssueBitmark.isDisplayed());
        assertTrue(getWebAppPage().linkTransactions.isDisplayed());
    }
}
