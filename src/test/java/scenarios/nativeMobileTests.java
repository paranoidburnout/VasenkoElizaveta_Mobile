package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import static utils.Data.*;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native", "nativeCloud"}, description = "This simple test for registering a new account and logging into it")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("registerBtn").click();
        getPo().getWelement("email").sendKeys(EMAIL);
        getPo().getWelement("username").sendKeys(USERNAME);
        getPo().getWelement("password").sendKeys(PASSWORD);
        getPo().getWelement("confirmPassword").sendKeys(PASSWORD);
        getPo().getWelement("registerAccount").click();
        getPo().getWelement("loginEmail").sendKeys(EMAIL);
        getPo().getWelement("loginPassword").sendKeys(PASSWORD);
        getPo().getWelement("signInBtn").click();

        assert (getPo().getWelement("budgetActivityTitle").isDisplayed()) : "Page BudgetActivity is not opened";

        System.out.println("Simplest Android native test done");
    }
}
