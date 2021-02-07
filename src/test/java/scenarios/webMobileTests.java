package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure there are relevant values when you search for the keyword Epam")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("https://google.com/"); // open GOOGLE homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check GOOGLE homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Google") : "This is not Google homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }

}
