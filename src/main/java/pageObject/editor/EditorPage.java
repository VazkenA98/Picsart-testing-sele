package pageObject.editor;

import enums.EditorTypes;
import helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.base.BasePage;

import java.util.List;

import static config.DriverSetup.getDriver;

public class EditorPage extends BasePage<EditorPage> {

    @FindBy(css = "[class*='sidebarTooltipItem']")
    private List<WebElement> slideBarElements;

    @FindBy(css = "[class*='sidebarCategoriesWrapper']")
    private WebElement slideBar;

    private String queryUrl;
    private String url = "/create/editor";

    public EditorPage(){
        PageFactory.initElements(getDriver(), this);
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


}
