import java.io.File;
import library.E_FrameWork;

	public class WalletHub_Test {
	static File currentDirectory;
	static String TestData;
	static String TestReport;
	static String ObjRepo;
	static E_FrameWork driv;
	public static void main(String[] args) throws Exception{
		currentDirectory = new File(new File(".").getAbsolutePath());
		// Path of TestData folder where test data files are kept (Image and TestData.xlsx)
		TestData = currentDirectory.getCanonicalPath()+"\\Data_Files\\";
		System.out.println("Test Data path :"+TestData);
		// Path of Report folder
		TestReport = currentDirectory.getCanonicalPath()+"\\TestReport\\";
		// Path of Object repository
		ObjRepo = currentDirectory.getCanonicalPath()+"\\ObjRepo\\";
		System.out.println("Obj Repo path :"+ObjRepo);
		//Called Library class (E_Fraemework.java)
		driv = new E_FrameWork();
		//System.setProperty("webdriver.gecko.driver", "D:\\Samir_QAEngineer_CMS\\Task3\\Code\\CMS_Automation\\Jars\\Browser Drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://wallethub.com/");
		driv.E_CallWebObjectsFile(ObjRepo + "TestObj.properties");
		driv.EReport_CreateHTMLReport(TestReport + "TestReport");
		driv.ETestData_File(TestData + "InputData.xlsx");
		driv.ETestData_FileSheetAndRow("Sheet1", 1);
		
		//Execuite the scripts in follwing sequence
		Login(); // Step 1 - Login into Administration website
		//Add_Post(); // Step 2 - Login into Wallet Hub site 
	
		Close_Browser(); // Close the browser. In firefox selenium 3.0 have
							// limitation of quit() method

		// Files Close
		driv.Efile_CloseALL();
	}
	// Step 1 - Login into Administration website
	public static void Login() throws Exception {
		driv.EReport_CreateHTMLReport("Login");
		System.out.println("\n\n= = = = 'LOGIN' TEST SCENARIO STARTED = = = =");
		// Access the URL from TestData.xlsx
		driv.E_LoadURL("#URL");
		driv.E_WaitForPageLoad();
		//Click on Login Link
		driv.E_Click("Login_Link.CLASS");
		driv.E_WaitUntilElementDisplay("Email.XPATH");
		// Get the Email id test data from TestData.xlsx and enter into email id
		// text box
	
		driv.E_Write("Email.XPATH", "#Email_ID");
		// Get the Password test data from TestData.xlsx and enter into email id
		// text box
		driv.E_Write("Password.XPATH", "#Password");
		// Click on Login button
		driv.E_Click("Login_Btn.XPATH");
		// Wait for page load
		driv.E_WaitForPageLoad();
		//driv.E_LoadURL("http://wallethub.com/profile/test_insurance_company/");
		driv.openNewURL("http://wallethub.com/profile/test_insurance_company/");
		driv.E_WaitForPageLoad();
		driv.E_WaitUntilElementDisplay("Rating.XPATH");
		driv.E_Click("Rating.XPATH");
		System.out.println("\n\n= = = = 'LOGIN' TEST SCENARIO ENDED = = = =");
	}

	// Close the browser - Known issue with Fire fox browser to close it
	public static void Close_Browser() throws Exception {
		driv.EReport_CreateHTMLReport("End Test and Closing the Browser");
		driv.Close_Browser();
	}

}
