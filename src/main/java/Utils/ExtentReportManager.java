package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	public static ExtentReports getInstance() {
		if (extent == null) {
			
			String timestamp= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reportpath = "report/ExtentReport"+timestamp+".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
			
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Execution Report");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		
		return extent;
		
	}
	
	public ExtentTest createTest(String testName) {
		
		test =getInstance().createTest(testName);
		
		return null;
		
	}
	
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path= System.getProperty("user.dir")+ "/screenshots/"+screenshotName+".png";
			System.out.println("Path for screenshot is : "+path);
			FileUtils.copyFile(src, new File(path));
			return path;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
