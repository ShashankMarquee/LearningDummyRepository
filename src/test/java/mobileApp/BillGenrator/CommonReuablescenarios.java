package mobileApp.BillGenrator;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.Dashboard;
import base.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class CommonReuablescenarios extends BaseClass {

	@BeforeClass
	public void beforeeverymethodinsameclass() throws IOException {
		ConfigurAndroid();
	}
	
	@Test(priority = 3)
	public void verifyRotateToLandscape() throws InterruptedException, IOException {
		
		ScreenOrientation oriantaion = driver.getOrientation();
		System.out.println("Current Oriantation: " + oriantaion);
		try {
			driver.rotate(oriantaion.LANDSCAPE);
			ScreenOrientation oriantaion1 = driver.getOrientation();
			System.out.println("Current Oriantation: " + oriantaion1);
			if(!oriantaion1.equals(oriantaion))
			{
				Assert.fail("Landscape is not allowed but still app shows in landscape");
			}
			Assert.fail("Landscape is not allowed but still app shows in landscape");
		//	Thread.sleep(5000l);
		} catch (InvalidElementStateException e) {
			// TODO Auto-generated catch block
		}
	}

	@Test(priority = 2)
	public void LoginWithValidCred() throws InterruptedException {

		SoftAssert softAssertion1 = new SoftAssert();
		restartapp();
		dashboard = flashscreen.pressGetStarted();
		loginScreen = dashboard.pressLogin();

		loginScreen.EnterUserEmail(propConnection.getProperty("username"));
		loginScreen.EnterPassword(propConnection.getProperty("pass"));
		loginScreen.pressSignIn();

		Expwait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.view.View[@content-desc='User logged in successfully.']")));
		String toastmessage = driver
				.findElement(By.xpath("//android.view.View[@content-desc='User logged in successfully.']"))
				.getAttribute("content-desc");
		System.out.println("Success message: " + toastmessage);
		softAssertion1.assertEquals(toastmessage, "User logged in successfully.");
		softAssertion1.assertAll();
	}

	@Test(priority = 1, dataProvider = "testLogindata")
	public void LoginWithInValidCred(String uname, String password) throws InterruptedException {

		SoftAssert softAssertion1 = new SoftAssert();
		restartapp();
		dashboard = flashscreen.pressGetStarted();
		loginScreen = dashboard.pressLogin();

		loginScreen.EnterUserEmail(uname);
		loginScreen.EnterPassword(password);
		System.out.println("UsernameEmail: " + uname + "\nPassword: " + password);
		dashboard = loginScreen.pressSignIn();

		try {
			turnonwaitforseconds(6);
			softAssertion1.assertFalse(dashboard.returnwebelement().isDisplayed(),
					"User is logged in with invalid cred:\n Email: " + uname + "\nPassword: " + password + "");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			softAssertion1.assertTrue(true);
			// e.printStackTrace();
		}
		softAssertion1.assertAll();
	}

	@DataProvider(name = "testLogindata")
	public Object[][] TestDataFeed() {

		Object[][] logindata = new Object[10][2];
		logindata[0][0] = "";
		logindata[0][1] = "";
		logindata[1][0] = "username2gmail.com";
		logindata[1][1] = "12345";
		logindata[2][0] = "username1@gmailcom";
		logindata[2][1] = "123";
		logindata[3][0] = "username1@@gmailcom";
		logindata[3][1] = "123";
		logindata[4][0] = "@test.com";
		logindata[4][1] = "1234";
		logindata[5][0] = "shashank.marqueetest2@gmail.com";
		logindata[5][1] = propConnection.getProperty("pass");
		logindata[6][0] = "test@com.";
		logindata[6][1] = "123";
		logindata[7][0] = propConnection.getProperty("username"); // valid Username with invalid password
		logindata[7][1] = "123";
		logindata[8][0] = "tes t@t.com";
		logindata[8][1] = "12345 6";
		logindata[9][0] = " ";
		logindata[9][1] = " ";

		// return arrayobject to testscript
		return logindata;
	}

//	@Test(enabled = false)
//	public void longPresss() {
//
//		dashboard = flashscreen.pressGetStarted();
//		dashboard.drag_A_Team_Of_Experts();
//
//	}

}
