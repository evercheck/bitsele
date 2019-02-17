package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinition.PageObject.PageProvider.*;

public class IssueSteps {

    @When("^User click Add Issue Bitmark button$")
    public void clickAddIssue() {
        getWebAppPage().linkAddIssueBitmark.click();

    }

    @Then("^User verify Upload Asset page opens$")
    public void verifyUploadAssetPage() {
        assertTrue(getWebAppPage().optionAddFile.isDisplayed());
        assertTrue(getWebAppPage().linkInputTextDirectly.isDisplayed());
        assertTrue(getWebAppPage().linkInputWorkPressPost.isDisplayed());
        getWebAppPage().verifyLabelIsDisplayed("Maximum file upload size: 100 MB");
        getWebAppPage().verifyLabelIsDisplayed("This process may take a few minutes, depending on file size and network speed.");

    }

    @When("^User click Add File button$")
    public void clickAddFile() {
        getWebAppPage().optionAddFile.click();
    }

    @When("^User select a file which has never been selected to issue before$")
    public void selectUniqueFIle() {
        /**
         * Expected: It opens the Files Browsing dialog
         * Files browsing dialog belong to operating system not the webpage so we can not verify it with Protractor or Selenium
         * There're several ways to work around and help verify this window but ussualy people skip this
         *
         * Selecting file still can be done by next step
         */
        getWebAppPage().selectFile();
    }

    @Then("^User verify Asset page opens$")
    public void verifyAssetPage() {
        getAssetPage().verifyLabelIsDisplayed("Asset fingerprint");
        getAssetPage().verifyLabelIsDisplayed("Metadata");
        getAssetPage().verifyLabelIsDisplayed("Number Of Bitmarks");
        getAssetPage().verifyLabelIsDisplayed("Ownership Claim");
        Support.waitForVisible(getAssetPage().buttonIssue);
        assertTrue(getAssetPage().buttonIssue.isDisplayed());
    }

    @When("^User enter the required information$")
    public void enterRequiredInfor() {
        getAssetPage().textboxPropertyName.sendKeys("bittractor");
        getAssetPage().textboxNumberOfBitmark.sendKeys("85");
    }

    @When("^User click Issue button$")
    public void clickIssueButton() {
        getAssetPage().buttonIssue.click();
    }

    /**
     * Passing text to verify from step also can be improve to use with common element with text
     */
    @Then("^User verify the text (.*) is displayed$")
    public void verifyTextIsDisplayed(String value) {
        getAssetPage().verifyLabelIsDisplayed(value);
    }

    @Then("^User verify Issue button is disabled$")
    public void verifyIssueButtonIsDisabled() {
        Assert.assertFalse(getAssetPage().buttonIssue.isEnabled());
    }

    @Then("^User verify Your Properties page appears after few seconds")
    public void verifyYourPropertiesPage() {
        Support.waitForVisible(getPropertiesPage().linkYourProperties);
        assertTrue(getPropertiesPage().linkYourProperties.isDisplayed());
        assertEquals(getPropertiesPage().linkYourProperties.getAttribute("class"), "is-active");
    }

    @Then("^User verify the new issued bitmarks are added on top of the Properties list$")
    public void verifyNewIssuedAreAdded() {
        assertEquals("", getPropertiesPage().cellTimeStamp.getText());
        assertEquals("VERIFYING", getPropertiesPage().cellDetails.getText());
    }

    @Then("^User verify the bitmarks are confirmed after few minutes \\(3 minutes\\)$")
    public void verifyBitmarksAreConfired() {
        Support.waitForVisible(getPropertiesPage().linkDownload, 3 * 60);
        assertTrue(Support.isValidDateFormat("yyyy MMM dd HH:mm:ss", getPropertiesPage().cellTimeStamp.getText()));
        assertEquals("DOWNLOAD", getPropertiesPage().cellDetails.getText());
    }
}
