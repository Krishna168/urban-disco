package org.latest.practice;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockedNetworkUrls {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().browserVersion("95.0.4638.54").setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools =driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//h2[contains(text(),'Latest')]")).click();
		long endTime =System.currentTimeMillis();
		System.out.println(endTime);
		System.out.println(endTime-startTime);

	}

}
