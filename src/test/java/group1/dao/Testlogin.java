package group1.dao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testlogin {
	
	private String Url = "https://www.netflix.com/login";
    WebDriver driver = null;
    @BeforeTest
    public void setUp() {
        // Thiết lập trình duyệt Chrome
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        
    }   

    @Test
    public void testLogin() throws InterruptedException {
    	driver.manage().window().maximize();
        driver.get(Url);
        // Chờ trang web tải đầy đủ
        //Thread.sleep(5000);

        WebElement email = driver.findElement(By.name("userLoginId"));
        WebElement password = driver.findElement(By.name("password"));
        email.sendKeys("numpadagain@gmail.com");
        password.sendKeys("131331aA");
        
 
        password.submit();

    

        String expectedTitle = "Netflix";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title of homepage is not as expected.");
    }
  
      
    @AfterTest
    public void tearDown() {
        // Đóng trình duyệt
        driver.close();
    }

}
