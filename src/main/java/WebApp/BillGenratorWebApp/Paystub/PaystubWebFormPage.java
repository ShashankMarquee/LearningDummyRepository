package WebApp.BillGenratorWebApp.Paystub;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaystubWebFormPage extends ReusableMethods {
	public WebDriver browserdriver;

	public PaystubWebFormPage(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	// Preview edit
	@FindBy(id = "preview_paystub")
	WebElement Preview_Paystub;
	@FindBy(id = "edit_paystub")
	WebElement edit_paystub;

	// Template Options
	@FindBy(id = "save_draft")
	WebElement save_Template;
	@FindBy(id = "load_template")
	WebElement load_template;
	@FindBy(id = "checkOut")
	WebElement checkOut;

	// Start Here
	@FindBy(id = "auto_calc")
	WebElement auto_calc;
	@FindBy(id = "employment_type")
	WebElement employment_type;
	@FindBy(id = "payment_type")
	WebElement payment_type;
	@FindBy(id = "payment_cycle")
	WebElement How_often_are_you_paid;
	@FindBy(id = "previous_ytd")
	WebElement previous_ytdCalculations;
	@FindBy(id = "hired_in")
	WebElement Were_you_hired_in_the_past_52_weeks;
	@FindBy(id = "paystub_need")
	WebElement paystub_need;
	@FindBy(id = "show_loader")
	WebElement show_loader;

	// Company Information
	@FindBy(id = "employer_name")
	WebElement employer_name;
	@FindBy(id = "employer_number")
	WebElement employer_number;
	@FindBy(id = "employer_address")
	WebElement employer_address;
	@FindBy(id = "employer_address_2")
	WebElement employer_address_2;
	@FindBy(id = "employer_city")
	WebElement employer_city;
	@FindBy(id = "employer_state")
	WebElement employer_state;
	@FindBy(id = "employer_zip_code")
	WebElement employer_zip_code;
	@FindBy(xpath = "//Label[@for='employer_logo_upload']")
	WebElement employer_logo_upload;

	// Employer Information
	@FindBy(id = "employee_name")
	WebElement employee_name;
	@FindBy(id = "employee_social")
	WebElement employee_social;
	@FindBy(id = "employee_id")
	WebElement employee_id;
	@FindBy(id = "employee_telephone_number")
	WebElement employee_telephone_number;
	@FindBy(id = "employee_address")
	WebElement employee_address;
	@FindBy(id = "employee_address_2")
	WebElement employee_address_2;
	@FindBy(id = "employee_city")
	WebElement employee_city;
	@FindBy(id = "employee_state")
	WebElement employee_state;
	@FindBy(id = "employee_zip_code")
	WebElement employee_zip_code;
	@FindBy(id = "employee_marital_status")
	WebElement employee_marital_status;
	@FindBy(id = "exemptions")
	WebElement exemptions;
	@FindBy(id = "is_direct_deposit")
	WebElement is_direct_deposit;
	@FindBy(id = "is_direct_deposit_no")
	WebElement is_direct_deposit_no;
	@FindBy(id = "bank_checking_account")
	WebElement bank_checking_account;

	// EARNINGS STATEMENT
	@FindBys({ @FindBy(xpath = "//span[@class='paystub_count']") })
	List<WebElement> paystubCount;
	@FindBys({ @FindBy(id = "pay_period_start") })
	List<WebElement> pay_period_start;
	@FindBys({ @FindBy(id = "pay_period_end") })
	List<WebElement> pay_period_end;
	@FindBys({ @FindBy(id = "pay_date") })
	List<WebElement> pay_date;
	@FindBy(xpath = "//select[@class='yearselect']")
	WebElement selectYear;
	@FindBy(xpath = "//select[@class='monthselect']")
	WebElement monthselect;
	@FindBys({ @FindBy(xpath = "//td[not(contains(@class,'off ends'))][contains(@data-title,'r')]") })
	List<WebElement> activeDate;
	@FindBys({ @FindBy(xpath = "//button[contains(@class,'applyBtn')][not(contains(@disabled,'disabled'))]")})
	List<WebElement> ApplyButton;
	
	//Earnings
	@FindBys({ @FindBy(name = "regular_rate") })
	List<WebElement> regular_rate;
	@FindBys({ @FindBy(name = "regular_hours") })
	List<WebElement> regular_hours;
	@FindBys({ @FindBy(name = "regular_total") })
	List<WebElement> regular_total;
	@FindBys({ @FindBy(name = "ytd1") })
	List<WebElement> regular_ytd1;
	@FindBys({ @FindBy(name = "overtime_rate") })
	List<WebElement> overtime_rate;
	@FindBys({ @FindBy(name = "overtime_hours") })
	List<WebElement> overtime_hours;
	@FindBys({ @FindBy(name = "overtime_total") })
	List<WebElement> overtime_total;
	@FindBys({ @FindBy(name = "ytd2") })
	List<WebElement> overtime_ytd2;
	@FindBys({ @FindBy(name = "holiday_rate") })
	List<WebElement> holiday_rate;
	@FindBys({ @FindBy(name = "holiday_hours") })
	List<WebElement> holiday_hours;
	@FindBys({ @FindBy(name = "holiday_total") })
	List<WebElement> holiday_total;
	@FindBys({ @FindBy(name = "ytd3") })
	List<WebElement> holiday_ytd3;
	@FindBys({ @FindBy(name = "vacation_rate") })
	List<WebElement> vacation_rate;
	@FindBys({ @FindBy(name = "vacation_hours") })
	List<WebElement> vacation_hours;
	@FindBys({ @FindBy(name = "vacation_total") })
	List<WebElement> vacation_total;
	@FindBys({ @FindBy(name = "ytd4") })
	List<WebElement> vacation_ytd4;
	@FindBys({ @FindBy(name = "bonus_rate") })
	List<WebElement> bonus_rate;
	@FindBys({ @FindBy(name = "bonus_hours") })
	List<WebElement> bonus_hours;
	@FindBys({ @FindBy(name = "bonus_total") })
	List<WebElement> bonus_total;
	@FindBys({ @FindBy(name = "ytd5") })
	List<WebElement> bonus_ytd5;
	@FindBys({ @FindBy(name = "float_rate") })
	List<WebElement> float_rate;
	@FindBys({ @FindBy(name = "float_hours") })
	List<WebElement> float_hours;
	@FindBys({ @FindBy(name = "float_total") })
	List<WebElement> float_total;
	@FindBys({ @FindBy(name = "ytd6") })
	List<WebElement> float_ytd6;
	@FindBys({ @FindBy(name = "tips_rate") })
	List<WebElement> tips_rate;
	@FindBys({ @FindBy(name = "tips_total") }) // need to change to tips_hours
	List<WebElement> tips_hours;
	@FindBys({ @FindBy(id = "total7") }) // need to change to tips_total with name attribute
	List<WebElement> tips_total;
	@FindBys({ @FindBy(name = "ytd7") })
	List<WebElement> tips_ytd7;
	@FindBys({ @FindBy(xpath = "//input[contains(@id,'custome_earnings_total')]") }) 
	List<WebElement> custome_earnings_total;
	@FindBys({ @FindBy(xpath = "//input[@name='custome_earnings_ytd_total']") }) 
	List<WebElement> custome_earnings_ytd_total;

	@FindBy(xpath = "//a[normalize-space()='+ ADD EARNINGS']")
	WebElement AddEarnings;

	@FindBy(xpath = "//a[normalize-space()='+ ADD DEDUCTIONS']")
	WebElement AddDeductions;

	@FindBys({ @FindBy(xpath = "//input[contains(@id,'custome_deduction_label')]") })
	List<WebElement> custome_deduction_label;

	@FindBys({ @FindBy(xpath = "//input[contains(@id,'custome_deduction_total')]") })
	List<WebElement> custome_deduction_total;

	@FindBy(xpath = "//input[@id='custom_earning_label_1']")
	WebElement custom_earning_label_1;
	@FindBys({ @FindBy(xpath = "//input[contains(@id,'custome_earnings_rate')]") })
	List<WebElement> custome_earnings_rate;
//	@FindBy(xpath = "//input[@name='custome_earnings_rate']")
//	WebElement custome_earnings_rate1;
	@FindBys({ @FindBy(xpath = "//input[contains(@id,'custome_earnings_hours')]") })
	List<WebElement> custome_earnings_hours;

	@FindBys({ @FindBy(name = "//i[@class='fa fa-minus font-icon']") })
	List<WebElement> minusIcon;

	@FindBys({ @FindBy(id = "tcurrent") })
	List<WebElement> grossPayTotal;

	@FindBys({ @FindBy(id = "tytd") })
	List<WebElement> grossPayYTDTotal;

	// REVIEW YOUR FINAL PAYSTUB
	@FindBy(xpath = "//button[@id='1']")
	WebElement Template1;
	@FindBy(xpath = "//button[@id='2']")
	WebElement Template2;
	@FindBy(xpath = "//button[@id='3']")
	WebElement Template3;
	@FindBy(xpath = "//button[@id='4']")
	WebElement Template4;
	@FindBy(xpath = "//bu5ton[@id='5']")
	WebElement Template5;
	@FindBy(xpath = "//buton[@id='6']")
	WebElement Template6;

	public void pressPreview() {
		turnOnWaitOnBrowser();
		browserdriver.manage().window().maximize();
//		Expwait.until(ExpectedConditions
//				.visibilityOf(Preview_Paystub));
		Preview_Paystub.click();
	}

	// Initial selections
	public void select_how_often_you_paid(String howOftenPaid)
	{
		Select howoften= new Select(How_often_are_you_paid);
		howoften.selectByVisibleText(howOftenPaid);
		turnOnWaitOnBrowser();
		Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
	}
	public void select_NoOfPaystubsNeeded(String paystubCount) {
		Select paystubneed = new Select(paystub_need);
		paystubneed.selectByVisibleText(paystubCount);
		turnOnWaitOnBrowser();
		Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
	}

//Enter employerCompany details
	public void enterEmployer_name(String Employer_name) {
		employer_name.sendKeys(Employer_name);
	}
	public void enterEmployerNumber(String EmployerNumber) {
		employer_number.sendKeys(EmployerNumber);
	}
	public void enterEmployerAddress(String EmployerAddress) {
		employer_address.sendKeys(EmployerAddress);
	}
	public void enterEmployerAddress2(String EmployerAddress2) {
		employer_address_2.sendKeys(EmployerAddress2);
	}
	public void enterEmployerCity(String EmployerCity) {
		employer_city.sendKeys(EmployerCity);
	}
	public void selectEmployerState(String EmployerState) {
		Select empState = new Select(employer_state);
		empState.selectByVisibleText(EmployerState);
	}
	public void enterEmployerZipCode(String EmployerZipCode) {
		employer_zip_code.sendKeys(EmployerZipCode);
	}
	public void enterEmployerLogoUpload() {
		employer_logo_upload.sendKeys("C:\\Users\\Marquee\\Pictures\\file_example_JPG_2500kB.jpg");
	}
	// Enter employee details
	public void enterEmployee_Name(String Employee_Name) {
		employee_name.sendKeys(Employee_Name);
	}
	public void enterEmployee_Social(String Employee_Social) {
		employee_social.sendKeys(Employee_Social);
	}

	public void enterEmployee_Id(String Employee_Id) {
		employee_id.sendKeys(Employee_Id);
	}

	public void enterEmployee_Telephone_Number(String Employee_Telephone_Number) {
		employee_telephone_number.sendKeys(Employee_Telephone_Number);
	}

	public void enterEmployee_Address(String Employee_Address) {
		employee_address.sendKeys(Employee_Address);
	}

	public void enterEmployee_Address_2(String Employee_Address_2) {
		employee_address_2.sendKeys(Employee_Address_2);
	}

	public void enterEmployee_City(String Employee_City) {
		employee_city.sendKeys(Employee_City);
	}

	public void selectEmployee_State(String Employee_State) {
		Select employeeState = new Select(employee_state);
		employeeState.selectByVisibleText(Employee_State);
	}

	public void enterEmployee_Zip_Code(String Employee_Zip_Code) {
		employee_zip_code.sendKeys(Employee_Zip_Code);
	}

	public void selectEmployee_Marital_Status(String Employee_Marital_Status) {
		// employee_marital_status.sendKeys(Employee_Marital_Status);
		Select empMartialStatus = new Select(employee_marital_status);
		empMartialStatus.selectByVisibleText(Employee_Marital_Status);
	}

	public void selectExemptions(String Exemptions) {
		// exemptions.sendKeys(Exemptions);
		Select selectExemptions = new Select(exemptions);
		selectExemptions.selectByVisibleText(Exemptions);
	}

	public void markIs_direct_deposit() {
		is_direct_deposit.click();
	}

	public void markIs_direct_deposit_no() {
		is_direct_deposit_no.click();
	}

	public void enterBank_Checking_Account(String Bank_Checking_Account) {
		bank_checking_account.sendKeys(Bank_Checking_Account);
	}

	// Enter Earning statement
	public void enterPay_period_start(int paystubNumber, String Year, String Month, String Date) {
		pay_period_start.get(paystubNumber - 1).click();
		Select year = new Select(selectYear);
		year.selectByVisibleText(Year);
		Select month = new Select(monthselect);
		month.selectByVisibleText(Month);
		for (int i = 0; i < activeDate.size(); i++) {
			if (activeDate.get(i).getText().equals(Date)) {
				activeDate.get(i).click();
				break;
			}
		}
		for(int i=0;i<ApplyButton.size();i++)
		{
			if(ApplyButton.get(i).isDisplayed())
			{
				ApplyButton.get(i).click();
			}
		}
	}

	//Earning data
	//Regular
	public void enterRegularRates(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(regular_rate, paystubNumber - 1);
		regular_rate.get(paystubNumber - 1).sendKeys(data);
	}
	public paystubTemplate1 enterRegularHours(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(regular_hours, paystubNumber - 1);
		regular_hours.get(paystubNumber - 1).sendKeys(data);
		browserdriver.findElement(By.xpath("//*[@id='tips_total']")).click();
		paystubTemplate1 paystubTemplate1= new paystubTemplate1(browserdriver);
		return paystubTemplate1;
	}
	public String getRegularTotal(int paystubNumber)
	{
		return regular_total.get(paystubNumber -1).getText();
	}
	public String getRegularYTDTotal(int paystubNumber)
	{
		return regular_ytd1.get(paystubNumber -1).getText();
	}
	
	//OverTime
	public void enterOverTimeRate(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(overtime_rate, paystubNumber - 1);
		overtime_rate.get(paystubNumber - 1).sendKeys(data);
	}
	public void enterOverTimeHours(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(overtime_hours, paystubNumber - 1);
		overtime_hours.get(paystubNumber - 1).sendKeys(data);
	}
	public String getOverTimeTotal(int paystubNumber)
	{
		return overtime_total.get(paystubNumber -1).getText();
	}
	public String getOverTimeYTDTotal(int paystubNumber)
	{
		return overtime_ytd2.get(paystubNumber -1).getText();
	}

	//Holiday
	public void enterHolidayRate(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(holiday_rate, paystubNumber - 1);
		holiday_rate.get(paystubNumber - 1).sendKeys(data);
	}
	public void enterHolidayHours(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(holiday_hours, paystubNumber - 1);
		holiday_hours.get(paystubNumber - 1).sendKeys(data);
	}
	public String getHolidayTotal(int paystubNumber)
	{
		return holiday_total.get(paystubNumber -1).getText();
	}
	public String getHolidayYTDTotal(int paystubNumber)
	{
		return holiday_ytd3.get(paystubNumber -1).getText();
	}
	
	//Vacation
	public void enterVacationRate(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(vacation_rate, paystubNumber - 1);
		vacation_rate.get(paystubNumber - 1).sendKeys(data);
	}

	public void enterVacationHours(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(vacation_hours, paystubNumber - 1);
		vacation_hours.get(paystubNumber - 1).sendKeys(data);
	}
	public String getVacationTotal(int paystubNumber)
	{
		return vacation_total.get(paystubNumber -1).getText();
	}
	public String getVacationYTDTotal(int paystubNumber)
	{
		return vacation_ytd4.get(paystubNumber -1).getText();
	}

	//Bonus
	public void enterBonusRate(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(bonus_rate, paystubNumber - 1);
		bonus_rate.get(paystubNumber - 1).sendKeys(data);
	}
	public void enterBonusHours(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(bonus_hours, paystubNumber - 1);
		bonus_hours.get(paystubNumber - 1).sendKeys(data);
	}
	public String getBonusTotal(int paystubNumber)
	{
		return bonus_total.get(paystubNumber -1).getText();
	}
	public String getBonusYTDTotal(int paystubNumber)
	{
		return bonus_ytd5.get(paystubNumber -1).getText();
	}

	//Float
	public void enterFloatRate(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(float_rate, paystubNumber - 1);
		float_rate.get(paystubNumber - 1).sendKeys(data);
	}
	public void enterFloatHours(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(float_hours, paystubNumber - 1);
		float_hours.get(paystubNumber - 1).sendKeys(data);
	}
	public String getFloatTotal(int paystubNumber)
	{
		return float_total.get(paystubNumber -1).getText();
	}
	public String getFloatYTDTotal(int paystubNumber)
	{
		return float_ytd6.get(paystubNumber -1).getText();
	}

	//Tips
	public void enterTipsRate(int paystubNumber, String data) throws InterruptedException {
		clearDataWithIndex(tips_rate, paystubNumber - 1);
		tips_rate.get(paystubNumber - 1).sendKeys(data);
	}
	public String getTipsTotal(int paystubNumber)
	{
		return tips_total.get(paystubNumber -1).getText();
	}
	public String getTipsYTDTotal(int paystubNumber)
	{
		return tips_ytd7.get(paystubNumber -1).getText();
	}
	
	//custome_earnings
	public void pressAddEarnings() throws InterruptedException {
		turnOnWaitOnBrowser();
		browserdriver.findElement(By.xpath("//*[@id='tips_total']")).click();
		if (show_loader.getAttribute("style").contains("opacity")) {
			Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
		}
		AddEarnings.click();
	}
	public void entercustom_earning_Name(String name) {
		custom_earning_label_1.sendKeys(name);
	}
	public void enterCustom_earningRate(int paystubNumber, String data) {
		clearDataWithIndex(custome_earnings_rate, paystubNumber - 1);
		// custome_earnings_rate1.clear();
		// browserdriver.findElement(By.xpath("(//input[@name='custome_earnings_hours'])[1]")).click();
		custome_earnings_rate.get(paystubNumber - 1).sendKeys(data);
	}
	public void enterCustom_earningHours(int paystubNumber, String data) {
		clearDataWithIndex(custome_earnings_hours, paystubNumber - 1);
		custome_earnings_hours.get(paystubNumber - 1).sendKeys(data);
	}
	public String getcustome_earnings_total(int paystubNumber)
	{
		return tips_total.get(paystubNumber -1).getText();
	}
	public String getCustomeEarningsYTDtotal(int paystubNumber)
	{
		return tips_ytd7.get(paystubNumber -1).getText();
	}

	public void pressAddDeductions() {
		turnOnWaitOnBrowser();
		browserdriver.findElement(By.xpath("//*[@id='tips_total']")).click();
		if (show_loader.getAttribute("style").contains("opacity")) {
			Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
		}
		AddDeductions.click();
	}

	public void enterCustomDeductionName(int paystubNumber, String data) {
		custome_deduction_label.get(paystubNumber).sendKeys(data);
	}

	public void enterCistomDeductions(int paystubNumber, String data) {
		clearDataWithIndex(custome_deduction_total, paystubNumber - 1);
		custome_deduction_total.get(paystubNumber - 1).sendKeys(data);
	}

	// Template Buttons
	public void clickTemplate1() {
		Template1.click();
	}

	public paystubTemplate2 clickTemplate2() {
		Template2.click();
		paystubTemplate2 temp2= new paystubTemplate2(browserdriver);
		return temp2;
	}

	public paystubTemplate3 clickTemplate3() {
		Template3.click();
		paystubTemplate3 paystubTemplate3 = new paystubTemplate3(browserdriver);
		return paystubTemplate3;
	}

	public void clickTemplate4() {
		Template4.click();
	}

	public void clickTemplate5() {
		Template5.click();
	}

	public void clickTemplate6() {
		Template6.click();
	}

	
}
