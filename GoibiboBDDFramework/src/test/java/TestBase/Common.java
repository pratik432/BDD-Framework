package TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Common {
	
	public static WebDriver driver;
	public static Properties p =new Properties();
	
	public Common() {
	try {
	FileReader reader= new FileReader("C:\\Users\\Prati\\eclipse-workspace\\GoibiboBDDFramework\\resources\\input.properties");
	p.load(reader);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
	public void initialization(String url) {
		String browserName =p.getProperty("browser");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\chromedriver.exe");
			 driver=new ChromeDriver();
		}		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prati\\Downloads\\geckodriver");
			 driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(p.getProperty(url));
	}
}
