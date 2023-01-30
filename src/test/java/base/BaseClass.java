package base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;

import MobileApp.BillGenratorMobileApp2.PageObject.Android.CommonFormElements;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Dashboard;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.FlashScreen;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.LoginScreen;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.OrderPage;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.SideNevigationMenu;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.ThankYouPage;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtilityFormStep2;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtilityPreviewPage;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtiltiyFormStep1;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtiltiyFormStep3;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm.UtiltiyFormStep4;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import mobileApp.BillGenrator.CommonReuablescenarios;
import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep1;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep2;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep3;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep4;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep5;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2FormStep6;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.W2Form.W2PreviewPage;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep1;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep2;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep3;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep4;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep5;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoiceFormStep6;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.InvoiceForm.InvoicePreviewPage;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.MiscFormStep1;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.MiscFormStep2;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.MiscFormStep3;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.MiscFormStep4;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.MiscFormStep5;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.MiscFormStep6;
import MobileApp.BillGenratorMobileApp2.PageObject.Android.Misc1099.Misc1099Preview;
import WebApp.BillGenratorWebApp.Paystub.PaystubWebFormPage;
import WebApp.BillGenratorWebApp.Paystub.paystubTemplate1;
import base.ExcelData;

public class BaseClass {
	public AndroidDriver driver;
	public WebDriver browserdriver;
	// WebDriver webdriver1;
	AppiumDriverLocalService service;
	ExtentReports extent;
	public String CustomerServiceNo;
	public final String url = "file:///D://ShashankWork/Marquee Workspace/Marquee Solutions Work/Automation 2/BillGenratorMobileApp2/test.pdf";
	public ExcelData ExcelData;
	public final String[] verifyContentInPDf1 = null;
	public Properties propConnection = new Properties();
	public Dashboard dashboard;
	public SideNevigationMenu SideNevigationMenu;
	public ReusableMethods ReusableMethods;
	public UtiltiyFormStep1 utilityFormsStep1;
	public UtilityFormStep2 utilityFormsStep2;
	public UtiltiyFormStep3 utilityFormsStep3;
	public FlashScreen flashscreen;
	public LoginScreen loginScreen;
	public W2FormStep1 W2FormStep1;
	public W2FormStep2 W2FormStep2;
	public W2FormStep3 W2FormStep3;
	public W2FormStep4 W2FormStep4;
	public W2FormStep5 W2FormStep5;
	public W2FormStep6 W2FormStep6;
	public W2PreviewPage W2PreviewPage;
	public WebDriverWait Expwait;
	public Wait fwait;
	public UtilityPreviewPage Utilitypreview;
	public UtiltiyFormStep4 UtiltiyFormStep4;
	public CommonFormElements commonformElements;
	public OrderPage orderp;
	public CommonReuablescenarios CommonReuablescenarios;
	public ThankYouPage thankyoupage;
	public InvoiceFormStep1 InvoiceFormStep1;
	public InvoiceFormStep2 InvoiceFormStep2;
	public InvoiceFormStep3 InvoiceFormStep3;
	public InvoiceFormStep4 InvoiceFormStep4;
	public InvoiceFormStep5 InvoiceFormStep5;
	public InvoiceFormStep6 InvoiceFormStep6;
	public InvoicePreviewPage InvoicePreviewPage;
	public MiscFormStep1 MiscFormStep1;
	public MiscFormStep2 MiscFormStep2;
	public MiscFormStep3 MiscFormStep3;
	public MiscFormStep4 MiscFormStep4;
	public MiscFormStep5 MiscFormStep5;
	public MiscFormStep6 MiscFormStep6;
	public Misc1099Preview Misc1099Preview;
	public PaystubWebFormPage PaystubWebFormPage;
	public paystubTemplate1 paystubTemplate1;
	public WebApp.BillGenratorWebApp.Paystub.paystubTemplate2 paystubTemplate2;
	public WebApp.BillGenratorWebApp.Paystub.paystubTemplate3 paystubTemplate3;
	public WebApp.BillGenratorWebApp.Paystub.paystubTemplate4 paystubTemplate4;
	public WebApp.BillGenratorWebApp.Paystub.paystubTemplate5 paystubTemplate5;
	public WebApp.BillGenratorWebApp.Paystub.paystubTemplate6 paystubTemplate6;

	public int nos_calls;

