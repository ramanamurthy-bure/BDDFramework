package stepDefs;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.CommonFunctions;

public class HomePageSteps {

	CommonFunctions cfn = new CommonFunctions();
	public  WebDriver driver;
	public String bName = "Chrome";

	@Given("^user navigates to \"([^\"]*)\" site$")
	public void user_navigates_to_site(String appUrl) throws Throwable {
		cfn.LaunchApp(appUrl, bName);
		driver = cfn.getDriver();
	}

	@When("^user enters booking details$")
	public void user_enters_booking_details() throws Throwable {
		WebElement elmCCy = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select sel = new Select(elmCCy);
		ArrayList<String> allOptionText = new ArrayList<String>();
		List<WebElement> alOptions = sel.getOptions();
		for (WebElement elm : alOptions) {
			allOptionText.add(elm.getText().trim());
		}

		System.out.println(sel.getFirstSelectedOption().getText());
		System.out.println(allOptionText);

		WebElement elmDepartureCity = driver.findElement(By.xpath("//input[@value='Departure City']"));
		elmDepartureCity.click();

		WebElement elmDeptCity = driver.findElement(By.xpath("//a[contains(text(),'Chennai (MAA)')]"));
		elmDeptCity.click();

		WebElement elmArvCity = driver.findElement(By.xpath("//a[contains(text(),'Goa (GOI)')]"));
		elmArvCity.click();

		WebElement emDeptDate = driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight"));
		emDeptDate.click();

		WebElement elmRoundTrip = driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]"));
		elmRoundTrip.click();

		WebElement elmRetunDateBtn = driver
				.findElement(By.xpath("//label[contains(text(),'Return date')]/following::button"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.elementToBeClickable(elmRetunDateBtn));
		elmRetunDateBtn.click();

		WebElement emArrDate = driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight"));
		emArrDate.click();

		elmRetunDateBtn.click();
		List<WebElement> allDates = driver.findElements(By.xpath("//span[text()='March']/following::td"));
		String elmDateToSelect = "23";

		for (WebElement elmDate : allDates) {
			if (elmDate.getText().equalsIgnoreCase(elmDateToSelect)) {
				elmDate.click();
				break;
			}
		}

		WebElement elmTypeToSel = driver
				.findElement(By.xpath("//input[@id='autosuggest' and @placeholder='Type to Select']"));
		elmTypeToSel.clear();
		elmTypeToSel.sendKeys("Ind");
		WebElement elmInd = driver.findElement(By.xpath("//a[text()='India']"));
		elmInd.click();

		WebElement elmCheckIn = driver.findElement(By.xpath("//span[text()='Check-In']"));
		Actions act = new Actions(driver);
		act.moveToElement(elmCheckIn);

		StringBuilder sb = new StringBuilder();
		List<WebElement> allToolTextPara = driver.findElements(By.xpath("//span[text()='Check-In']/following::div/p"));
		for (WebElement emlmPara : allToolTextPara) {
			sb.append(emlmPara.getText() + "\n");
		}

	}

	@Then("^capture screenshot$")
	public void capture_screenshot() throws Throwable {
		// Taking page screenshot
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dst1 = new File("./Screenshots/Page.png");
		FileUtils.copyFile(src1, dst1);

		// Taking screenshot for a WebElement
		WebElement elmImg = driver.findElement(By.cssSelector("div.slider__item a img"));
		File fs = elmImg.getScreenshotAs(OutputType.FILE);
		File dstSave = new File("./Screenshots/WebElement.png");
		FileUtils.copyFile(fs, dstSave);

		if (bName.equalsIgnoreCase("Firefox")) {
			// Taking full page screenshot - Option available in only Firefox Driver
			File src2 = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
			File dst2 = new File("./Screenshots/FullPage.png");
			FileUtils.copyFile(src2, dst2);
		} else if (bName.equalsIgnoreCase("Chrome")) {

		} else if (bName.equalsIgnoreCase("Edge")) {

		}

	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}

}
