import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestC {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void initRun(){
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
        wait=new WebDriverWait(driver, Duration.ofSeconds(6));

        driver.get("https://devopsapplicationdomain.azurewebsites.net/DevProj/");


    }

    @Test
    public void RunTestForDevOps(){

        WebElement elm=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("h1"))));
        String Act=elm.getText();
        Assert.assertEquals(Act,"My Project for Dev");
    }

    @AfterTest
    public void FinalTask(){
        driver.close();
    }
}
