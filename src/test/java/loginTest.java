import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class loginTest {


        WebDriver driver = null;
        SoftAssert soft = new SoftAssert();
    loginPage login;
    String actualBoxMsg, actualTitle;

    @DataProvider(name = "TestData")
    public Object[][] testData() throws Exception {
        return Util.getDataFromExcel(Util.FILE_PATH, Util.SHEET_NAME,
                Util.TABLE_NAME);
    }

        @BeforeTest
        void openBrowser() throws InterruptedException {
            String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            //driver.navigate().to("https://www.demo.guru99.com/V4/");
            driver.manage().window().maximize();
            Thread.sleep(3000);
             login =new loginPage(driver);

        }

        @Test(dataProvider = "TestData")
        void test(String uname,String pass) throws Exception {
           // String [][]testData= Util.getDataFromExcel(Util.FILE_PATH,Util.SHEET_NAME,Util.TABLE_NAME);

//            for (int i = 0 ; i< testData.length;i++){
//          login.loginSteps(testData[i][0], testData[i][1]);}

            login.loginSteps(uname,pass);
            Thread.sleep(3000);
             driver.manage().timeouts()
             .implicitlyWait(20, TimeUnit.SECONDS);
            try{

                Alert alt = driver.switchTo().alert();
                 actualBoxMsg = alt.getText(); // get content of the Alter Message
                alt.accept();
                // Compare Error Text with Expected Error Value
                assertEquals(actualBoxMsg,Util.EXPECT_ERROR);

            }
            catch (NoAlertPresentException Ex){
                actualTitle = driver.getTitle();
                assertEquals(actualTitle,Util.EXPECT_TITLE);
            }

            Thread.sleep(3000);
        }

        @AfterTest
        void closeDriver(){
            driver.quit();
        }



}
