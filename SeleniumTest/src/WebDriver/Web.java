package WebDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Web{
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:/Users/maria/Downloads/geckodriver-v0.35.0-win64/geckodriver.exe"); 
		WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://bsi.uniriotec.br/");
	    String pageTitle = driver.getTitle();
	    
	    WebElement ulElement = driver.findElement(By.id("main-menu"));

        List<WebElement> liElements = ulElement.findElements(By.xpath("./li"));

        for (WebElement li : liElements) {
        	String nomeLi = li.getText();
        	
        	if (nomeLi.equals("PROFESSORES")) {
        		li.click();
        		break;
        	}
        }
	    
	    driver.close();
	}
}
