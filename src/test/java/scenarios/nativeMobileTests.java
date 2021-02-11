package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.TestData;

import static utils.Data.*;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test for registering a new account and logging into it")
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

        Assert.assertEquals(getPo().getWelement("budgetActivityTitle").getText(), TestData.getProperty("title"),
                "Wrong title of users name");

        System.out.println("Simplest Android native test done");
    }
}
