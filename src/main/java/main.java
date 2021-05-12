import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class main {

    public static ChromeDriver chromeDriver = null;

    public static void main(String[]args){
        onStart();
        clickLoginButton();
        new WebDriverWait(chromeDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement clickLogIn = chromeDriver.findElement(By.cssSelector("[class*='pa-uiLib-authentication-btn primary']"));
        login("Vazken", "123",clickLogIn);
    }
    public static void onStart(){
        System.setProperty("webdriver.chrome.driver","/Users/nubar/Downloads/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("http://picsartstage2.com/");
    }
    public static void clickLoginButton(){
        WebElement loginBut =  chromeDriver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        loginBut.click();
    }
    public static void clickAction(WebElement element){
        new WebDriverWait(chromeDriver, 10).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public static void login(String name, String password, WebElement element) {
        chromeDriver.findElement(By.name("username")).sendKeys(name);
        chromeDriver.findElement(By.name("password")).sendKeys(password);
        if (element.isDisplayed() && element.isEnabled()) {
            System.out.println("Clicking.....");
            clickAction(element);
        }
    }
}
