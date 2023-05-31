package task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;

public class ParallelMethodTests {
    WebDriver driver;

    @Test(priority = 1)
    void testChrome() throws InterruptedException {
        System.out.println("Thread Id For Chrome:" + Thread.currentThread().getId());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://aman9392.github.io/tamplate-aman/#");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Aman/tamplate");
    }

    @Test(priority = 2)
    void testSafari() throws InterruptedException {
        System.out.println("Thread Id For Chrome:" + Thread.currentThread().getId());
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("https://aman9392.github.io/tamplate-aman/#");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Aman/tamplate");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    String str1 = null;
    String str2 = null;

    @Test
    void MyAssertNuLlTest() {
        assertNull(str1);
    }

    @Test
    void MyAssertNuLlTestWithMessage() {
        assertNull(str1, "The String Is Not Null");
    }

    @Test
    void MyAssertNuLlTestFail() {
        assertNull(str2);
    }

    @Test
    void MyAssertNuLlTestWithMessageFail() {
        assertNull(str2, "The String Is Not Null");
    }

}
