import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.Request;
import org.openqa.selenium.devtools.v95.network.model.Response;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkLogActivity {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().browserVersion("95.0.4638.54").setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));


		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			//System.out.println(req.getUrl()); //Getting the url to which are sending the request
		});

		//Events will be fired.
		devTools.addListener(Network.responseReceived(), response->
		{
			Response res = response.getResponse();
			// System.out.println(res.getUrl());
			//System.out.println(res.getStatus());	//getting the status for the response received from the URL		

			if(res.getStatus().toString().startsWith("2"))
			{
				System.out.println(res.getUrl()+" is passing with the status code "+res.getStatus());
			}
			else
			{
				System.out.println(res.getUrl()+" is failing with the status code "+res.getStatus());
			}

		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();
		Thread.sleep(2000);
	}

}
