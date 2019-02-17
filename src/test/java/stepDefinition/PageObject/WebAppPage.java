package stepDefinition.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class WebAppPage extends Page {

    @FindBy(xpath = "//a[contains(text(), 'YOUR PROPERTIES')]")
    public WebElement linkYourProperties;

    @FindBy(xpath = "//a[contains(text(), 'Transactions')]")
    public WebElement linkTransactions;

    @FindBy(xpath = "//span[text()='ISSUE BITMARKS']")
    public WebElement linkAddIssueBitmark;

    @FindBy(xpath = "//span[contains(text(), '＋Add a file')]")
    public WebElement optionAddFile;

    @FindBy(xpath = "//a[text()='＋Input text directly']")
    public WebElement linkInputTextDirectly;

    @FindBy(xpath = "//a[text()='＋Input WordPress post']")
    public WebElement linkInputWorkPressPost;

    @FindBy(id = "file-input")
    private WebElement inputFileUpload;

    WebAppPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFile() {
        String filePath = createUploadFIle();
        inputFileUpload.sendKeys(filePath);
    }

    private String createUploadFIle() {
        Path filePath = Paths.get("src/test/resources/UploadFile.txt");
        Date date = new Date();
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            Files.write(filePath, String.valueOf(date.getTime()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath.toAbsolutePath().toString();
    }
}
