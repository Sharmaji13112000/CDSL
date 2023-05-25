package Bases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CDSL_Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public  void intialization (){
		
		loadPropertiesFile();
		String browserName = prop.getProperty("Browser");
		if (browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();			
		} else if (browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("ie")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
		
	public void tearDown() {
		driver.quit();
		}
		
	public void loadPropertiesFile() {
		FileInputStream fis;
		String ConfigFilePath = "C:\\Users\\vivek.s\\eclipse-workspace\\CDSL\\src\\main\\java\\Config\\config.Properties";
		try {
			fis = new FileInputStream(ConfigFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


}
