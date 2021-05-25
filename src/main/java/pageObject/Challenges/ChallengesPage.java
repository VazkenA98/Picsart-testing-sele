package pageObject.Challenges;

import pageObject.base.BasePage;

public class ChallengesPage extends BasePage {

    private String queryUrl;
    private String url = "/challenges";

    public ChallengesPage(){

    }

    public ChallengesPage(String query){
        this.queryUrl = query;
        System.out.println("Opening url -> " + getUrl());
    }


    public ChallengesPage open(){
        open(getUrl());
        return this;
    }

    @Override
    public String getUrl() {
        String query = queryUrl == null ? url : url + "?" + queryUrl;
        return BASE_URL.concat(query);
    }
}