	public void loadProperties() throws IOException {
		FileInputStream inputstreemconnection = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\Connection.properties");
		FileInputStream inputstreemLoginData = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\LoginData.properties");
		FileInputStream inputstreemUtilityData = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\UtilityData.properties");
		FileInputStream inputstreemCommonData = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\CommonData.properties");
		FileInputStream inputstreemW2Data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\W2Data.properties");
		FileInputStream inputstreemInvoiceData = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\InvoiceForm.properties");
		FileInputStream inputstreemMISC = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\MISC.properties");
		FileInputStream inputstreemPaystub = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MobileApp\\dataResource\\Paystubs.properties");

		propConnection.load(inputstreemconnection);
		propConnection.load(inputstreemLoginData);
		propConnection.load(inputstreemUtilityData);
		propConnection.load(inputstreemCommonData);
		propConnection.load(inputstreemW2Data);
		propConnection.load(inputstreemInvoiceData);
		propConnection.load(inputstreemMISC);
		propConnection.load(inputstreemPaystub);
		ExcelData = new base.ExcelData(); 
	}

	public void ConfigurAndroid() throws IOException {

		loadProperties();
		String port = propConnection.getProperty("Port");
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Marquee\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(propConnection.getProperty("IPAddress")).usingPort(Integer.parseInt(port)).build();
		service.start();

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.example.billgenerator");
		desiredCapabilities.setCapability("appActivity", "com.example.billgenerator.MainActivity");
		desiredCapabilities.setCapability("newCommandTimeout", 90000);
		desiredCapabilities.setCapability("autoGrantPermissions", "true");
//		 UiAutomator2Options options = new UiAutomator2Options();
//		 options.setPlatformName("Android"); 
//		 options.setPlatformVersion("12");
//		 options.setDeviceName("Pixel_2_API_31");
//		 options.setAutomationName("uiautomator2");
//		 options.setAppPackage("com.example.billgenerator");
//		 options.setAppActivity("com.example.billgenerator.MainActivity");

		// OR use 127.0.0.1:4723
		// Setting system properties of ChromeDriver
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), desiredCapabilities);
		turnonwait();
		Expwait = new WebDriverWait(driver, Duration.ofSeconds(30));
		flashscreen = new FlashScreen(driver);
	}

	public void configureBrowser() throws IOException {
		loadProperties();
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: propConnection.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
			// Headless mode
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			// browserdriver = new ChromeDriver(options);
			// Creating an object of ChromeDriver
			browserdriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
			// Headless mode
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			// Creating an object of ChromeDriver
			browserdriver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			// Set the driver path
			System.setProperty("webdriver.edge.driver", ".//msedgedriver.exe");
			// Start Edge Session
			// Headless mode
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			// Creating an object of ChromeDriver
			browserdriver = new EdgeDriver();
		}

		PaystubWebFormPage = new PaystubWebFormPage(browserdriver);
	}

	public void turnonwait() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			browserdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void turnonwaitforseconds(long s) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
			browserdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void turnoffwait() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			browserdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void trunonFluentwait() {
		Wait fwait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class);
	}

	public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		String destinationfile1 = System.getProperty("user.dir") + "\\reports\\FailTestCasesScreenshots\\"
				+ testCaseName + ".png";
		FileUtils.copyFile(source1, new File(destinationfile1));
		return destinationfile1;
	}

	public String getScreenshotPathWeb(String testCaseName, WebDriver browserdriver) throws IOException {
		File source1 = ((RemoteWebDriver) browserdriver).getScreenshotAs(OutputType.FILE);
		String destinationfile1 = System.getProperty("user.dir") + "\\reports\\FailTestCasesScreenshots\\"
				+ testCaseName + ".png";
		FileUtils.copyFile(source1, new File(destinationfile1));
		return destinationfile1;
	}

	public String getScreenshot(String testCaseName, AndroidDriver driver1) throws IOException {
		File source2 = driver1.getScreenshotAs(OutputType.FILE);
		String destinationfile2 = System.getProperty("user.dir")
				+ "\\reports\\RequiredCaseScreenshotForDataComparision\\" + testCaseName + ".png";
		FileUtils.copyFile(source2, new File(destinationfile2));
		return destinationfile2;
	}

