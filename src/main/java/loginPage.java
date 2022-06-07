import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    private WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
//    @FindBy(id= "username")
//    WebElement usernamePF;
    WebElement usernameElementPOM(){
//        By username = By.id("username");
//        WebElement usernameEle = driver.findElement(username);
//        return  usernameEle;
        return this.driver.findElement(By.name("uid"));
    }
    WebElement passElementPOM(){
//        By pass = By.name("password");
//        WebElement passEle = driver.findElement(pass);
//        return  passEle;
        return this.driver.findElement(By.name("password"));
    }

    public void loginSteps(String username , String password){
        this.driver.navigate().to("https://www.demo.guru99.com/V4/");

        usernameElementPOM().clear();
        usernameElementPOM().sendKeys(username);
//        usernamePF.clear();
//        usernamePF.sendKeys(username);
        passElementPOM().sendKeys(password);
        passElementPOM().sendKeys(Keys.ENTER);
        driver.switchTo().alert().accept();


    }
}
