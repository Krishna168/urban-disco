package com.krishna.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.krishna.pageObjects.android.FormPage;
import org.krishna.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    public FormPage formPage;

    @BeforeClass
    public FormPage ConfigureAppium() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                + "\\src\\main\\java\\org\\krishna\\resources\\data.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") :
                properties.getProperty("ipAddress");
        System.out.println(ipAddress);
        String portNumber = properties.getProperty("portNumber");


        // Starting the Appium Server
        service = startAppiumServer(ipAddress, Integer.parseInt(portNumber));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("androidDeviceName"));
        options.setApp(
                System.getProperty("user.dir") + "\\src\\test\\java\\com\\krishna\\resources\\" + properties.getProperty("appName"));

        driver = new AndroidDriver(service.getUrl(), options);//service.getUrl() -->Getting the URL details from the Appium Service having ipAddress and portNUmber to create Android Driver.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        formPage = new FormPage(driver);
        return formPage;
    }

    @AfterClass
    public void tearDown() {
        // Tear Down
        driver.quit(); // closing the app.
        service.stop(); // stopping the appium server
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        //Make sure place correctly your report path.
//         driver.get(System.getProperty("user.dir")+"//reports//index.html");
//         driver.findElement(By.xpath("//a[@class='dashboard-view']/i")).click();

        String reportFilePath = System.getProperty("user.dir") + "//reports//index.html";
        File file = new File(reportFilePath);
        Desktop.getDesktop().browse(file.toURI());

    }

}
