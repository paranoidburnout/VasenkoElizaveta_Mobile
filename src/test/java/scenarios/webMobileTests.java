package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.TestData;

import static org.testng.AssertJUnit.assertNotNull;

public class webMobileTests extends BaseTest {

    private WebElement searchField;

    @Test(groups = {"web"}, description = "Make sure there are relevant values when you search for the keyword Epam")
    public void simpleWebTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getDriver().get("https://google.com/"); // open GOOGLE homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check GOOGLE homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Google") : "This is not Google homepage";

        searchField = getPo().getWelement("searchTextField");
        searchField.sendKeys(TestData.getProperty("wordForSearch"));
        searchField.sendKeys(Keys.ENTER);

        assertNotNull(getPo().getWelements("results"));

        // Log that test finished
        System.out.println("Site opening done");
    }
}