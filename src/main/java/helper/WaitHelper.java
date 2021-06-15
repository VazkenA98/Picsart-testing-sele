package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static config.DriverSetup.getDriver;

public class WaitHelper {


    public WaitHelper(){

    }

    public static WebElement waitUntilElementIsClickable(WebElement element){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilElementIsClickable(By location){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(location));
    }

    public static WebElement waitUntilElementIsVisible(By location){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(location));
    }

    public static WebElement waitUntilElementIsVisible(WebElement element){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(element));
    }

    public static List<WebElement> waitUntilListElementIsVisible(List<WebElement> fitButtonItems) {
        List<WebElement> webElementList =  new ArrayList<>();
        for(WebElement element:fitButtonItems){
            webElementList.add(waitUntilElementIsVisible(element));
        }
        return webElementList;
    }

    public static void waitForPageReady() {
        new WebDriverWait(getDriver(), 10).until((ExpectedConditions.jsReturnsValue("return document.readyState=='complete';")));

    }
}
