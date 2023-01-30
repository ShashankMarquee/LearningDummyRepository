package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate2 extends ReusableMethods{

	public WebDriver browserdriver;

	public paystubTemplate2(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	//company address on template 2
	@FindBy(xpath="//div[@class='col-9']//div[@class='w-50 text-uppercase']")
	WebElement companytopAddress;
	
	
	@FindBy(xpath="//td[@class='p-0 border-0 text-end']//span[@class='fica_medicare_total']")
	WebElement FicaMedicareTemplate2;
	
	public String getTopCompanyNameTemplate2()
	{
		return companytopAddress.getText();
	}
	
	public String getFICAMedicareTemplate2()
	{
		return FicaMedicareTemplate2.getText();
	}
}
