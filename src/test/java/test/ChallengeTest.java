package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import support.Environment;

public class ChallengeTest {

	private WebDriver driver;
	private String place = "Limerick";
	private Boolean isHotelSavoyPresent = false;
	private Boolean isHotelGregoryPresent = false;
	private Boolean isHotelLimerickPresent = false;

	@Before
	public void setUp() {
		driver = Environment.createChrome();

	}

	@Test
	public void iChooseFiveStartsAndSeeTheHotelTest() throws InterruptedException {
		isHotelSavoyPresent = false;

		buildBaseFilter();
		driver.findElement(By.xpath("//*[@id=\"filter_class\"]/div[2]/a[3]/label/div/span")).click();

		// time to update the result list (make sure that the list take the correct
		// filter)
		Thread.sleep(2000);

		List<WebElement> hotels = driver.findElements(By.className("sr_item_new"));

		// test machine
		hotels.stream().forEach(h -> {
			String hotelName = h.findElement(By.className("sr-hotel__name")).getText();
			if (hotelName.equals("The Savoy Hotel"))
				isHotelSavoyPresent = true;
			if (hotelName.equals("George Limerick Hotel")) {
				isHotelGregoryPresent = true;
			}
		});

		assertTrue(isHotelSavoyPresent);
		assertFalse(isHotelGregoryPresent);

	}

	@Test
	public void iChooseSaunaAndSeeTheHotelTest() throws InterruptedException {
		isHotelLimerickPresent = false;

		buildBaseFilter();
		driver.findElement(By.xpath("//*[@id=\"filter_popular_activities\"]/div[2]/a[3]/label/div/span[1]")).click();

		// time to update the result list (make sure that the list take the correct
		// filter)
		Thread.sleep(3000);

		List<WebElement> hotels = driver.findElements(By.className("sr_item_new"));

		// test machine
		hotels.stream().forEach(h -> {
			String hotelName = h.findElement(By.className("sr-hotel__name")).getText();
			if (hotelName.equals("Limerick Strand Hotel"))
				isHotelLimerickPresent = true;
			if (hotelName.equals("George Limerick Hotel")) {
				isHotelGregoryPresent = true;
			}
		});

		assertTrue(isHotelLimerickPresent);
		assertFalse(isHotelGregoryPresent);

	}

	private void buildBaseFilter() {

		driver.findElement(By.id("ss")).sendKeys(place);
		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span")).click();
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[2]")).click();
		}

		driver.findElement(
				By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[3]/td[7]"))
				.click();
		driver.findElement(By
				.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr[4]/td[1]/span/span"))
				.click();

		driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")).click();
	}

	@After
	public void finish() {
		driver.quit();
	}
}
