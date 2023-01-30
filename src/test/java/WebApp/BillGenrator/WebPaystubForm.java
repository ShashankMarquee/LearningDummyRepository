package WebApp.BillGenrator;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class WebPaystubForm extends BaseClass {

	@BeforeClass
	public void beforeeverymethodinsameclass() throws IOException {
		configureBrowser();
		browserdriver.get("http://staging.onlinebillgenerator.com/paystub");
	}

	@Test(description = "Enter all the inputs in paystub form.")
	public void enterAllInputs() throws InterruptedException {
		// Enter All Inputs
		browserdriver.manage().window().maximize();
		// enter company details
		PaystubWebFormPage.enterEmployer_name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployerNumber(propConnection.getProperty("PaystubEmployerTelephoneNumber"));
		PaystubWebFormPage.enterEmployerAddress(propConnection.getProperty("PaystubEmployerStreetAddress1"));
		PaystubWebFormPage.enterEmployerAddress2(propConnection.getProperty("PaystubEmployerStreetAddress2"));
		PaystubWebFormPage.enterEmployerCity(propConnection.getProperty("PaystubCompanyCity"));
		PaystubWebFormPage.selectEmployerState(propConnection.getProperty("PaystubCompanyState"));
		PaystubWebFormPage.enterEmployerZipCode(propConnection.getProperty("PaystubCompanyZipCode"));
		// PaystubWebFormPage.enterEmployerLogoUpload();

		// Enter Employee details
		PaystubWebFormPage.enterEmployee_Name(propConnection.getProperty("PaystubEmployerName"));
		PaystubWebFormPage.enterEmployee_Social(propConnection.getProperty("PaystubEmployeeSocialNumber"));
		PaystubWebFormPage.enterEmployee_Id(propConnection.getProperty("PaystubEmployeeID"));
		PaystubWebFormPage.enterEmployee_Telephone_Number(propConnection.getProperty("PaystubEmployeeTelephoneNumber"));
		PaystubWebFormPage.enterEmployee_Address(propConnection.getProperty("PaystubEmployeeAddress1"));
		PaystubWebFormPage.enterEmployee_Address_2(propConnection.getProperty("PaystubEmployeeAddress2"));
		PaystubWebFormPage.enterEmployee_City(propConnection.getProperty("PaystubEmployeeCity"));
		PaystubWebFormPage.selectEmployee_State(propConnection.getProperty("PaystubEmployeeState"));
		PaystubWebFormPage.enterEmployee_Zip_Code(propConnection.getProperty("PaystubEmployeeZipCode"));
		PaystubWebFormPage.selectEmployee_Marital_Status(propConnection.getProperty("PaystubEmployeeMaritalStatus"));
		PaystubWebFormPage.selectExemptions(propConnection.getProperty("PaystubEmployeeExemptions"));
		PaystubWebFormPage.markIs_direct_deposit();
		PaystubWebFormPage.enterBank_Checking_Account(propConnection.getProperty("Bank_Checking_Account"));
		PaystubWebFormPage.markIs_direct_deposit_no();
		PaystubWebFormPage.select_NoOfPaystubsNeeded("2");
//		PaystubWebFormPage.enterRegularRates(1, "900");
//		PaystubWebFormPage.enterRegularHours(1, "9");
//		PaystubWebFormPage.enterOverTimeRate(1, "12");
//		PaystubWebFormPage.enterOverTimeHours(1, "8");
//		PaystubWebFormPage.enterHolidayRate(1, "250");
//		PaystubWebFormPage.enterHolidayHours(1, "24");
//		PaystubWebFormPage.enterVacationRate(1, "600");
//		PaystubWebFormPage.enterVacationHours(1, "24");
//		PaystubWebFormPage.enterBonusRate(1, "15000");
//		PaystubWebFormPage.enterBonusHours(1, "24");
//		PaystubWebFormPage.enterFloatRate(1, "900.33");
//		PaystubWebFormPage.enterFloatHours(1, "9");
//		PaystubWebFormPage.enterTipsRate(1, "50");
//		PaystubWebFormPage.pressAddEarnings();
//		PaystubWebFormPage.entercustom_earning_Name("test name");
//		PaystubWebFormPage.enterCustom_earningRate(1,"12");
//		PaystubWebFormPage.enterCustom_earningHours(1, "24");
//		
//		PaystubWebFormPage.enterRegularRates(2, "22");
//		PaystubWebFormPage.enterRegularHours(2, "299.99");
//		PaystubWebFormPage.enterOverTimeRate(2, "12");
//		PaystubWebFormPage.enterOverTimeHours(2, "8");
//		PaystubWebFormPage.enterHolidayRate(2, "250");
//		PaystubWebFormPage.enterHolidayHours(2, "24");
//		PaystubWebFormPage.enterVacationRate(2, "600");
//		PaystubWebFormPage.enterVacationHours(2, "24");
//		PaystubWebFormPage.enterBonusRate(2, "15000");
//		PaystubWebFormPage.enterBonusHours(2, "24");
//		PaystubWebFormPage.enterFloatRate(2, "900.33");
//		PaystubWebFormPage.enterFloatHours(2, "9");
//		PaystubWebFormPage.enterTipsRate(2, "50");
//		PaystubWebFormPage.entercustom_earning_Name("test name");
//		PaystubWebFormPage.enterCustom_earningRate(2, "22");
//		PaystubWebFormPage.enterCustom_earningHours(2, "33");
//		PaystubWebFormPage.pressAddDeductions();
//		PaystubWebFormPage.enterCustomDeductionName(1, "test deduction");
//		PaystubWebFormPage.enterCistomDeductions(1, "222.0");
//		PaystubWebFormPage.enterPay_period_start(1, "2022", "Feb", "15");
		// System.out.println(browserdriver.findElement(By.xpath("(//div[@class='d-flex']/parent::div)[2]")).getText());
		// browserdriver.switchTo().frame(null);
		
		//System.out.println(paystubTemplate2.getTopCompanyNameTemplate2());
		
		
	}

	@Test(description = "Verify FICA Medicare With Gross PayYTD Total Less Than 200000")
	public void verifyFICAMedicareWithGrossPayYTDTotalLessThan200000() throws InterruptedException {
		SoftAssert soft11 = new SoftAssert();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "900");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "9");
		String FicaMedicare = paystubTemplate1.getFICAMedicareTemplate1();
		soft11.assertEquals(FicaMedicare, "117.45");
		paystubTemplate2 = PaystubWebFormPage.clickTemplate2();
		soft11.assertEquals(paystubTemplate2.getFICAMedicareTemplate2(), "117.45");
		paystubTemplate3 = PaystubWebFormPage.clickTemplate3();
		soft11.assertEquals(paystubTemplate2.getFICAMedicareTemplate3(), "117.45");
	}

	@Test(description = "Verify FICAMedicare With GrossPay YTDTotal Greater Than 200000")
	public void verifyFICAMedicareWithGrossPayYTDTotalGreaterThan200000() throws InterruptedException {
		// PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "200000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "9");
		String FicaMedicare = paystubTemplate1.getFICAMedicareTemplate1();
		Assert.assertEquals(FicaMedicare, "42,150.00");
	}

	@Test(description = "Verify FICA-Social-Security Calculations when social is less than 9114 for the year 2022")
	public void verifyFICASocialSecurityCalculations() throws InterruptedException {
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "30");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40");
		String FICASocialSecurity = paystubTemplate1.getFicasocialSecurityTotalTemplate1();
		Assert.assertEquals(FICASocialSecurity, "74.40");
	}

	@Test(description = "Verify FICA-Social-Security Calculations when social is greater than 9114 for the year 2022 on all preview page.")
	public void verifyFicaSocialSecurityCalculations() throws InterruptedException {
		SoftAssert soft1 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "147000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		String FICASocialSecurity = paystubTemplate1.getFicasocialSecurityTotalTemplate1();
		soft1.assertEquals(FICASocialSecurity, "9,114.00");
		PaystubWebFormPage.enterRegularRates(1, "247000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		FICASocialSecurity = paystubTemplate1.getFicasocialSecurityTotalTemplate1();
		Assert.assertEquals(FICASocialSecurity, "9,114.00");
		soft1.assertAll();
	}

	@Test(description = "Verify federal tax calculations with martial status as 'Single'")
	public void VerifyFederalTaxCalculationsonTemplate1() throws InterruptedException {
		SoftAssert soft2 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		String FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft2.assertEquals(FederalTaxTotal, "1,157.33");

		// Verify federal tax with lowest value 800 as gross total
		PaystubWebFormPage.enterRegularRates(1, "10.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80.00");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft2.assertEquals(FederalTaxTotal, "0.00");

		PaystubWebFormPage.enterRegularRates(1, "80000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft2.assertEquals(FederalTaxTotal, "26,113.63");

		soft2.assertAll();
	}

	@Test(description = "Verify federal tax calculations with martial status as 'Married'")
	public void VerifyFederalTaxCalculationsWithMarriedOnTemplate1() throws InterruptedException {
		SoftAssert soft3 = new SoftAssert();
		browserdriver.navigate().refresh();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");

		PaystubWebFormPage.enterRegularRates(1, "200.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40.00");
		String FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft3.assertEquals(FederalTaxTotal, "666.75");

		PaystubWebFormPage.enterRegularRates(1, "10.00");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80.00");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft3.assertEquals(FederalTaxTotal, "0.00");

		PaystubWebFormPage.enterRegularRates(1, "80000");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "1");
		FederalTaxTotal = paystubTemplate1.getFederalTaxTotalTemplate1();
		soft3.assertEquals(FederalTaxTotal, "23,347.17");
		soft3.assertAll();
	}

	@Test(description = "Verify State tax calculations for all states with martial status as 'Married' with ytdtotal as '800' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesOnTemplate1() throws InterruptedException {
		SoftAssert soft4 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "5.33", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "10.17", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "2.02", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "5.67", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "6.67", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "25.84", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "2.70", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "4.13", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "16.92", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "16.00", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "15.02", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "40.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "34.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "2.50", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "11.20", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "18.84", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "24.56", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "1.00", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft4.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft4.assertAll();
	}

	@Test(description = "Verify State tax calculations for all states with martial status as 'Single' with ytdtotal as '800' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesWithSingleOnTemplate1() throws InterruptedException {
		SoftAssert soft5 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		// PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "26.25", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "17.50", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "4.00", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "9.89", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "11.04", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "21.12", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "25.84", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "9.43", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "15.76", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "28.46", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "14.80", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "24.32", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "40.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "34.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "10.17", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "5.37", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "4.61", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "11.20", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "5.33", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "2.24", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "34.30", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "24.56", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.94", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "39.60", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "9.07", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "10.42", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "24.00", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft5.assertAll();
	}

	@Test(description = "Verify State tax calculations for all states with martial status as 'Single' with ytdtotal as '8000' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesWithSingle2OnTemplate1() throws InterruptedException {
		SoftAssert soft5 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		// PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "386.25", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "232.75", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "412.13", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "456.97", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "314.90", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "402.50", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "425.42", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "454.94", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "423.58", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "582.68", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "396.73", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "258.40", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "492.43", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "401.25", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "388.46", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "291.56", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "458.48", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "366.32", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "400.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "340.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "436.97", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "367.92", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "358.00", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "474.29", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "425.96", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "332.41", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "315.83", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "413.65", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "346.18", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "109.44", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "186.38", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "339.16", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "660.94", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "245.60", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "286.35", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "439.05", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "382.17", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "416.98", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "426.25", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "346.30", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft5.assertAll();
	}

	@Test(description = "Verify State tax calculations for all states with martial status as 'Married' with ytdtotal as '8000' and year is 2022")
	public void VerifyStateTaxCalculationsWithAllStatesWithMarriedOnTemplate1() throws InterruptedException {
		SoftAssert soft5 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_Marital_Status("Married");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		// Alabama
		PaystubWebFormPage.selectEmployee_State("Alabama");
		String StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "362.08", "Wrong State Tax for state Alabama");

		// For Alaska
		PaystubWebFormPage.selectEmployee_State("Alaska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Alaska");
		// Arizona
		PaystubWebFormPage.selectEmployee_State("Arizona");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "160.35", "Wrong State Tax for state Arizona");

		PaystubWebFormPage.selectEmployee_State("Arkansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "429.74", "Wrong State Tax for state Arkansas");

		PaystubWebFormPage.selectEmployee_State("California");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "235.10", "Wrong State Tax for state California");

		PaystubWebFormPage.selectEmployee_State("Colorado");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "265.80", "Wrong State Tax for state Colorado");

		PaystubWebFormPage.selectEmployee_State("Connecticut");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "366.67", "Wrong State Tax for state Connecticut");

		PaystubWebFormPage.selectEmployee_State("Delaware");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "407.54", "Wrong State Tax for state Delaware");

		PaystubWebFormPage.selectEmployee_State("District Of Columbia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "363.21", "Wrong State Tax for state District Of Columbia");

		PaystubWebFormPage.selectEmployee_State("Florida");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Florida");

		PaystubWebFormPage.selectEmployee_State("Georgia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "411.67", "Wrong State Tax for state Georgia");

		PaystubWebFormPage.selectEmployee_State("Hawaii");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "506.63", "Wrong State Tax for state Hawaii");

		PaystubWebFormPage.selectEmployee_State("Idaho");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "313.45", "Wrong State Tax for state Idaho");

		PaystubWebFormPage.selectEmployee_State("Illinois");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Illinois");

		PaystubWebFormPage.selectEmployee_State("Indiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "258.40", "Wrong State Tax for state Indiana");

		PaystubWebFormPage.selectEmployee_State("Iowa");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "469.40", "Wrong State Tax for state Iowa");

		PaystubWebFormPage.selectEmployee_State("Kansas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "341.75", "Wrong State Tax for state Kansas");

		PaystubWebFormPage.selectEmployee_State("Kentucky");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "376.92", "Wrong State Tax for state Kentucky");

		PaystubWebFormPage.selectEmployee_State("Louisiana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "278.33", "Wrong State Tax for state Louisiana");

		PaystubWebFormPage.selectEmployee_State("Maine");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "357.90", "Wrong State Tax for state Maine");

		PaystubWebFormPage.selectEmployee_State("Maryland");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "357.02", "Wrong State Tax for state Maryland");

		PaystubWebFormPage.selectEmployee_State("Massachusetts");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "400.00", "Wrong State Tax for state Massachusetts");

		PaystubWebFormPage.selectEmployee_State("Michigan");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "340.00", "Wrong State Tax for state Michigan");

		PaystubWebFormPage.selectEmployee_State("Minnesota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "348.20", "Wrong State Tax for state Minnesota");

		PaystubWebFormPage.selectEmployee_State("Mississippi");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "358.33", "Wrong State Tax for state Mississippi");

		PaystubWebFormPage.selectEmployee_State("Missouri");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "299.72", "Wrong State Tax for state Missouri");

		PaystubWebFormPage.selectEmployee_State("Montana");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "446.52", "Wrong State Tax for state Montana");

		PaystubWebFormPage.selectEmployee_State("Nebraska");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "304.72", "Wrong State Tax for state Nebraska");

		PaystubWebFormPage.selectEmployee_State("Nevada");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Nevada");

		PaystubWebFormPage.selectEmployee_State("New Hampshire");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state New Hampshire");

		PaystubWebFormPage.selectEmployee_State("New Jersey");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "210.75", "Wrong State Tax for state New Jersey");

		PaystubWebFormPage.selectEmployee_State("New Mexico");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "252.24", "Wrong State Tax for state New Mexico");

		PaystubWebFormPage.selectEmployee_State("New York");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "353.91", "Wrong State Tax for state New York");

		PaystubWebFormPage.selectEmployee_State("North Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "293.16", "Wrong State Tax for state North Carolina");

		PaystubWebFormPage.selectEmployee_State("North Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "66.14", "Wrong State Tax for state North Dakota");

		PaystubWebFormPage.selectEmployee_State("Ohio");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "186.38", "Wrong State Tax for state Ohio");

		PaystubWebFormPage.selectEmployee_State("Oklahoma");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "300.15", "Wrong State Tax for state Oklahoma");

		PaystubWebFormPage.selectEmployee_State("Oregon");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "621.88", "Wrong State Tax for state Oregon");

		PaystubWebFormPage.selectEmployee_State("Pennsylvania");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "245.60", "Wrong State Tax for state Pennsylvania");

		PaystubWebFormPage.selectEmployee_State("Rhode Island");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "249.54", "Wrong State Tax for state Rhode Island");

		PaystubWebFormPage.selectEmployee_State("South Carolina");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "363.51", "Wrong State Tax for state South Carolina");

		PaystubWebFormPage.selectEmployee_State("South Dakota");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state South Dakota");

		PaystubWebFormPage.selectEmployee_State("Tennessee");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Tennessee");

		PaystubWebFormPage.selectEmployee_State("Texas");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Texas");

		PaystubWebFormPage.selectEmployee_State("Utah");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "396.00", "Wrong State Tax for state Utah");

		PaystubWebFormPage.selectEmployee_State("Vermont");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "272.90", "Wrong State Tax for state Vermont");

		PaystubWebFormPage.selectEmployee_State("Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "395.42", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Washington");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Washington");

		PaystubWebFormPage.selectEmployee_State("West Virginia");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "426.25", "Wrong State Tax for state Virginia");

		PaystubWebFormPage.selectEmployee_State("Wisconsin");
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "293.46", "Wrong State Tax for state Wisconsin");

		PaystubWebFormPage.selectEmployee_State("Wyomin"); // correct state is Wyoming need to fix this.
		StateTaxTotal = paystubTemplate1.getStateTaxTotalTemplate1();
		soft5.assertEquals(StateTaxTotal, "0.00", "Wrong State Tax for state Wyomin");
		soft5.assertAll();
	}

	@Test(dataProvider = "sdiStates", description = "Verify SDI tax calculations with martial status as 'Single' for the state= 'California' with ytdtotal as '400','800',8000,80000")
	public void VerifySDITaxCalculationsonTemplate1(String states) throws InterruptedException {
		SoftAssert soft6 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State(states);
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		if (states == "California") {
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "4.80");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "9.60");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "96.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "960.00");
		} else if (states == "Hawaii") {
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "4.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "22.04");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "22.04");
		} else if (states == "New Jersey") {
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "1.88");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "3.76");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "37.60");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "157.45");
		} else if (states == "New York") {
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.04");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.04");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "2.04");
		} else if (states == "Rhode Island") {
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "4.80");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "9.60");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "96.00");

			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft6.assertEquals(paystubTemplate1.getSDITaxTotalTemplate1(), "817.20");
		}

		soft6.assertAll("The SDI Values are wrong for the state " + states);
	}

	@DataProvider(name = "sdiStates")
	public Object[] sdiStates() {

		Object[] sdiStates = new Object[5];
		sdiStates[0] = "California";
		sdiStates[1] = "Hawaii";
		sdiStates[2] = "New Jersey";
		sdiStates[3] = "New York";
		sdiStates[4] = "Rhode Island";
		return sdiStates;
	}

	@Test(dataProvider = "suiStates", description = "Verify SUI tax calculations with martial status as 'Single' with ytdtotal as '400','800','8000','80000'")
	public void Verify_SUI_Tax_Calculations_on_Template1_with_State(String states) throws InterruptedException {
		SoftAssert soft7 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State(states);
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		if (states == "Alaska") {
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "2.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "4.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "40.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "199.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "199.00");
		}else if(states == "New Jersey")
		{
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "1.53");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "3.06");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "30.60");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "128.14");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "128.14");
		}else if(states == "Pennsylvania")
		{
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "0.28");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "0.56");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "5.60");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "56.00");
			paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
			soft7.assertEquals(paystubTemplate1.getSUITaxTotalTemplate1(), "560.00");
		}
		soft7.assertAll("The SUI Values are wrong for the state " + states);
		
	}

	@DataProvider(name = "suiStates")
	public Object[] suiStates() {

		Object[] suiStates = new Object[3];
		suiStates[0] = "Alaska";
		suiStates[1] = "New Jersey";
		suiStates[2] = "Pennsylvania";
		return suiStates;
	}

	@Test(description = "Verify WC tax calculations with martial status as 'Single' with ytdtotal as '400','800','8000','80000' with all 'How often you paid'")
	public void Verify_WC_Tax_Calculations_on_Template1_with_State() throws InterruptedException {
		SoftAssert soft8 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		
		PaystubWebFormPage.selectEmployee_State("Oregon");
		//PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month only)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.57");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.13");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "11.21");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "112.01");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1,120.01");
		
		PaystubWebFormPage.select_how_often_you_paid("Daily");
		PaystubWebFormPage.selectEmployee_State("New Mexico");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.02");
		
		PaystubWebFormPage.select_how_often_you_paid("Weekly (ex: every Friday)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.15");
		
		PaystubWebFormPage.select_how_often_you_paid("Bi-Weekly (ex: every other Wednesday)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.31");
		
		PaystubWebFormPage.select_how_often_you_paid("Semi-Monthly (ex: 1st and 15th)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.33");
		
		PaystubWebFormPage.select_how_often_you_paid("Monthly (ex: 1st of month only)");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "0.65");
		
		PaystubWebFormPage.select_how_often_you_paid("Quarterly");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "1.95");
		
		PaystubWebFormPage.select_how_often_you_paid("Semi-Annually");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "3.90");
		
		PaystubWebFormPage.select_how_often_you_paid("Annually");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft8.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		
		soft8.assertAll("The WC Values are wrong");
	}
	
	@Test(description = "Verify FLI-FLV tax calculations with martial status as 'Single' with ytdtotal as '400','800','8000','80000'")
	public void Verify_FLIFLV_Tax_Calculations_on_Template1_with_State() throws InterruptedException {
		SoftAssert soft9 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40"); // YtdTotal = 400
		soft9.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80"); // YtdTotal = 800
		soft9.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800"); // YtdTotal = 8000
		soft9.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "8000"); // YtdTotal = 80000
		soft9.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80000"); // YtdTotal = 800000
		soft9.assertEquals(paystubTemplate1.getWCTaxTotalTemplate1(), "7.80");
	}
	@Test(enabled = false)
	public void getexcelData() {
		System.out.println(ExcelData.getData(0, 4, 1).getStringCellValue());
	}
	@Test(description= "Verify Workforce Development tax when Gross Pay YTD total is less than 33500")
	public void calculateWorkforceDevelopment() throws InterruptedException
	{
		SoftAssert soft10 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "10");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "80");
		soft10.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "0.34");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "800");
		soft10.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "3.40");
		soft10.assertAll();
	}
	@Test(description= "Verify Workforce Development tax when Gross Pay YTD total is equal to 33500")
	public void calculateWorkforceDevelopment2() throws InterruptedException
	{
		//SoftAssert soft10 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "1");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "33500");
		Assert.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "14.24");
	}
	@Test(description= "Verify Workforce Development tax when Gross Pay YTD total is greater than 33500")
	public void calculateWorkforceDevelopment3() throws InterruptedException
	{
		//SoftAssert soft10 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "1");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "40000");
		Assert.assertEquals(paystubTemplate1.getTemplate1WorkForceDevTaxTotal(), "14.24");
	}
	@Test(description="Verify Total calculations for all type of earnings")
	public void calculateTotalEarnings() throws InterruptedException
	{
		SoftAssert soft11 = new SoftAssert();
		browserdriver.navigate().refresh();
		browserdriver.manage().window().maximize();
		PaystubWebFormPage.selectEmployee_State("New Jersey");
		PaystubWebFormPage.enterPay_period_start(1, "2022", "Jan", "1");
		PaystubWebFormPage.enterRegularRates(1, "2");
		paystubTemplate1 = PaystubWebFormPage.enterRegularHours(1, "300");
		soft11.assertEquals(PaystubWebFormPage.getRegularTotal(1), "600");
		
		
	}
	

}