package org.krishna.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumUtils {
    public AppiumDriverLocalService service;
    public AppiumDriverLocalService startAppiumServer(String ipAddress, int portNumber){
        service = new AppiumServiceBuilder()
                .withAppiumJS(
                        new File("C:\\Users\\krish\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ipAddress).usingPort(portNumber)
//                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
//                .usingDriverExecutable(new File("C:\\Users\\krish\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .build();
        service.start();
        return service;
    }

    public void expWaitForEleVisibility(AppiumDriver driver,WebElement ele) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOf(ele));
    }
    public void expWaitForAttributeContains(AppiumDriver driver,WebElement ele, String attribute, String value) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.attributeContains(ele, attribute, value));
    }
    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1).trim());
        return price;
    }

    public List<HashMap<String,String>> getJsonData(String fileName ){

        List<HashMap<String, String>> data = null;
        try {
            //Convert JSON File Content to JSON String
            String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\krishna\\testData\\"+fileName), StandardCharsets.UTF_8);
            //Convert the JSON String to HashMap
            ObjectMapper objectMapper = new ObjectMapper();
            data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public String getScreenshotPath(String testCaseName, AppiumDriver driver){
        File sourceFilePath = driver.getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
        try {
            FileUtils.copyFile(sourceFilePath,new File(destinationFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationFilePath;
    }
}
