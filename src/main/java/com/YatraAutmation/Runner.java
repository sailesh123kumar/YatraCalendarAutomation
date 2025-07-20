package com.YatraAutmation;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		handlingPopUp(wait);
		clickDepartureDate(wait);
		WebElement currentMonth = selectTheMonthFromCalenDar(wait, 0);
		WebElement nextMonth = selectTheMonthFromCalenDar(wait, 1);
		Thread.sleep(2000);

		String currentMonthlowest = getlowestPriceDay(currentMonth);
		String NextMonthLowest = getlowestPriceDay(nextMonth);
		
		System.out.println(currentMonthlowest);
		System.out.println(NextMonthLowest);

		compareTwoMonthsprice(currentMonthlowest, NextMonthLowest);

	}

	private static void clickDepartureDate(WebDriverWait wait) {
		By departureDateLocator = By.xpath("//div[@aria-label=\"Departure Date inputbox\"]");
		WebElement departureDate = wait.until(ExpectedConditions.elementToBeClickable(departureDateLocator));
		departureDate.click();
	}

	private static void handlingPopUp(WebDriverWait wait) {
		By popUpLocator = By.xpath("(//div[contains(@class,'style_popup')])[1]");
		
		try {
			WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpLocator));
			WebElement crossButton = popUp.findElement(By.xpath(".//img[@alt='cross']"));
			crossButton.click();
			
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Pop up wer'nt appeared in the Page");
		}
	}

	private static String getlowestPriceDay(WebElement monthWebElement) {
		int lowestPrice = Integer.MAX_VALUE;
		WebElement priceElement = null;
		By dateWithPrice = By.xpath(".//span[contains(@class,\"custom-day-content\")]");
		List<WebElement> priceList = monthWebElement.findElements(dateWithPrice);
		String priceText;
		for (WebElement price : priceList) {
			priceText = price.getText();
			if (priceText.length() > 0) {
				priceText = priceText.replace("₹", "").replace(",", "");
				int priceValue = Integer.parseInt(priceText);
				if (lowestPrice > priceValue) {
					lowestPrice = priceValue;
					priceElement = price;
				}
			}
		}

		WebElement dateElement = priceElement.findElement(By.xpath(".//..//.."));
		@Nullable
		String date = dateElement.getAttribute("aria-label");
		String result = "Date is ==> " + date + " Lowest Price in the month is ==> Rs" + lowestPrice;
		return result;
	}

	public static WebElement selectTheMonthFromCalenDar(WebDriverWait wait, int index) {
		By monthContainerLocator = By.xpath("//div[@class=\"react-datepicker__month-container\"]");
		List<WebElement> calenederMonthsList = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(monthContainerLocator));
		WebElement monthWebElement = calenederMonthsList.get(index);
		return monthWebElement;
	}

	public static void compareTwoMonthsprice(String currentMonthPrice, String nextMonthPrice) {

		int currentMonthRsIndex = currentMonthPrice.indexOf("Rs");
		int nextMonthRsIndex = nextMonthPrice.indexOf("Rs");

		String currentMonthLowestPrice = currentMonthPrice.substring(currentMonthRsIndex + 2);
		String nextMonthLowestPrice = nextMonthPrice.substring(nextMonthRsIndex + 2);

		int nextMonthLowestPriceValue = Integer.parseInt(nextMonthLowestPrice);
		int currentMonthLowestPricevValue = Integer.parseInt(currentMonthLowestPrice);

		if (nextMonthLowestPriceValue > currentMonthLowestPricevValue) {
			System.out.println("The lowest price between 2 month is current " + currentMonthLowestPricevValue);
		} else if (nextMonthLowestPriceValue == currentMonthLowestPricevValue) {
			System.out.println("Both the month price is same! You may choose whatever you want");
		}

		else {
			System.out.println("The lowest price between 2 month is Next " + nextMonthLowestPriceValue);

		}

	}

}
