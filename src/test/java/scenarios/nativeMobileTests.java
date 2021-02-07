package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test for registering a new account and logging into it")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("registerBtn").click();
        getPo().getWelement("email").sendKeys("Elizaveta_Vasenko@epam.com");
        getPo().getWelement("username").sendKeys("Elith Vasenko");
        getPo().getWelement("password").sendKeys("vas05ENKO$$");
        getPo().getWelement("confirmPassword").sendKeys("vas05ENKO$$");
        getPo().getWelement("registerAccount").click();
        getPo().getWelement("loginEmail").sendKeys("Elizaveta_Vasenko@epam.com");
        getPo().getWelement("loginPassword").sendKeys("vas05ENKO$$");
        getPo().getWelement("signInBtn").click();

        Assert.assertEquals(getPo().getWelement("budgetActivityTitle").getText(), "BudgetActivity",
                "Wrong title of users name");

        System.out.println("Simplest Android native test done");
    }
}
