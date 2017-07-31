import java.io.File;

import library.E_FrameWork;

public class WalletHub_Test {
	static File currentDirectory;
	static String TestData;
	static String TestReport;
	static String ObjRepo;
	static E_FrameWork driv;

	public static void main(String[] args) throws Exception {
		currentDirectory = new File(new File(".").getAbsolutePath());
		// Path of TestData folder where test data files are kept (Image and
		// TestData.xlsx)
		TestData = currentDirectory.getCanonicalPath() + "\\Data_Files\\";
		System.out.println("Test Data path :" + TestData);
		// Path of Report folder
		TestReport = currentDirectory.getCanonicalPath() + "\\TestReport\\";
		// Path of Object repository
		ObjRepo = currentDirectory.getCanonicalPath() + "\\ObjRepo\\";
		System.out.println("Obj Repo path :" + ObjRepo);
		// Called Library class (E_Fraemework.java)
		driv = new E_FrameWork();
		driv.E_CallWebObjectsFile(ObjRepo + "TestObj.properties");
		driv.EReport_CreateHTMLReport(TestReport + "TestReport");
		driv.ETestData_File(TestData + "InputData.xlsx");
		driv.ETestData_FileSheetAndRow("Sheet1", 1);

		// Execute the scripts in following sequence
		Login(); // Step 1 - Login into website
		Rating(); // Step 2 - Select Five Star Rating
		PostReview(); // Step 3 - Post the Review Comments
		OpenReviews(); // Step 4 - Open Profile > Reviews Tab
		OpenActivity();// Step 5 - Open Profile > Activity Tab and verify the Posted Comments Same or not
						
		Close_Browser(); // Close the browser. In firefox selenium 3.0 have
							// limitation of quit() method

		// Files Close
		driv.Efile_CloseALL();
	}

	// Step 1 - Login into website
	public static void Login() throws Exception {
		driv.EReport_CreateHTMLReport("Login");
		System.out.println("\n\n= = = = 'LOGIN' TEST SCENARIO STARTED = = = =");
		// Access the URL from TestData.xlsx
		driv.E_LoadURL("#URL");
		driv.E_WaitForPageLoad();
		// Click on Login Link
		driv.E_Click("Login_Link.CLASS");
		driv.E_WaitUntilElementDisplay("Email.XPATH");
		// Get the Email id test data from TestData.xlsx and enter into email id text box

		driv.E_Write("Email.XPATH", "#Email_ID");
		// Get the Password test data from TestData.xlsx and enter into password text box
		driv.E_Write("Password.XPATH", "#Password");
		// Click on Login button
		driv.E_Click("Login_Btn.XPATH");
		// Wait for page load
		driv.E_WaitForPageLoad();
		// driv.E_LoadURL("http://wallethub.com/profile/test_insurance_company/");

		System.out.println("\n\n= = = = 'LOGIN' TEST SCENARIO ENDED = = = =");
	}
	//Step 2 - Select Five Star Rating
	public static void Rating() throws Exception {

		System.out
				.println("\n\n= = = = 'Rating' TEST SCENARIO STARTED = = = =");
		// Open URL
		driv.E_LoadURL("http://wallethub.com/profile/test_insurance_company/");
		driv.E_WaitForPageLoad();
		//Select FIve Start Rating
		driv.E_MouseHover("Rating.XPATH", "Five_Start.XPATH");
		System.out.println("\n\n= = = = 'Rating' TEST SCENARIO ENDED = = = =");
	}
	// Step 3 - Post the Review Comments
	public static void PostReview() throws Exception {
		System.out
				.println("\n\n= = = = 'Plicy Review' TEST SCENARIO STARTED = = = =");
		//Select Policy Drop Down
		driv.E_SelectDropDown("PolicyDD.XPATH", "Health.XPATH");
		driv.E_WaitForPageLoad();
		//Select Five Start Rating
		driv.E_Click("OverallRating.XPATH");
		driv.E_WaitForPageLoad();
		//Enter Review Comment
		driv.E_Write("txt_Review.ID", "#Comment");
		driv.E_WaitForPageLoad();
		//Click on Submit Button
		driv.E_Click("btnSubmit.XPATH");
		driv.E_WaitForPageLoad();
		System.out.println("\n\n= = = = 'Rating' TEST SCENARIO ENDED = = = =");
	}
	// Step 4 - Open Profile > Reviews Tab
	public static void OpenReviews() throws Exception {
		System.out
				.println("\n\n= = = = 'Open Reviews Tab' TEST SCENARIO STARTED = = = =");
		//Mouse hover on Login User and go to Profile page
		driv.E_MouseHover("LoginUser.XPATH", "ProfileMenu.XPATH");
		driv.E_WaitForPageLoad();
		//Open Review Tab
		driv.E_Click("ReviewsTab.XPATH");
		driv.E_WaitForPageLoad();
		System.out
				.println("\n\n= = = = 'Open Reviews Tab' TEST SCENARIO ENDED = = = =");
	}
	//Step 5 - Open Profile > Activity Tab and verify the Posted Comments Same or not
	public static void OpenActivity() throws Exception {
		System.out
				.println("\n\n= = = = 'Open Activity Tab' TEST SCENARIO STARTED = = = =");
		//Open Activity Tab
		driv.E_Click("ActivityTab.XPATH");
		driv.E_WaitForPageLoad();
		//Get the Feed Data
		String FeedData = driv.E_GetData("Feed.XPATH");
		driv.E_WaitForPageLoad();
		//Get Entered Test Data from TestData file
		String TestData = driv.ETestData_GetData("Comment");
		//Verify FeedData with Entered Test Data
		driv.E_VerifyDataWithTestData(FeedData, TestData);

		System.out
				.println("\n\n= = = = 'Open Activity Tab' TEST SCENARIO ENDED = = = =");
	}

	// Close the browser - Known issue with Fire fox browser to close it
	public static void Close_Browser() throws Exception {
		driv.EReport_CreateHTMLReport("End Test and Closing the Browser");
		driv.Close_Browser();
	}

}
