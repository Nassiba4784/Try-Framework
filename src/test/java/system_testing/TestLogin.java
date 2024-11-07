package system_testing;

import baseClasses.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestLogin extends Base {
    // WebDriver driver;
    String ValidUsername = "Admin";
    String ValidPassword = "admin123";
    String ExpectURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    HomePage homePage;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test // steps
    public void testValidLogin() {

        homePage = new HomePage(driver);
        homePage.enterUsername(ValidUsername);
        homePage.enterPassword(ValidPassword);
        homePage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), ExpectURL);
    }
}
