package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SearchForFlightPageObject {
	WebDriver driver = null;

	public SearchForFlightPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='gosuggest_inputSrc']")
	public WebElement txtFrom;
	@FindBy(css = "input[id='gosuggest_inputDest']")
	public WebElement txtDest;
	@FindBy(xpath = "//input[@id='departureCalendar']")
	public WebElement deptdate;
	@FindBy(xpath = "//div[@class='DayPicker-Caption']")
	public WebElement month;
	@FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	public WebElement nextMonth;
	@FindBy(css = "span[id=oneway]")
	public WebElement oneway;
	@FindBy(xpath = "//div[@class='calDate']")
	public List<WebElement> dateList;
	@FindBy(xpath = "//button[@class='fb button orange large ht55 fltHpySrchBtn gr-search-btn']")
	public WebElement searchbtn;
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[2]/div/div[5]/div/div/div[2]/div/span/span/input")
	public WebElement btnBook;
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/button")
	public WebElement btnviewFare;
	
	@FindBy (xpath="//span[@class='logSprite icClose']")
	public WebElement closePopup;

	// div[@class='DayPicker DayPicker--en']/div[2]/div[@class='DayPicker-Caption']
	// div[@class='DayPicker --NavBar']/span[@class='DayPicker -NavButton DayPicker
	// - NavButton--next']
	public void enterFrom(String city) throws InterruptedException {
		txtFrom.clear();
		txtFrom.sendKeys(city);
		Thread.sleep(1000);
		txtFrom.sendKeys(Keys.ARROW_DOWN);
		txtFrom.sendKeys(Keys.ENTER);
	}

	public void enterDest(String city) throws InterruptedException {
		txtDest.clear();
		txtDest.sendKeys(city);
		Thread.sleep(1000);
		txtDest.sendKeys(Keys.ARROW_DOWN);
		txtDest.sendKeys(Keys.ENTER);
	}

	public void enterway() {
		closePopup.sendKeys(Keys.ARROW_DOWN);
		//oneway.click();
	}

	public void enterDate(int day, String mon) throws InterruptedException {
		deptdate.click();
		while (!month.getText().contains(mon)) {
			nextMonth.click();

		}
		int count = dateList.size();
		dateList.get(day - 1).click();
	}
	
	public void searchbtn() {
		Actions action = new Actions(driver);
		searchbtn.click();
	}

	public String validate_nextPage() {
		return driver.getTitle();
		
	}


	public void ticket_summary() throws InterruptedException {
		
		btnviewFare.click();
		btnBook.click();
		Thread.sleep(2000);
	}


	
}
