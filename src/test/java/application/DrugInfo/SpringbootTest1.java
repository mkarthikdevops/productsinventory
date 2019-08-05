import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SpringbootTest1 {
	private WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		
		
	 System.setProperty("wdm.chromeDriverVersion", "75.0.3770.140");
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.get("http://localhost:8020");
	 driver.manage().window().maximize();
	 driver.findElement(By.xpath("/html/body/div/nav/div/div/ul/li[2]/a")).click();
	 driver.findElement(By.xpath("//*[@id=\"productId\"]")).sendKeys("13");	
	 driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("Analysis");
	 driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys("113");
	 driver.findElement(By.xpath("//*[@id=\"imageUrl\"]")).sendKeys("image");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/button")).click();
	 //driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
	 TimeUnit.SECONDS.sleep(2);
	 driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div/a")).click();
	 //driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
	 TimeUnit.SECONDS.sleep(2);
	 driver.close();
	 
	}

}