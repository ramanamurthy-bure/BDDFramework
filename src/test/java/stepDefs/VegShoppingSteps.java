package stepDefs;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import functions.CommonFunctions;

public class VegShoppingSteps {

	CommonFunctions cfn = new CommonFunctions();
	public WebDriver driver;
	public String bName = "Chrome";

	@Given("^user navigates to VegShop site \"([^\"]*)\"$")
	public void user_navigates_to_VegShop_site(String appUrl) throws Throwable {
		cfn.LaunchApp(appUrl, bName);
		driver = cfn.getDriver();
	}

	@When("^user enters vegname as \"([^\"]*)\" and find price$")
	public void user_enters_vegname_as_and_find_price(String veggieeName) throws Throwable {
		driver = cfn.getDriver();
		List<WebElement> allVegs;
		List<WebElement> filterdVeggie;
		do {
			allVegs = driver.findElements(By.xpath("//td[1]"));
			filterdVeggie = allVegs.stream().filter(s -> s.getText().contains(veggieeName)).map(s -> getPrice(s))
					.collect(Collectors.toList());

			filterdVeggie.forEach(s -> System.out.println(s.getText()));

			if (filterdVeggie.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			} else {
				System.out.println("Price of the Veggiee -> " + veggieeName + " : " + filterdVeggie.get(0).getText());
			}

		} while (filterdVeggie.size() < 1);

	}

	private static WebElement getPrice(WebElement s) {
		WebElement elm = s.findElement(By.xpath("following-sibling::td[1]"));
		return elm;
	}

}
