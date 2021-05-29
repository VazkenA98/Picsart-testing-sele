package pageObject.editor;

import enums.EditorTypes;
import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.base.BasePage;

import java.util.List;

public class EditorPage extends BasePage {

    private final List<WebElement> slideBarElements = driver.findElements(By.cssSelector("[class*='sidebarTooltipItem']"));
    private final By fitButtonItems = By.cssSelector("[class*='itemName']");
    private final By fitButton = By.id("background-category");
    private final By slideBar = By.cssSelector("[class*='sidebarCategoriesWrapper']");

    private String queryUrl;
    private String url = "/create/editor";

    public EditorPage(){

    }

    public EditorPage(EditorTypes editorTypes){
        this.queryUrl = editorTypes.getChooserUrl();
        System.out.println("Opening url -> " + getUrl());
    }

    public EditorPage open(){
        open(getUrl());
        return this;
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
        WaitHelper.waitUntilElementIsVisible(fitButtonItems);
        return findAll(fitButtonItems).size();
    }

    public EditorPage clickFitButton(){
        WaitHelper.waitUntilElementIsClickable(fitButton);
        click(fitButton);
        return this;
    }

    public EditorPage clickFitButtonByJS(){
        WaitHelper.waitUntilElementIsClickable(fitButton);
        clickByJS(fitButton);
        return this;
    }
}
