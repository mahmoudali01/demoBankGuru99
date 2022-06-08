import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginTest {


        WebDriver driver = null;
        SoftAssert soft = new SoftAssert();
    loginPage login;

//    public loginTest() throws Exception {
//    }

    //    public void loginSteps(String username , String password){
//        login.usernameElementPOM(driver).clear();
//        login.usernameElementPOM(driver).sendKeys(username);
//        login.passElementPOM(driver).sendKeys(password);
//        login.passElementPOM(driver).sendKeys(Keys.ENTER);
//
//    }
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

        @Test
        void test() throws Exception {
            String [][]testData= Util.getDataFromExcel(Util.FILE_PATH,Util.SHEET_NAME,Util.TABLE_NAME);

            for (int i = 0 ; i< testData.length;i++){
          login.loginSteps(testData[i][0], testData[i][1]);}



         //   String er ="You logged into a secure area!";

           // String ar = login.flashPOM().getText();
//            soft.assertEquals(ar.contains(er),true);
//            soft.assertTrue(ar.contains(er));
           // driver.findElement(By.cssSelector("a[href=\"/logout\"]"));
           // soft.assertAll();
            Thread.sleep(3000);
        }
//        @Test
//        void invaildData() throws InterruptedException {
//            login.loginSteps( "invalid", "invalid!");
//
////            driver.findElement(By.id("username")).clear();
////
////            driver.findElement(By.id("username")).sendKeys("wrong");
////            driver.findElement(By.id("password")).sendKeys("wrong!");
////            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
////            String er ="Your username is invalid!";
////            String ar =  login.flashPOM().getText();
////            soft.assertEquals(ar.contains(er),true);
////            soft.assertTrue(ar.contains(er));
////            soft.assertAll();
//
//            Thread.sleep(3000);
//        }
        @AfterTest
        void closeDriver(){
            driver.quit();
        }



}
