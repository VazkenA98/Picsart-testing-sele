package pageObject.base;

import helper.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.editor.EditorPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static config.DriverSetup.getDriver;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected WebDriver driver;
    public static final String BASE_URL="https://picsart.com";
    public static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public BasePage() {
        this.driver = getDriver();
    }

    public abstract String getUrl();

    protected T initPage() {
        PageFactory.initElements(getDriver(), this);
        LOGGER.info("Initialising to " + getDriver().getCurrentUrl());
        return (T) this;
    }
    @Override
    protected void load() {
        driver.get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.waitForPageReady();
    }


    protected void open(String url) {
        System.out.println("Opening url -> " + url);
        driver.get(url);
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    protected boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected WebElement find(By location) {
        WaitHelper.waitUntilElementIsVisible(location);
        return driver.findElement(location);
    }

    protected void type(By location, String text) {
        type(find(location), text);
    }

    protected void type(WebElement element, String text) {
        System.out.println("Typing " + text +" to field  -> " + element.toString());
        WaitHelper.waitUntilElementIsClickable(element);
        element.sendKeys(text);
    }

    protected void click(By location) {
        System.out.println("Clicking on element -> " + location.toString());
        click(find(location));
    }

    protected void click(WebElement element) {
        clickActions(element);
        element.click();
    }
    protected void clickAndOpenNewTab(By location) {
        clickActions(find(location));
        System.out.println("Clicking on element -> " + location.toString());
        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(windowHandles.size() - 1));
    }

    protected void displayNoneToElement(WebElement element) {
        clickActions(element);
        System.out.println("Clicking on element -> " + element.toString());
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute('display', 'none');", element);
    }

    protected void clickActions(WebElement element) {
        WaitHelper.waitUntilElementIsVisible(element);
        WaitHelper.waitUntilElementIsClickable(element);
        new Actions(getDriver()).moveToElement(element).click().build().perform();
    }

    public List<WebElement> findAll(By location) {
        System.out.println("Finding elements -> " + location.toString());
        return driver.findElements(location);
    }

    protected void clickAndSwitchToNextTab(By location) {
        WaitHelper.waitUntilElementIsClickable(find(location));
        System.out.println("Clicking on element -> " + location.toString());
        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(windowHandles.size() - 1));
    }

    protected void hoverByText(By elements, String text) {
        Actions action = new Actions(getDriver());
        driver.findElements(elements).stream()
                .filter(e -> Objects.equals(e.getText(), text))
                .findAny()
                .ifPresent(element -> action.moveToElement(element).click().build().perform());
    }

    protected void scrollTo(By location) {
        System.out.println("Scrolling to element -> " + location.toString());
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", find(location));
    }
    protected void clickByJS(By location) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", find(location));
    }

    protected void scrollAndClick(By location){
        scrollTo(location);
        clickByJS(location);
    }


}