//	public UtiltiyFormStep4 EnterAllUtilityform(SideNevigationMenu sideNevigationMenu) throws InterruptedException {
//		try {
//
//			utilityFormsStep1 = sideNevigationMenu.ClickUtilityBill();
//			Thread.sleep(4000l);
//			utilityFormsStep1.ClickUtilityLogo();// //Click Utility Logo
//			utilityFormsStep1.ClickGallery(); // Click gallery
//			utilityFormsStep1.ClickonImage();
//			utilityFormsStep1.enterYourName(propConnection.getProperty("YourName"));
//			utilityFormsStep1.enterYourStreetAddress(propConnection.getProperty("YourStreetAdd"));
//			driver.hideKeyboard();
//			utilityFormsStep1.EnterCity(propConnection.getProperty("YourCity"));
//			driver.hideKeyboard();
//			utilityFormsStep1.EnterZip(propConnection.getProperty("YourZip"));
//			utilityFormsStep1.SelectState();// default california is selected
//			utilityFormsStep2 = utilityFormsStep1.pressNextButton();
//			utilityFormsStep2.enterCompanyName(propConnection.getProperty("CompanyName"));
//			utilityFormsStep2.enterCompanyStreetAddress(propConnection.getProperty("CompanyStreetAddress"));
//			utilityFormsStep2.enterCompanyCity(propConnection.getProperty("CompanyCity"));
//			utilityFormsStep2.selectState();
//			utilityFormsStep2.enterCompanyZip(propConnection.getProperty("CompanyZip"));
//			utilityFormsStep3 = utilityFormsStep2.pressNextButton();
//			utilityFormsStep3.enterStatementDate(propConnection.getProperty("StatementDate"));
//			utilityFormsStep3.enterPaymentDueAmount(propConnection.getProperty("PaymentDueAmountString"));
//			utilityFormsStep3.enterPreviousStatementAmount(propConnection.getProperty("PreviousStateAmount"));
//			UtiltiyFormStep4 = utilityFormsStep3.pressNextButton();
//			UtiltiyFormStep4.enterWebsiteURL(propConnection.getProperty("WebsiteURL"));
//			CustomerServiceNo = UtiltiyFormStep4.getCustomerServiceNo();
//
//		} catch (NoSuchElementException e) {
//
//			e.printStackTrace();
//		}
//		return UtiltiyFormStep4;
//	}

	public FlashScreen restartapp() {
		driver.closeApp();
		driver.launchApp();
		flashscreen = new FlashScreen(driver);
		return flashscreen;
	}

	@AfterSuite
	public void teardown() throws InterruptedException {

		try {
			//Thread.sleep(150000l);
			browserdriver.quit();
			driver.quit();
			service.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	public void LoginWithValidCred() throws InterruptedException {

		Thread.sleep(4000l);
		Dashboard dash = new Dashboard(driver);
		loginScreen = dash.pressLogin();

		loginScreen.EnterUserEmail(propConnection.getProperty("username"));
		loginScreen.EnterPassword(propConnection.getProperty("pass"));
		loginScreen.pressSignIn();
	}

////////////////////////////////////////////////////////////////////////
	private int counter;

	public boolean pullFileFromDevice(String formtype, final String filename) throws IOException {

		File file;
		String s;
		int count = counter++;
		System.out.println("Pull Function called till now: " + count);
		try {
			byte[] pdfFile = driver.pullFile("/sdcard/Documents/BillGenerate/" + formtype + "/" + filename + ".pdf");
			s = Base64.getEncoder().encodeToString(pdfFile);
			System.out.println(s);
			file = new File("./test.pdf");

			try (FileOutputStream fos = new FileOutputStream(file);) {
				// To be short I use a corrupted PDF string, so make sure to use a valid one if
				// you want to preview the PDF file
				byte[] decoder = Base64.getDecoder().decode(s);

				fos.write(decoder);
				System.out.println("PDF File Saved");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (WebDriverException e1) {
			// TODO Auto-generated catch block
			System.out.println("The file name provided does not exist in the device with name: " + filename + ".pdf");
			return false;
		}
		return true;
	}

	public int getCountOfFilePulled() {
		return counter;
	}

	protected static String readPdfContent(final String url) throws IOException {
		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		int numberOfPages = getPageCount(doc);
		System.out.println("The total number of pages " + numberOfPages);
		String content = new PDFTextStripper().getText(doc);
		doc.close();

		return content;
	}

	private static int getPageCount(PDDocument doc) {
		int pageCount = doc.getNumberOfPages();
		return pageCount;
	}

	String strDate1;
	Date date;
	DateFormat format;

	public String getcurrentMM_dd_yyyy_HH_mm_ss() throws ParseException {
		date = new Date(System.currentTimeMillis());
		format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss", Locale.ENGLISH);
		strDate1 = format.format(date);
		System.out.println("Current date in String Format: " + strDate1);
		return strDate1;
	}

	public String getcurrentMM_dd_yyyy_HH_mm_ssMinusOneSec() throws ParseException {

		LocalDateTime datetime2 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime newYearsEve2 = datetime2.minusSeconds(1);
		Date FinalDateTime2 = Date.from(newYearsEve2.atZone(ZoneId.systemDefault()).toInstant());
		String strDate2 = format.format(FinalDateTime2);
		System.out.println("Date Time with 1 second minus= " + strDate2);
		return strDate2;
	}

	public String getcurrentMM_dd_yyyy_HH_mm_ssPlusOneSec() throws ParseException {

		LocalDateTime datetime3 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime newYearsEve3 = datetime3.plusSeconds(1);
		Date FinalDateTime3 = Date.from(newYearsEve3.atZone(ZoneId.systemDefault()).toInstant());
		String strDate3 = format.format(FinalDateTime3);
		System.out.println("Date Time with 1 second added= " + strDate3);
		return strDate3;
	}
}
