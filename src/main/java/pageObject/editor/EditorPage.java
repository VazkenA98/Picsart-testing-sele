package pageObject.editor;

import enums.EditorTypes;
import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.base.BasePage;

import java.util.List;

public class EditorPage extends BasePage {

    private final List<WebElement> slideBarElements = driver.findElements(By.cssSelector("[class*='sidebarTooltipItem']"));
    private final List<WebElement> fitButtonItems = driver.findElements(By.cssSelector("[class*='itemName']"));
    private final WebElement fitButton = driver.findElement(By.id("background-category"));
    private final WebElement tipNextButton = driver.findElement(By.cssSelector("[data-test='nextButton']"));


    private final WebElement slideBar = driver.findElement(By.cssSelector("[class*='sidebarCategoriesWrapper']"));

    private String queryUrl;
    private String url = "/create/editor";

    public EditorPage(){
        System.out.println("Opening url -> " + getUrl());
        open(getUrl());
    }

    public EditorPage(EditorTypes editorTypes){
        this.queryUrl = editorTypes.getChooserUrl();
        System.out.println("Opening url -> " + getUrl());
    }

    @Override
    public String getUrl() {
        String query = queryUrl == null ? url : url + "?" + queryUrl;
        return BASE_URL.concat(query);
    }

    public int getSlideBarElementsSize(){
        WaitHelper.waitUntilListElementIsVisible(slideBarElements);
        return slideBarElements.size();
    }

    public int getFitButtonItemsSize(){
        WaitHelper.waitUntilListElementIsVisible(fitButtonItems);
        return fitButtonItems.size();
    }

    public boolean isFitItemDisplayed(int index){
        WaitHelper.waitUntilElementIsVisible(fitButtonItems.get(index));
        return isDisplayed(fitButtonItems.get(index));
    }

    public EditorPage clickFitButton(){
        click(tipNextButton);
        click(fitButton);
        return this;
    }
}
