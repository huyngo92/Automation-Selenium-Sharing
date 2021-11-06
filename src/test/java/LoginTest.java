import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class LoginTest {


    @Test
    public void testRunLoginPage() {


        /* Driver Chrome Path**/
        File file = new File("/src/bin/windows/chromedriver.exe");
        String driverChromePath = System.getProperty("user.dir") + file.getPath();
        System.setProperty("webdriver.chrome.driver", driverChromePath);
        /* Init new Chrome Driver**/
        WebDriver driver = new ChromeDriver();
        /* Get new URL **/
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//label[text()='Username']//parent::div//input")).sendKeys("John Doe");
        driver.findElement(By.xpath("//label[text()='Password']//parent::div//input")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

    }

}
