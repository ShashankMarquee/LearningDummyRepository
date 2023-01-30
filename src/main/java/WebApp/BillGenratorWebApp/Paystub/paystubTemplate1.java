package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate1 extends ReusableMethods {

	public WebDriver browserdriver;

	public paystubTemplate1(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "show_loader")
	WebElement show_loader;
	// Template 1 Preview data
	@FindBy(xpath = "//div[@class='w-50 text-uppercase']")
	WebElement Template1CompanyDetails1;
	@FindBy(xpath = "//div[@class='col-7']//div[@class='d-flex mt-3']")
	WebElement Template1SocSecurityMaratialStatusExemptions;
	@FindBy(xpath = "//table[@class='mt-3']")
	WebElement Template1AllPeriodsAllDate;
	@FindBy(xpath = "//div[@class='d-flex mt-3']//div[@class='text-uppercase']")
	WebElement Template1EmployeeDetails;
	@FindBy(xpath = "//table[@class='table table-borderless ms-3']")
	WebElement Template1GrossPayAndAllDeductions;
	@FindBy(xpath = "(//td[text()='FICA Medicare']/following-sibling::td/span)[1]")
	WebElement Template1FICAMedicareTotal;
	@FindBy(xpath = "(//span[@class='fica_social_security_total'])[1]")
	WebElement Template1FICASocialSecurityTotal;
	@FindBy(css = "td[class='pt-1 pb-1 p-0 text-end'] span[class='federal_tax_total']")
	WebElement Template1FederalTaxTotal;
	@FindBy(xpath = "//td[@class='pt-1 pb-1 p-0 text-end']//span[@class='state_tax_total']")
	WebElement Template1StateTaxTotal;
	@FindBy(xpath = "//td[@class='pt-1 pb-1 p-0 text-end']//span[@class='sdi_total']")
	WebElement Template1SDITaxTotal;
	@FindBy(xpath = "//td[@class='pt-1 pb-1 p-0 text-end']//span[@class='sui_total']")
	WebElement Template1SUITaxTotal;
	@FindBy(xpath = "//td[@class='pt-1 pb-1 p-0 text-end']//span[@class='wc_total']")
	WebElement Template1WCTaxTotal;
	@FindBy(xpath = "//td[@class='pt-1 pb-1 p-0 text-end']//span[@class='wf_total']")
	WebElement Template1WorkForceDevTaxTotal;
	
	
	@FindBy(xpath = "//td[@class='pt-1 pb-1 p-0 text-end']//span[@class='fli_total']")
	WebElement Template1FLITaxTotal;
	
	@FindBy(xpath = "//table[@class='table table-borderless']")
	WebElement Template1OtherBenifitsInformations;
	@FindBy(xpath = "//div[@class='d-flex']//div[@class='text-uppercase']")
	WebElement Template1CompanyDetails2;
	@FindBy(xpath = "(//div[@class='d-flex']/parent::div)[2]")
	WebElement Template1BottomPayDateSocialSecurityNo;
	@FindBy(css = "td[class='p-0; text-uppercase'] span[class='employee_name']")
	WebElement Template1BottomEmployeeNameWithDirectDepositYes;
	@FindBy(css = "td[class='pt-1 text-uppercase'] span[class='employee_name']")
	WebElement Template1BottomEmployeeNameWithDirectDepositNo;
	@FindBy(xpath = "//th[contains(text(),'Account Number')]/../../following-sibling::tbody/tr/td[2]")
	WebElement Template1BottomAccountNumberWithDirectDepositYes;
	@FindBy(css = "td[class='p-0'] span[class='net_pay']")
	WebElement Template1BottomTotalAmountWithDirectDepositYes;
	@FindBy(css = "(//span[@class='net_pay'])[3]")
	WebElement Template1BottomTotalAmountWithDirectDepositNo;
	@FindBy(xpath = "//td[normalize-space()='This amount']/following-sibling::td[1]")
	WebElement Template1BottomTotalAmountWithDirectDepositNoInWords;

	public void waitTillLoaderEnds() throws InterruptedException {
		if (show_loader.getAttribute("style").contains("opacity")) {
			turnOnWaitOnBrowser();
			Expwait.until(ExpectedConditions.attributeToBe(show_loader, "style", "display: none;"));
		}
		// Thread.sleep(3000l);
	}

	public String getFICAMedicareTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FICAMedicareTotal.getText();
	}

	public String getFicasocialSecurityTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FICASocialSecurityTotal.getText();
	}

	public String getFederalTaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FederalTaxTotal.getText();
	}

	public String getStateTaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1StateTaxTotal.getText();
	}

	public String getSDITaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1SDITaxTotal.getText();
	}

	public String getSUITaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1SUITaxTotal.getText();
	}
	public String getWCTaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1WCTaxTotal.getText();
	}
	public String getFLITaxTotalTemplate1() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1FLITaxTotal.getText();
	}
	public String getTemplate1WorkForceDevTaxTotal() throws InterruptedException {
		waitTillLoaderEnds();
		return Template1WorkForceDevTaxTotal.getText();
	}
	
}
