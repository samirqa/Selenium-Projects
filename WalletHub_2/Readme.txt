This project is Run with Selenium 3
Dependency JDK1.8 and JRR 1.8 or Above should be available and set the path in the system variables

Automation Project Set-up
1. Extract zip folder
2. Default project path is set to "D:\Projects\Selenium-Projects\WalletHub_2"
2. Set the classpath environment variables for the Jars folder included in the project ex.classpath = "D:\Projects\Selenium-Projects\WalletHub_2\Jars\*;
3. Browser drivers exe are in the Jars folder which used in E_Framework.java class under "E_LoadURL(String url)" method
if project folder change then change the path of all browser drivers under this method
4. Run Compile.bat under src folder in order to Compile the Java class
5. Run the Run.bat to execute the project
6. Open TestReport folder to see latest html report in the \\TestReport folder