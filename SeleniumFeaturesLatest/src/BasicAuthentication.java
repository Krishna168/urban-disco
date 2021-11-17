import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().browserVersion("95.0.4638.54").setup();
		ChromeDriver driver = new ChromeDriver();
		Predicate<URI> uriPredicate = uri->uri.getHost().contains("the-internet.herokuapp.com");

		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
