package task3;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CustomAnnotationWithBeforeSuiteAndAfterSuite {
    private boolean userLoggedIn;

    @BeforeSuite
    public void setUp() {
        System.out.println("Initializing the test environment");
    }

    @Test
    public void testUserLogin() {

        System.out.println("Performing user login");
        userLoggedIn = true;
        Assert.assertTrue(userLoggedIn);
    }

    @Test(dependsOnMethods = "testUserLogin")
    public void testUserLogout() {
        System.out.println("Performing user logout");
        userLoggedIn = false;
        Assert.assertFalse(userLoggedIn);
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Cleaning up resources");
    }
}
