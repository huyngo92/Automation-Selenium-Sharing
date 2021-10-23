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
        driver.get("https://www.globalsqa.com/angularJs-protractor/registration-login-example/#/login");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("haint52");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("haint522021");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

}
