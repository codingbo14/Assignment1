package pages;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;

	public static void initDriver() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void takeScreenshot(WebDriver driver) {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date(0);
		String label = formatter.format(date);

		try {
		FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+ "/screenshot/" + label + ".png"));
		} catch (IOException e) {
		e.printStackTrace();
		}

		}
	
	
	public int randomNumGenerator(int bound) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(bound);
		return generatedNum;

	}

	
}


