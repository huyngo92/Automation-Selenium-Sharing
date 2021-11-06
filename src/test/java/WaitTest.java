import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitTest {

    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @BeforeMethod
    public void setUp() {
        /* Driver Chrome Path**/
        File file = new File("/src/bin/windows/chromedriver.exe");
        String driverChromePath = System.getProperty("user.dir") + file.getPath();
        System.setProperty("webdriver.chrome.driver", driverChromePath);

        driver = new ChromeDriver();
        baseUrl = "https://formy-project.herokuapp.com/form";
        driver.manage().window().maximize();
    }


    @Test
    public void testImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("//input[@placeholder='Enter first name']"));
        element.sendKeys("Huy");
        element = driver.findElement(By.xpath("//input[@placeholder='Enter last name']"));
        element.sendKeys("Ngo");
        element = driver.findElement(By.xpath("//a[text()='Submit']"));
        element.click();
        element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        String text_alert = element.getText();
//        System.out.println(text_alert);
        Assert.assertEquals(text_alert, "The form was successfully submitted!");
    }


    @Test
    public void testExplicitlyWait() {
        WebDriverWait wait = new WebDriverWait(driver,1);
        driver.get(baseUrl);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter first name']")));
        //element = driver.findElement(By.xpath("//input[@placeholder='Enter first name']"));
        element.sendKeys("Huy");
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter last name']")));
        //element = driver.findElement(By.xpath("//input[@placeholder='Enter middle name']"));
        element.sendKeys("Ngo");
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Submit']")));
        //element = driver.findElement(By.xpath("//a[text()='Submit']"));
        element.click();
        // explicit wait - to wait for the alert is visible
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert alert-success']"))));
        //element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        String text_alert = element.getText();
        System.out.println(text_alert);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
