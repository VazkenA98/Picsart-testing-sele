package pageObject.editor;

import enums.EditorTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.base.BasePage;

import java.util.List;

public class EditorPage extends BasePage {

    private List<WebElement> slideBarElements = driver.findElements(By.cssSelector("[class*='sidebarTooltipItem']"));

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
        return slideBarElements.size();
    }
}
