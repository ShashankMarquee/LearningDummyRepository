package WebApp.BillGenratorWebApp.Paystub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paystubTemplate4 extends ReusableMethods{

	public WebDriver browserdriver;

	public paystubTemplate4(WebDriver browserdriver) {
		super(browserdriver);
		this.browserdriver = browserdriver;
		PageFactory.initElements(new AppiumFieldDecorator(browserdriver), this);
		// TODO Auto-generated constructor stub
	}
}
